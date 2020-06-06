package com.hjht.mall.product.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Date 2020/6/5 11:33
 * @Created by ycl
 * 属性分组请求dto
 */
@Data
public class AttrGroupDTO {
    @ApiModelProperty("属性分组id")
    @NotNull(message = "属性分组id不能为空")
    private Long attrGroupId;

    @ApiModelProperty("属性id")
    @NotNull(message = "属性id不能为空")
    private Long attrId;
}
