package com.hjht.mall.coupon.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品阶梯价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_sku_ladder")
@ApiModel("商品阶梯价格")
public class SkuLadderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * spu_id
     */
    @ApiModelProperty("spu_id")
    private Long skuId;
    /**
     * 满几件
     */
    @ApiModelProperty("满几件")
    private Integer fullCount;
    /**
     * 打几折
     */
    @ApiModelProperty("打几折")
    private BigDecimal discount;
    /**
     * 折后价
     */
    @ApiModelProperty("折后价")
    private BigDecimal price;
    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    @ApiModelProperty("是否叠加其他优惠[0-不可叠加，1-可叠加]")
    private Integer addOther;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
