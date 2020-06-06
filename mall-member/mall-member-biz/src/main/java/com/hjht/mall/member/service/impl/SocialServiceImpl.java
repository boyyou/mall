package com.hjht.mall.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.constant.CodeConstant;
import com.hjht.common.constant.OtherConstant;
import com.hjht.common.constant.SocialAccountConstant;
import com.hjht.common.constant.SocialUrlConstant;
import com.hjht.common.entity.CommonUser;
import com.hjht.common.jwt.JwtHelper;
import com.hjht.common.token.TokenUtil;
import com.hjht.common.utils.HttpUtil;
import com.hjht.common.utils.WXAESUtil;
import com.hjht.common.wx.WXPayUtil;
import com.hjht.common.wx.WXPayXmlUtil;
import com.hjht.mall.member.api.constant.EntityConstant;
import com.hjht.mall.member.api.convers.ConversSocial;
import com.hjht.mall.member.api.dto.SocialLoginEntity;
import com.hjht.mall.member.api.entity.MemberEntity;
import com.hjht.mall.member.api.entity.MemberLevelEntity;
import com.hjht.mall.member.api.entity.MemberSocialEntity;
import com.hjht.mall.member.api.vo.CacheUserInfoVO;
import com.hjht.mall.member.api.vo.MemberLoginVO;
import com.hjht.mall.member.dao.MemberDao;
import com.hjht.mall.member.dao.MemberLevelDao;
import com.hjht.mall.member.dao.MemberSocialDao;
import com.hjht.mall.member.service.MemberLevelService;
import com.hjht.mall.member.service.SocialService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2020/5/30 15:42
 * @Created by ycl
 */
@Slf4j
@Service
public class SocialServiceImpl extends ServiceImpl<MemberSocialDao, MemberSocialEntity> implements SocialService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void login(SocialLoginEntity socialLoginEntity) {

    }

    /**
     * 微信小程序登陆
     *
     * @return
     */
    @Override
    public MemberLoginVO callbackWeChat(String code) {
        MemberLoginVO memberLoginVO = new MemberLoginVO();
        //TODO 所有的登陆登出方法应做用户记录
        Map<String, Object> map = new HashMap<>();
        map.put("appid", SocialAccountConstant.WX_APP_ID);
        map.put("secret", SocialAccountConstant.WX_APP_SECRET);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String result = HttpUtil.getByJson(SocialUrlConstant.WX_XCX_LOGIN_URl, map);
        if (StringUtils.isEmpty(result) || result == "null") {
            log.info(result);
            throw new RuntimeException("系统繁忙,请稍后!");
        }
        JSONObject parse = JSONObject.parseObject(result);
        if (parse.get("errcode") == null) {
            Object openId = parse.get("openid");
            List<MemberSocialEntity> memberSocialEntities = baseMapper.selectList(new LambdaQueryWrapper<MemberSocialEntity>().eq(MemberSocialEntity::getType, CodeConstant.WX).
                    eq(MemberSocialEntity::getOnlyId, String.valueOf(openId)));
            //当这个用户已经注册过本系统直接登陆，否则进行注册
            if (CollectionUtil.isNotEmpty(memberSocialEntities)) {
                //生成Token
                String token = TokenUtil.generToken(String.valueOf(memberSocialEntities.get(0).getId()));
                CommonUser commonUser = ConversSocial.coverSocialToMember(memberSocialEntities.get(0).getId(), memberSocialEntities.get(0).getMemberId(), memberSocialEntities.get(0).getNick(), null, memberSocialEntities.get(0).getHeadUrl());
                //设置五个小时过期，类型是三方账号
                redisTemplate.opsForValue().set(token + "_" + OtherConstant.TOKEN_TYPE_SOCIAL, commonUser, OtherConstant.EXPRIE_SECOND, TimeUnit.SECONDS);
                memberLoginVO.setToken(token);
                memberLoginVO.setMemberEntity(commonUser);
                memberLoginVO.setOpenId(String.valueOf(openId));
                return memberLoginVO;
            } else {
                Object unionId = parse.get("unionid");
                MemberSocialEntity memberSocialEntity = new MemberSocialEntity();
                memberSocialEntity.setType(CodeConstant.WX);
                memberSocialEntity.setUnionId(String.valueOf(unionId));
                memberSocialEntity.setOnlyId(String.valueOf(openId));
                Object sessionKey = parse.get("session_key");
                memberSocialEntity.setAccessToken(String.valueOf(sessionKey));
                //暂存redis
                redisTemplate.opsForValue().set(openId, memberSocialEntity, OtherConstant.EXPRIE_SESSION_KEY, TimeUnit.SECONDS);
                //baseMapper.insert(memberSocialEntity);
                /*//因为是注册，未绑手机号所以没有用户表id，暂不进行token生成
                String jwt = JwtHelper.generateJWT(memberSocialEntity.getId()+"_", memberSocialEntities.get(0).getNick(), "");
                return jwt;*/
                memberLoginVO.setOpenId(String.valueOf(openId));
                return memberLoginVO;
            }
        } else {
            throw new RuntimeException(String.valueOf(parse.get("errmsg")));
        }
    }

    /**
     * 用户信息补全，如果用户不存在就补全，存在就登陆
     *
     * @param socialLoginEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public MemberLoginVO completionSocialInfo(SocialLoginEntity socialLoginEntity) {
        MemberLoginVO memberLoginVO = new MemberLoginVO();
        List<MemberSocialEntity> memberSocialEntities = baseMapper.selectList(new LambdaQueryWrapper<MemberSocialEntity>().eq(MemberSocialEntity::getOnlyId, socialLoginEntity.getOpenId()).eq(MemberSocialEntity::getType, CodeConstant.WX));
        //如果这个openid的微信号存在就说明他已经注册过就登陆
        if (CollectionUtil.isNotEmpty(memberSocialEntities)) {
            //生成Token
            String token = TokenUtil.generToken(String.valueOf(memberSocialEntities.get(0).getId()));
            //设置五个小时过期
            CommonUser commonUser = ConversSocial.coverSocialToMember(memberSocialEntities.get(0).getId(), memberSocialEntities.get(0).getMemberId(), memberSocialEntities.get(0).getNick(), null, memberSocialEntities.get(0).getHeadUrl());
            redisTemplate.opsForValue().set(token + "_" + OtherConstant.TOKEN_TYPE_SOCIAL, commonUser, OtherConstant.EXPRIE_SECOND, TimeUnit.SECONDS);
            memberLoginVO.setToken(token);
            return memberLoginVO;
        }
        /*//防止unionid被篡改，置为null，mybatisplus不会去修改这个值
        memberSocialEntity.setUnionId(null);
        memberSocialEntity.setType(CodeConstant.WX);
        baseMapper.update(memberSocialEntity,new UpdateWrapper<MemberSocialEntity>().eq(EntityConstant.TYPE,CodeConstant.WX).eq(EntityConstant.ONLY_ID,memberSocialEntity.getOnlyId()));
        //用户没绑定手机号不存在用户表id
        //生成Token
        String token = TokenUtil.generToken(String.valueOf(memberSocialEntity.getId()));
        CacheUserInfoVO cacheUserInfoVO = new CacheUserInfoVO();
        cacheUserInfoVO.setUserId(memberSocialEntity.getId());
        System.out.println("获取到的id:"+memberSocialEntity.getId());
        //设置半个小时过期
        redisTemplate.opsForValue().set(token,cacheUserInfoVO, OtherConstant.EXPRIE_SECOND, TimeUnit.SECONDS);
        memberLoginVO.setToken(token);*/
        MemberSocialEntity o = (MemberSocialEntity) redisTemplate.opsForValue().get(socialLoginEntity.getOpenId());
        //MemberSocialEntity memberSocialEntity = baseMapper.selectOne(new LambdaQueryWrapper<MemberSocialEntity>().eq(MemberSocialEntity::getOnlyId, socialLoginEntity.getOpenId()));
        String accessToken = o.getAccessToken();
        //解析加密后的电话号码
        try {
            String phone = WXAESUtil.decryptWXAppletInfo(accessToken, socialLoginEntity.getIvPhone(), socialLoginEntity.getEncryptedDataPhone());
            System.out.println("电话号码:" + phone);
            String userInfo = WXAESUtil.decryptWXAppletInfo(accessToken, socialLoginEntity.getIvUserInfo(), socialLoginEntity.getEncryptedDataUserInfo());
            JSONObject jsonObject = JSONObject.parseObject(userInfo);
            System.out.println("接口解析出来的用户信息:" + jsonObject);
            MemberSocialEntity memberSocialEntity1 = new MemberSocialEntity();
            memberSocialEntity1.setNick(String.valueOf(jsonObject.get("nickName")));
            memberSocialEntity1.setCity(String.valueOf(jsonObject.get("city")));
            memberSocialEntity1.setCountry(String.valueOf(jsonObject.get("country")));
            memberSocialEntity1.setType(CodeConstant.WX);
            memberSocialEntity1.setProvince(String.valueOf(jsonObject.get("province")));
            memberSocialEntity1.setHeadUrl(String.valueOf(jsonObject.get("avatarUrl")));
            memberSocialEntity1.setSex(Integer.parseInt(String.valueOf(jsonObject.get("gender"))));
            memberSocialEntity1.setLanguage(String.valueOf(jsonObject.get("language")));
            memberSocialEntity1.setAccessToken(accessToken);
            memberSocialEntity1.setOnlyId(o.getOnlyId());
            memberSocialEntity1.setUnionId(o.getUnionId());
            JSONObject jsonObject1 = JSONObject.parseObject(phone);
            String phoneNumber = String.valueOf(jsonObject1.get("phoneNumber"));
            //判断手机号码，存在就关联，不存在就注册
            if (StringUtils.isNotEmpty(phoneNumber)) {
                List<MemberEntity> memberEntities = memberDao.selectList(new LambdaQueryWrapper<MemberEntity>().eq(MemberEntity::getMobile, phoneNumber));
                if (CollectionUtil.isNotEmpty(memberEntities)) {
                    memberSocialEntity1.setMemberId(memberEntities.get(0).getId());
                } else {
                    MemberEntity memberEntity = new MemberEntity();
                    memberEntity.setMobile(phoneNumber);
                    memberDao.insert(memberEntity);
                    memberSocialEntity1.setMemberId(memberEntity.getId());
                }
            }
            //存储用户
            baseMapper.insert(memberSocialEntity1);
            CommonUser commonUser = ConversSocial.coverSocialToMember(memberSocialEntity1.getId(), memberSocialEntity1.getMemberId(), memberSocialEntity1.getNick(), null, memberSocialEntity1.getHeadUrl());
            memberLoginVO.setMemberEntity(commonUser);
            //生成Token
            String token = TokenUtil.generToken(String.valueOf(memberSocialEntity1.getId()));
            //设置五个小时过期
            redisTemplate.opsForValue().set(token + "_" + OtherConstant.TOKEN_TYPE_SOCIAL, commonUser, OtherConstant.EXPRIE_SECOND, TimeUnit.SECONDS);
            memberLoginVO.setToken(token);
        } catch (Exception e) {
            redisTemplate.delete(socialLoginEntity.getOpenId());
            e.printStackTrace();
            throw new RuntimeException("系统繁忙,请稍后!");
        }
        return memberLoginVO;
    }
}
