package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Date 2020/6/6 10:27
 * @Created by ycl
 */
@Data
public class Attr {

    @ApiModelProperty("属性id")
    private Long attrId;

    @ApiModelProperty("属性名称")
    @NotEmpty(message = "属性名称不能为空")
    private String attrName;

    @ApiModelProperty("属性值")
    @NotEmpty(message = "属性值不能为空")
    private String attrValue;

}
