package com.hjht.mall.member.service;

import com.hjht.mall.member.api.dto.SocialLoginEntity;
import com.hjht.mall.member.api.entity.MemberSocialEntity;
import com.hjht.mall.member.api.vo.MemberLoginVO;

/**
 * @Date 2020/5/30 15:41
 * @Created by ycl
 */
public interface SocialService {

    /**
     * 三方登陆接口
     * @param socialLoginEntity
     */
    void login(SocialLoginEntity socialLoginEntity);

    /**
     * 微信登陆回调接口
     */
    MemberLoginVO callbackWeChat(String code);

    /**
     * 补全微信用户信息
     * @param socialLoginEntity
     * @return
     */
    MemberLoginVO completionSocialInfo(SocialLoginEntity socialLoginEntity);
}
