package com.hjht.mall.product.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * sku销售属性&值
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
@Data
@TableName("pms_sku_sale_attr_value")
@ApiModel("sku销售属性&值")
public class SkuSaleAttrValueEntity implements Serializable {
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
     * attr_id
     */
    @ApiModelProperty("attr_id")
    private Long attrId;
    /**
     * 销售属性名
     */
    @ApiModelProperty("销售属性名")
    private String attrName;
    /**
     * 销售属性值
     */
    @ApiModelProperty("销售属性值")
    private String attrValue;
    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer attrSort;
    /**
     * 删除标记（0-正常，1-删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0-正常，1-删除）")
    private Integer delFlag;

}
