package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Date 2020/6/6 10:34
 * @Created by ycl
 */
@Data
public class Images {

    @ApiModelProperty("图片地址")
    @NotEmpty(message = "图片地址不能为空")
    private String imgUrl;

    @ApiModelProperty("是否是默认图片0 - 不是默认图，1 - 是默认图")
    @NotNull(message = "是否是默认图片不能为空")
    private int defaultImg;


}
