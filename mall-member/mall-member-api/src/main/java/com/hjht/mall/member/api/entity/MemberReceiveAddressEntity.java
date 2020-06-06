package com.hjht.mall.member.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员收货地址
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
@Data
@TableName("ums_member_receive_address")
@ApiModel("会员收货地址")
public class MemberReceiveAddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * member_id
     */
    @ApiModelProperty("member_id")
    private Long memberId;
    /**
     * 收货人姓名
     */
    @ApiModelProperty("收货人姓名")
    private String name;
    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;
    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    private String postCode;
    /**
     * 省份/直辖市
     */
    @ApiModelProperty("省份/直辖市")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;
    /**
     * 区
     */
    @ApiModelProperty("区")
    private String region;
    /**
     * 详细地址(街道)
     */
    @ApiModelProperty("详细地址(街道)")
    private String detailAddress;
    /**
     * 省市区代码
     */
    @ApiModelProperty("省市区代码")
    private String areacode;
    /**
     * 是否默认
     */
    @ApiModelProperty("是否默认")
    private Integer defaultStatus;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
