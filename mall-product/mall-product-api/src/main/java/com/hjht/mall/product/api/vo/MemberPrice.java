package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Date 2020/6/6 10:47
 * @Created by ycl
 */

@Data
public class MemberPrice {

    @ApiModelProperty("会员id")
    @NotNull(message = "会员id不能为空")
    private Long id;

    @ApiModelProperty("会员名字如：砖石会员")
    @NotEmpty(message = "会员名字不能为空")
    private String name;

    @ApiModelProperty("会员售价")
    @NotEmpty(message = "会员售价不能为空")
    private BigDecimal price;

}
