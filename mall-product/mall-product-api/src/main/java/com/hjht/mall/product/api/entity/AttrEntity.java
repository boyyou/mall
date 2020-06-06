package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品属性
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_attr")
@ApiModel("商品属性")
public class AttrEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @TableId
    @ApiModelProperty("属性id")
    private Long attrId;
    /**
     * 属性名
     */
    @ApiModelProperty("属性名")
    @NotBlank(message = "属性名不能为空")
    private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @ApiModelProperty("是否需要检索[0-不需要，1-需要]")
    private Integer searchType;
    /**
     * 属性图标
     */
    @ApiModelProperty("属性图标")
    @NotBlank(message = "属性图标不能为空")
    private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
    @ApiModelProperty("可选值列表[用逗号分隔]")
    private String valueSelect;
    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @ApiModelProperty("属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer attrType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @ApiModelProperty("启用状态[0 - 禁用，1 - 启用]")
    private Long enable;
    /**
     * 所属分类
     */
    @ApiModelProperty("所属分类")
    @NotNull(message = "所属分类不能为空")
    private Long catelogId;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Integer showDesc;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
