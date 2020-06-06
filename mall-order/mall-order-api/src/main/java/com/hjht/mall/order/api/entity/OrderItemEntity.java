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
 * 订单项信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
@Data
@TableName("oms_order_item")
@ApiModel("订单项信息")
public class OrderItemEntity implements Serializable {
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
     * spu_id
     */
    @ApiModelProperty("spu_id")
    private Long spuId;
    /**
     * spu_name
     */
    @ApiModelProperty("spu_name")
    private String spuName;
    /**
     * spu_pic
     */
    @ApiModelProperty("spu_pic")
    private String spuPic;
    /**
     * 品牌
     */
    @ApiModelProperty("品牌")
    private String spuBrand;
    /**
     * 商品分类id
     */
    @ApiModelProperty("商品分类id")
    private Long categoryId;
    /**
     * 商品sku编号
     */
    @ApiModelProperty("商品sku编号")
    private Long skuId;
    /**
     * 商品sku名字
     */
    @ApiModelProperty("商品sku名字")
    private String skuName;
    /**
     * 商品sku图片
     */
    @ApiModelProperty("商品sku图片")
    private String skuPic;
    /**
     * 商品sku价格
     */
    @ApiModelProperty("商品sku价格")
    private BigDecimal skuPrice;
    /**
     * 商品购买的数量
     */
    @ApiModelProperty("商品购买的数量")
    private Integer skuQuantity;
    /**
     * 商品销售属性组合（JSON）
     */
    @ApiModelProperty("商品销售属性组合（JSON）")
    private String skuAttrsVals;
    /**
     * 商品促销分解金额
     */
    @ApiModelProperty("商品促销分解金额")
    private BigDecimal promotionAmount;
    /**
     * 优惠券优惠分解金额
     */
    @ApiModelProperty("优惠券优惠分解金额")
    private BigDecimal couponAmount;
    /**
     * 积分优惠分解金额
     */
    @ApiModelProperty("积分优惠分解金额")
    private BigDecimal integrationAmount;
    /**
     * 该商品经过优惠后的分解金额
     */
    @ApiModelProperty("该商品经过优惠后的分解金额")
    private BigDecimal realAmount;
    /**
     * 赠送积分
     */
    @ApiModelProperty("赠送积分")
    private Integer giftIntegration;
    /**
     * 赠送成长值
     */
    @ApiModelProperty("赠送成长值")
    private Integer giftGrowth;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
