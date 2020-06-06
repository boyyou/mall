package com.hjht.mall.coupon.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券领取历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_coupon_history")
@ApiModel("优惠券领取历史记录")
public class CouponHistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 优惠券id
     */
    @ApiModelProperty("优惠券id")
    private Long couponId;
    /**
     * 会员id
     */
    @ApiModelProperty("会员id")
    private Long memberId;
    /**
     * 会员名字
     */
    @ApiModelProperty("会员名字")
    private String memberNickName;
    /**
     * 获取方式[0->后台赠送；1->主动领取]
     */
    @ApiModelProperty("获取方式[0->后台赠送；1->主动领取]")
    private Integer getType;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 使用状态[0->未使用；1->已使用；2->已过期]
     */
    @ApiModelProperty("使用状态[0->未使用；1->已使用；2->已过期]")
    private Integer useType;
    /**
     * 使用时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("使用时间")
    private Date useTime;
    /**
     * 订单id
     */
    @ApiModelProperty("订单id")
    private Long orderId;
    /**
     * 订单号
     */
    @ApiModelProperty("订单号")
    private Long orderSn;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
