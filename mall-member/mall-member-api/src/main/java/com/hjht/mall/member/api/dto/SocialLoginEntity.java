package com.hjht.mall.member.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Date 2020/5/30 15:45
 * @Created by ycl
 */
@Data
public class SocialLoginEntity {

    @NotNull(message = "登陆类型不能为空!")
    @ApiModelProperty("社交登陆类型1-QQ,2-微信,3-支付宝,4-微博,5-抖音,6-头条")
    private Integer type;

    @NotBlank(message = "code不能为空!")
    @ApiModelProperty("三方code")
    private String code;

    @ApiModelProperty("openId")
    private String openId;

    @ApiModelProperty("包括敏感数据在内的完整用户信息的加密数据---微信用户基本信息")
    private String encryptedDataUserInfo;

    @ApiModelProperty("加密算法的初始向量---微信用户基本信息")
    private String ivUserInfo;

    @ApiModelProperty("包括敏感数据在内的完整用户信息的加密数据---手机号码")
    private String encryptedDataPhone;

    @ApiModelProperty("加密算法的初始向量---手机号码")
    private String ivPhone;
}
