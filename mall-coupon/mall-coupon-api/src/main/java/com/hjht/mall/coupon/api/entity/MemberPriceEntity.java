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
 * 商品会员价格
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_member_price")
@ApiModel("商品会员价格")
public class MemberPriceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * sku_id
     */
    @ApiModelProperty("sku_id")
    private Long skuId;
    /**
     * 会员等级id
     */
    @ApiModelProperty("会员等级id")
    private Long memberLevelId;
    /**
     * 会员等级名
     */
    @ApiModelProperty("会员等级名")
    private String memberLevelName;
    /**
     * 会员对应价格
     */
    @ApiModelProperty("会员对应价格")
    private BigDecimal memberPrice;
    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
    @ApiModelProperty("可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
