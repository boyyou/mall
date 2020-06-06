package com.hjht.mall.coupon.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 优惠券与产品关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:28:37
 */
@Data
@TableName("sms_coupon_spu_relation")
@ApiModel("优惠券与产品关联")
public class CouponSpuRelationEntity implements Serializable {
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
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
