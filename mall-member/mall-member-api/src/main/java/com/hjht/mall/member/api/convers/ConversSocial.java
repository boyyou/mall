package com.hjht.mall.member.api.convers;

import com.alibaba.fastjson.JSONObject;
import com.hjht.common.entity.CommonUser;
import com.hjht.mall.member.api.entity.MemberEntity;
import com.hjht.mall.member.api.entity.MemberSocialEntity;

/**
 * @Date 2020/5/30 17:06
 * @Created by ycl
 */
public class ConversSocial {

    /**
     * 根据三方回调的数据封装entity
     * 1-QQ,2-微信,3-支付宝,4-微博,5-抖音,6-头条
     * @return
     */
    public static MemberSocialEntity converSocial(String unionId,String onlyId,String nick,String headUrl,Integer sex,String country,String province,String city,String accessToken,Integer type){
        MemberSocialEntity memberSocialEntity = new MemberSocialEntity();
        memberSocialEntity.setAccessToken(accessToken);
        memberSocialEntity.setCity(city);
        memberSocialEntity.setCountry(country);
        memberSocialEntity.setHeadUrl(headUrl);
        memberSocialEntity.setNick(nick);
        memberSocialEntity.setOnlyId(onlyId);
        memberSocialEntity.setProvince(province);
        memberSocialEntity.setSex(sex);
        memberSocialEntity.setUnionId(unionId);
        memberSocialEntity.setType(type);
        return memberSocialEntity;
    }

    /**
     * 三方账号信息转commonuser
     * @param userId
     * @param memberId
     * @param username
     * @param mobile
     * @param header
     * @return
     */
    public static CommonUser coverSocialToMember(Long userId,Long memberId,String username,String mobile,String header){
        CommonUser memberEntity = new CommonUser();
        memberEntity.setMemberId(memberId);
        memberEntity.setHeader(header);
        memberEntity.setMobile(mobile);
        memberEntity.setUserId(userId);
        memberEntity.setUsername(username);
        return memberEntity;
    }
}
