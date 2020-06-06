package com.hjht.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2020/6/1 17:36
 * @Created by ycl
 */
@Data
public class CommonUser implements Serializable{
    /**
     * 三方账号表id
     */
    @ApiModelProperty("三方账号表id")
    private Long userId;

    /**
     * 用户表id
     */
    @ApiModelProperty("用户表id")
    private Long memberId;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String username;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String header;


}
