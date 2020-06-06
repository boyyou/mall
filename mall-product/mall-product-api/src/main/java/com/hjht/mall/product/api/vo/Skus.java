package com.hjht.mall.product.api.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Date 2020/6/6 10:26
 * @Created by ycl
 */
@Data
public class Skus {
    @ApiModelProperty("属性集合")
    @Valid
    private List<Attr> attr;

    @ApiModelProperty("sku名称")
    @NotEmpty(message = "sku名称不能为空")
    private String skuName;

    @ApiModelProperty("sku售价")
    @NotEmpty(message = "sku售价不能为空")
    private BigDecimal price;


    private String skuTitle;


    private String skuSubtitle;

    @ApiModelProperty("sku图片集合")
    @Valid
    private List<Images> images;


    private List<String> descar;


    private int fullCount;

    @ApiModelProperty("折扣价")
    private BigDecimal discount;


    private int countStatus;

    @ApiModelProperty("满减额度")
    private BigDecimal fullPrice;

    @ApiModelProperty("满减金额")
    private BigDecimal reducePrice;


    private int priceStatus;

    @ApiModelProperty("会员售价集合")
    @Valid
    private List<MemberPrice> memberPrice;
}
