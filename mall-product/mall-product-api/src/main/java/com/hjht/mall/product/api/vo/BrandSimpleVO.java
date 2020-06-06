package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Date 2020/6/5 16:50
 * @Created by ycl
 */
@Data
public class BrandSimpleVO {

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("品牌名")
    private String name;
}
