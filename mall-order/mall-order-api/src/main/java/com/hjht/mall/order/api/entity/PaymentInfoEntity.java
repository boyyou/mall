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
 * 支付信息表
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@Data
@TableName("oms_payment_info")
@ApiModel("支付信息表")
public class PaymentInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 订单号（对外业务号）
     */
    @ApiModelProperty("订单号（对外业务号）")
    private String orderSn;
    /**
     * 订单id
     */
    @ApiModelProperty("订单id")
    private Long orderId;
    /**
     * 支付宝交易流水号
     */
    @ApiModelProperty("支付宝交易流水号")
    private String alipayTradeNo;
    /**
     * 支付总金额
     */
    @ApiModelProperty("支付总金额")
    private BigDecimal totalAmount;
    /**
     * 交易内容
     */
    @ApiModelProperty("交易内容")
    private String subject;
    /**
     * 支付状态
     */
    @ApiModelProperty("支付状态")
    private String paymentStatus;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 确认时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("确认时间")
    private Date confirmTime;
    /**
     * 回调内容
     */
    @ApiModelProperty("回调内容")
    private String callbackContent;
    /**
     * 回调时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("回调时间")
    private Date callbackTime;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
