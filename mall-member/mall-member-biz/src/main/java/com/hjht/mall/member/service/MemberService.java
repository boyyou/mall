package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.dto.MemberLoginDTO;
import com.hjht.mall.member.api.dto.MemberRegisterDTO;
import com.hjht.mall.member.api.entity.MemberEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员
     * @param  memberEntity
     * @return
     */
    Object saveMember(MemberEntity memberEntity);

    /**
     * 注册会员
     * @param  memberRegisterDTO
     * @return
     */
    Object registerMember(MemberRegisterDTO memberRegisterDTO);

    /**
     * 注册登陆
     * @param  memberLoginDTO
     * @return
     */
    Object loginMember(MemberLoginDTO memberLoginDTO);

    /**
     * 注册登出
     * @return
     */
    Object unLoginMember(String token);

    /**
     * 批量删除会员
     * @param ids
     * @return
     */
    Object deleteBathMember(List<Long> ids);

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    Object sendSms(String phone);


}

