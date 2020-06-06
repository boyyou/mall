package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * spu属性值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_product_attr_value")
@ApiModel("spu属性值")
public class ProductAttrValueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long spuId;
    /**
     * 属性id
     */
    @ApiModelProperty("属性id")
    private Long attrId;
    /**
     * 属性名
     */
    @ApiModelProperty("属性名")
    private String attrName;
    /**
     * 属性值
     */
    @ApiModelProperty("属性值")
    private String attrValue;
    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer attrSort;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】")
    private Integer quickShow;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
