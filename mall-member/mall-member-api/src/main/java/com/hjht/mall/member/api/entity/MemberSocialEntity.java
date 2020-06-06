package com.hjht.mall.member.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 三方账号
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-30 16:41:28
 */
@Data
@TableName("ums_member_social")
@ApiModel("三方账号")
public class MemberSocialEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty("主键")
    private Long id;
    /**
     * 用户表id
     */
    @ApiModelProperty("用户表id")
    private Long memberId;

    /**
     * 账号类型1-QQ,2-微信,3-支付宝,4-微博,5-抖音,6-头条
     */
    @ApiModelProperty("账号类型1-QQ,2-微信,3-支付宝,4-微博,5-抖音,6-头条")
    private Integer type;

    /**
     * 微信unionid
     */
    @ApiModelProperty("微信unionid")
    private String unionId;
    /**
     * 三方账号唯一标识，比如：微信的openId
     */
    @ApiModelProperty("三方账号唯一标识，比如：微信的openId")
    private String onlyId;
    /**
     * 三方账号昵称
     */
    @ApiModelProperty("三方账号昵称")
    private String nick;
    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headUrl;
    /**
     * 性别(0-未知，1-男性，2-女性)
     */
    @ApiModelProperty("性别(0-未知，1-男性，2-女性)")
    private Integer sex;
    /**
     * 国家
     */
    @ApiModelProperty("国家")
    private String country;
    /**
     * 省份
     */
    @ApiModelProperty("省份")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;
    /**
     * 状态(0-正常，1-解绑，2-禁用)
     */
    @ApiModelProperty("状态(0-正常，1-解绑，2-禁用)")
    private Integer status;
    /**
     * 三方访问token值
     */
    @ApiModelProperty("三方访问token值")
    private String accessToken;

    /**
     * 刷新token值
     */
    @ApiModelProperty("刷新token值")
    private String refreshToken;

    /**
     * token过期时间单位秒
     */
    @ApiModelProperty("token过期时间单位秒")
    private Integer expiresIn;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    private Date updateTime;
    /**
     * 删除标记(0-正常，1-删除)
     */
    @TableLogic
    @ApiModelProperty("删除标记(0-正常，1-删除)")
    private Integer delFlag;

    /**
     * 微信openId
     */
    @TableField(exist = false)
    @ApiModelProperty("微信openId")
    private String openId;

    @ApiModelProperty("语言")
    private String language;
}
