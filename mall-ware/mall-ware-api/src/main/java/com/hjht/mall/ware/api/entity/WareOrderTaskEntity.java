package com.hjht.mall.ware.api.entity;

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
 * 库存工作单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@Data
@TableName("wms_ware_order_task")
@ApiModel("库存工作单")
public class WareOrderTaskEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * order_id
     */
    @ApiModelProperty("order_id")
    private Long orderId;
    /**
     * order_sn
     */
    @ApiModelProperty("order_sn")
    private String orderSn;
    /**
     * 收货人
     */
    @ApiModelProperty("收货人")
    private String consignee;
    /**
     * 收货人电话
     */
    @ApiModelProperty("收货人电话")
    private String consigneeTel;
    /**
     * 配送地址
     */
    @ApiModelProperty("配送地址")
    private String deliveryAddress;
    /**
     * 订单备注
     */
    @ApiModelProperty("订单备注")
    private String orderComment;
    /**
     * 付款方式【 1:在线付款 2:货到付款】
     */
    @ApiModelProperty("付款方式【 1:在线付款 2:货到付款】")
    private Integer paymentWay;
    /**
     * 任务状态
     */
    @ApiModelProperty("任务状态")
    private Integer taskStatus;
    /**
     * 订单描述
     */
    @ApiModelProperty("订单描述")
    private String orderBody;
    /**
     * 物流单号
     */
    @ApiModelProperty("物流单号")
    private String trackingNo;
    /**
     * create_time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("create_time")
    private Date createTime;
    /**
     * 仓库id
     */
    @ApiModelProperty("仓库id")
    private Long wareId;
    /**
     * 工作单备注
     */
    @ApiModelProperty("工作单备注")
    private String taskComment;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
