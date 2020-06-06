package com.hjht.mall.member.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Data
@TableName("ums_member")
@ApiModel("会员")
public class MemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 会员等级id
     */
    @ApiModelProperty("会员等级id")
    private Long levelId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String header;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer gender;
    /**
     * 生日
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日")
    private Date birth;
    /**
     * 所在城市
     */
    @ApiModelProperty("所在城市")
    private String city;
    /**
     * 职业
     */
    @ApiModelProperty("职业")
    private String job;
    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String sign;
    /**
     * 用户来源
     */
    @ApiModelProperty("用户来源")
    private Integer sourceType;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer integration;
    /**
     * 成长值
     */
    @ApiModelProperty("成长值")
    private Integer growth;
    /**
     * 启用状态
     */
    @ApiModelProperty("启用状态")
    private Integer status;
    /**
     * 注册时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("注册时间")
    private Date createTime;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;
}
