package com.hjht.mall.order.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@Data
@TableName("oms_order")
@ApiModel("订单")
public class OrderEntity implements Serializable {
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
     * 订单号
     */
    @ApiModelProperty("订单号")
    private String orderSn;
    /**
     * 使用的优惠券
     */
    @ApiModelProperty("使用的优惠券")
    private Long couponId;
    /**
     * create_time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("create_time")
    private Date createTime;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String memberUsername;
    /**
     * 订单总额
     */
    @ApiModelProperty("订单总额")
    private BigDecimal totalAmount;
    /**
     * 应付总额
     */
    @ApiModelProperty("应付总额")
    private BigDecimal payAmount;
    /**
     * 运费金额
     */
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;
    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    @ApiModelProperty("促销优化金额（促销价、满减、阶梯价）")
    private BigDecimal promotionAmount;
    /**
     * 积分抵扣金额
     */
    @ApiModelProperty("积分抵扣金额")
    private BigDecimal integrationAmount;
    /**
     * 优惠券抵扣金额
     */
    @ApiModelProperty("优惠券抵扣金额")
    private BigDecimal couponAmount;
    /**
     * 后台调整订单使用的折扣金额
     */
    @ApiModelProperty("后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;
    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    @ApiModelProperty("支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】")
    private Integer payType;
    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    @ApiModelProperty("订单来源[0->PC订单；1->app订单]")
    private Integer sourceType;
    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @ApiModelProperty("订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
    private Integer status;
    /**
     * 物流公司(配送方式)
     */
    @ApiModelProperty("物流公司(配送方式)")
    private String deliveryCompany;
    /**
     * 物流单号
     */
    @ApiModelProperty("物流单号")
    private String deliverySn;
    /**
     * 自动确认时间（天）
     */
    @ApiModelProperty("自动确认时间（天）")
    private Integer autoConfirmDay;
    /**
     * 可以获得的积分
     */
    @ApiModelProperty("可以获得的积分")
    private Integer integration;
    /**
     * 可以获得的成长值
     */
    @ApiModelProperty("可以获得的成长值")
    private Integer growth;
    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    @ApiModelProperty("发票类型[0->不开发票；1->电子发票；2->纸质发票]")
    private Integer billType;
    /**
     * 发票抬头
     */
    @ApiModelProperty("发票抬头")
    private String billHeader;
    /**
     * 发票内容
     */
    @ApiModelProperty("发票内容")
    private String billContent;
    /**
     * 收票人电话
     */
    @ApiModelProperty("收票人电话")
    private String billReceiverPhone;
    /**
     * 收票人邮箱
     */
    @ApiModelProperty("收票人邮箱")
    private String billReceiverEmail;
    /**
     * 收货人姓名
     */
    @ApiModelProperty("收货人姓名")
    private String receiverName;
    /**
     * 收货人电话
     */
    @ApiModelProperty("收货人电话")
    private String receiverPhone;
    /**
     * 收货人邮编
     */
    @ApiModelProperty("收货人邮编")
    private String receiverPostCode;
    /**
     * 省份/直辖市
     */
    @ApiModelProperty("省份/直辖市")
    private String receiverProvince;
    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String receiverCity;
    /**
     * 区
     */
    @ApiModelProperty("区")
    private String receiverRegion;
    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String receiverDetailAddress;
    /**
     * 订单备注
     */
    @ApiModelProperty("订单备注")
    private String note;
    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    @ApiModelProperty("确认收货状态[0->未确认；1->已确认]")
    private Integer confirmStatus;
    /**
     * 删除状态【0->未删除；1->已删除】
     */
    @ApiModelProperty("删除状态【0->未删除；1->已删除】")
    private Integer deleteStatus;
    /**
     * 下单时使用的积分
     */
    @ApiModelProperty("下单时使用的积分")
    private Integer useIntegration;
    /**
     * 支付时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("支付时间")
    private Date paymentTime;
    /**
     * 发货时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("发货时间")
    private Date deliveryTime;
    /**
     * 确认收货时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("确认收货时间")
    private Date receiveTime;
    /**
     * 评价时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("评价时间")
    private Date commentTime;
    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    private Date modifyTime;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
