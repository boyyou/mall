package com.hjht.mall.ware.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
@Data
@TableName("wms_purchase_detail")
@ApiModel("")
public class PurchaseDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty("")
    private Long id;
    /**
     * 采购单id
     */
    @ApiModelProperty("采购单id")
    private Long purchaseId;
    /**
     * 采购商品id
     */
    @ApiModelProperty("采购商品id")
    private Long skuId;
    /**
     * 采购数量
     */
    @ApiModelProperty("采购数量")
    private Integer skuNum;
    /**
     * 采购金额
     */
    @ApiModelProperty("采购金额")
    private BigDecimal skuPrice;
    /**
     * 仓库id
     */
    @ApiModelProperty("仓库id")
    private Long wareId;
    /**
     * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
     */
    @ApiModelProperty("状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
