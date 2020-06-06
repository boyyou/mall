package com.hjht.mall.order.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退款信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@Data
@TableName("oms_refund_info")
@ApiModel("退款信息")
public class RefundInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 退款的订单
     */
    @ApiModelProperty("退款的订单")
    private Long orderReturnId;
    /**
     * 退款金额
     */
    @ApiModelProperty("退款金额")
    private BigDecimal refund;
    /**
     * 退款交易流水号
     */
    @ApiModelProperty("退款交易流水号")
    private String refundSn;
    /**
     * 退款状态
     */
    @ApiModelProperty("退款状态")
    private Integer refundStatus;
    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @ApiModelProperty("退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Integer refundChannel;
    /**
     *
     */
    @ApiModelProperty("")
    private String refundContent;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
