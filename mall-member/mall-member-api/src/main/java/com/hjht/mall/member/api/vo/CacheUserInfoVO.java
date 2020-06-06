package com.hjht.mall.member.api.vo;

import lombok.Data;

/**
 * @Date 2020/6/1 10:08
 * @Created by ycl
 * 登陆后redis需要保存的个人信息
 */
@Data
public class CacheUserInfoVO {
    /**
     * 三方账号表id
     */
    private Long userId;

    /**
     * 用户表id
     */
    private Long memberId;

    /**
     * 用户表名称
     */
    private String username;

    /**
     * 用户表手机号码
     */
    private String mobile;

    /**
     * 用户表头像
     */
    private String header;



}
