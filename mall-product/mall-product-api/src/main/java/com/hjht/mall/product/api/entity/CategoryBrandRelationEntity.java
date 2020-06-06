package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌分类关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_category_brand_relation")
@ApiModel("品牌分类关联")
public class CategoryBrandRelationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Long brandId;
    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    private Long catelogId;
    /**
     *
     */
    @ApiModelProperty("")
    private String brandName;
    /**
     *
     */
    @ApiModelProperty("")
    private String catelogName;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
