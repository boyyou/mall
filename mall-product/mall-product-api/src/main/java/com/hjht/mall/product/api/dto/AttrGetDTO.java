package com.hjht.mall.product.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Date 2020/6/4 10:44
 * @Created by ycl
 *
 */
@Data
public class AttrGetDTO {
    @ApiModelProperty("属性分类id")
    private Long catelogId;

    @ApiModelProperty("属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer attrType;

    @ApiModelProperty("属性名称")
    private String attrName;
}
