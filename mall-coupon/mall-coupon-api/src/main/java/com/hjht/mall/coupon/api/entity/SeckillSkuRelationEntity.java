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
 * 秒杀活动商品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_seckill_sku_relation")
@ApiModel("秒杀活动商品关联")
public class SeckillSkuRelationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 活动id
     */
    @ApiModelProperty("活动id")
    private Long promotionId;
    /**
     * 活动场次id
     */
    @ApiModelProperty("活动场次id")
    private Long promotionSessionId;
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long skuId;
    /**
     * 秒杀价格
     */
    @ApiModelProperty("秒杀价格")
    private BigDecimal seckillPrice;
    /**
     * 秒杀总量
     */
    @ApiModelProperty("秒杀总量")
    private BigDecimal seckillCount;
    /**
     * 每人限购数量
     */
    @ApiModelProperty("每人限购数量")
    private BigDecimal seckillLimit;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer seckillSort;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
