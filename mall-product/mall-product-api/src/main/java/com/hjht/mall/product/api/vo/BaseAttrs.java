package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Date 2020/6/6 10:54
 * @Created by ycl
 */
@Data
public class BaseAttrs {

    @ApiModelProperty("spu基本属性id")
    @NotNull(message = "spu基本属性id不能为空")
    private Long attrId;

    @ApiModelProperty("spu基本属性值")
    @NotEmpty(message = "spu基本属性值不能为空")
    private String attrValues;

    @ApiModelProperty("spu基本属性id")
    @NotEmpty(message = "spu基本属性id不能为空")
    private int showDesc;



}
