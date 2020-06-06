package com.hjht.mall.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.constant.OtherConstant;
import com.hjht.common.constant.RedisConstant;
import com.hjht.common.entity.CommonUser;
import com.hjht.common.token.TokenUtil;
import com.hjht.common.utils.MemberUtil;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.common.utils.R;
import com.hjht.mall.member.api.constant.EntityConstant;
import com.hjht.mall.member.api.dto.MemberLoginDTO;
import com.hjht.mall.member.api.dto.MemberRegisterDTO;
import com.hjht.mall.member.api.entity.MemberEntity;
import com.hjht.mall.member.api.entity.MemberLevelEntity;
import com.hjht.mall.member.api.vo.CacheUserInfoVO;
import com.hjht.mall.member.dao.MemberDao;
import com.hjht.mall.member.dao.MemberLevelDao;
import com.hjht.mall.member.service.MemberService;
import com.hjht.mall.three.api.constant.ExceptionConstant;
import com.hjht.mall.three.api.sms.SendSmsUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MemberLevelDao memberLevelDao;

    @Autowired
    private MemberUtil memberUtil;

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );
        CommonUser user = memberUtil.getUser();
        System.out.println(user.getUsername());
        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMember(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    @Override
    public Object sendSms(String phone) {
        String oldCode = (String)redisTemplate.opsForValue().get(RedisConstant.SSO_SMS_CODE + phone);
        if (StringUtils.isNotEmpty(oldCode)){
            String time = oldCode.split("_")[1];
            //判断发送验证码相隔是否在一分钟内
            if (System.currentTimeMillis() - Long.parseLong(time) <= RedisConstant.DEFAULT_INTERVAL*1000){
                throw new RuntimeException(ExceptionConstant.VERIFICATION_CODE.getMessage());
            }else {
                //生成四位数随机验证码
                String code = RandomUtil.randomNumbers(Integer.parseInt(OtherConstant.SMS_DEFAULT_LENGTH));
                Object o = SendSmsUtil.sendSms(phone, code);
                if (o instanceof Boolean){
                    redisTemplate.opsForValue().set(RedisConstant.SSO_SMS_CODE + phone,code+"_"+System.currentTimeMillis(),RedisConstant.SSO_CACHE_TIME, TimeUnit.SECONDS);
                    return Boolean.TRUE;
                }else {
                    throw new RuntimeException(o.toString());
                }
            }
        }else {
            //生成四位数随机验证码
            String code = RandomUtil.randomNumbers(Integer.parseInt(OtherConstant.SMS_DEFAULT_LENGTH));
            Object o = SendSmsUtil.sendSms(phone, code);
            if (o instanceof Boolean){
                redisTemplate.opsForValue().set(RedisConstant.SSO_SMS_CODE + phone,code+"_"+System.currentTimeMillis(),RedisConstant.SSO_CACHE_TIME, TimeUnit.SECONDS);
                return Boolean.TRUE;
            }else {
                throw new RuntimeException(o.toString());
            }
        }

    }

    /**
    * 保存
    * @param memberEntity
    * @return
    */
    @Override
    public Object saveMember(MemberEntity memberEntity) {
        baseMapper.insert(memberEntity);
        return Boolean.TRUE;
    }

    /**
     * 会员注册
     * @param  memberRegisterDTO
     * @return
     * 需要判断该手机号是否通过三方账号进行过注册，如果注册过判断
     */
    @Override
    public Object registerMember(MemberRegisterDTO memberRegisterDTO) {
        if (!memberRegisterDTO.getPassword().equals(memberRegisterDTO.getConfiromPassword())){
            throw new RuntimeException("密码和确认密码不一致!");
        }
        String code = (String)redisTemplate.opsForValue().get(RedisConstant.SSO_SMS_CODE + memberRegisterDTO.getMobile());
        if (StringUtils.isEmpty(code)){
            throw new RuntimeException("验证码已过期!");
        }else if (!code.split("_")[0].equals(memberRegisterDTO.getCode())){
            throw new RuntimeException("验证码输入错误!");
        }
        //输入参数及验证码正确后进入注册逻辑，同时删除缓存的验证码
        redisTemplate.delete(RedisConstant.SSO_SMS_CODE + memberRegisterDTO.getMobile());
        checkUserName(memberRegisterDTO.getUsername());
        Long aLong = checkPhone(memberRegisterDTO.getMobile());
        MemberEntity memberEntity = JSONObject.parseObject(JSONObject.toJSONString(memberRegisterDTO),MemberEntity.class);
        MemberLevelEntity defaultLevel = getDefaultLevel();
        if (defaultLevel == null){
            memberEntity.setLevelId(0L);
        }else {
            memberEntity.setLevelId(defaultLevel.getId());
        }
        memberEntity.setNickname(memberRegisterDTO.getMobile());
        //TODO 需要补一个默认头像

        //对密码进行加盐加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(memberEntity.getPassword());
        memberEntity.setPassword(encode);
        memberEntity.setId(aLong);
        //说明该手机号没有注册过
        if (aLong != null){
            baseMapper.updateById(memberEntity);
        }else {
            baseMapper.insert(memberEntity);
        }
        //生成Token
        String token = TokenUtil.generToken(String.valueOf(memberEntity.getId()));
        CommonUser cacheUserInfoVO = new CommonUser();
        BeanUtil.copyProperties(memberEntity,cacheUserInfoVO);
        cacheUserInfoVO.setMemberId(memberEntity.getId());
        //设置五个小时过期,token的类型是用户表的账号密码不是三方账户
        redisTemplate.opsForValue().set(token+"_"+OtherConstant.TOKEN_TYPE_MEMBER,cacheUserInfoVO,OtherConstant.EXPRIE_SECOND,TimeUnit.SECONDS);
        return token;
    }

    /**
     * 会员登陆
     * @param  memberLoginDTO
     * @return
     */
    @Override
    public Object loginMember(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = baseMapper.selectOne(new QueryWrapper<MemberEntity>().eq(EntityConstant.USERNAME, memberLoginDTO.getUsername()).or().eq(EntityConstant.PHONE, memberLoginDTO.getUsername()));
        if (memberEntity != null){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if (!bCryptPasswordEncoder.matches(memberLoginDTO.getPassword(),memberEntity.getPassword())){
                throw new RuntimeException("用户名密码不正确!");
            }
        }else {
            throw new RuntimeException("用户名不存在!");
        }
        //生成Token
        String token = TokenUtil.generToken(String.valueOf(memberEntity.getId()));
        CommonUser cacheUserInfoVO = new CommonUser();
        BeanUtil.copyProperties(memberEntity,cacheUserInfoVO);
        cacheUserInfoVO.setMemberId(memberEntity.getId());
        //设置半个小时过期
        redisTemplate.opsForValue().set(token+"_"+OtherConstant.TOKEN_TYPE_MEMBER,cacheUserInfoVO,OtherConstant.EXPRIE_SECOND,TimeUnit.SECONDS);
        return token;
    }

    /**
     * 会员登出
     * @return
     */
    @Override
    public Object unLoginMember(String token) {
        redisTemplate.delete(token+"_"+OtherConstant.TOKEN_TYPE_MEMBER);
        redisTemplate.delete(token+"_"+OtherConstant.TOKEN_TYPE_SOCIAL);
        return R.ok();
    }

    /**
     * 检查用户名是否唯一
     */
    private void checkUserName(String userName){
        Integer integer = baseMapper.selectCount(new QueryWrapper<MemberEntity>().eq(EntityConstant.USERNAME, userName));
        if (integer > 0){
            throw new RuntimeException("用户名已存在!");
        }
    }

    /**
     * 检查手机号是否唯一,如果通过三方进行过注册，那么密码等是空的，可以进行注册
     * @param phone
     */
    private Long checkPhone(String phone){
        List<MemberEntity> memberEntities = baseMapper.selectList(new QueryWrapper<MemberEntity>().eq(EntityConstant.PHONE, phone));
        if (CollectionUtil.isNotEmpty(memberEntities)){
            if (StringUtils.isNotEmpty(memberEntities.get(0).getPassword())){
                throw new RuntimeException("手机号已存在!");
            }else {
                return memberEntities.get(0).getId();
            }
        }
        return null;
    }

    /**
     * 检查邮箱是否唯一
     */
    private void checkEmail(String email){
        Integer integer = baseMapper.selectCount(new QueryWrapper<MemberEntity>().eq(EntityConstant.EMAIL, email));
        if (integer > 0){
            throw new RuntimeException("邮箱已存在!");
        }
    }

    /**
     * 获取默认等级
     */
    private MemberLevelEntity getDefaultLevel(){
        List<MemberLevelEntity> memberLevelEntities = memberLevelDao.selectList(new QueryWrapper<MemberLevelEntity>().eq(EntityConstant.DEFAULT_STATUS, 1));
        if (CollectionUtils.isEmpty(memberLevelEntities)){
            return null;
        }else {
            return memberLevelEntities.get(0);
        }
    }

}