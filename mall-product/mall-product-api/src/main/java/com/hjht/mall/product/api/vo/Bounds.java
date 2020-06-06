package com.hjht.mall.product.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @Date 2020/6/6 11:06
 * @Created by ycl
 */
@Data
public class Bounds {

    @ApiModelProperty("赠送积分")
    @NotEmpty(message = "赠送积分不为空")
    private BigDecimal buyBounds;


    @ApiModelProperty("赠送成长值")
    @NotEmpty(message = "赠送成长值不为空")
    private BigDecimal growBounds;


}
