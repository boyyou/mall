package com.hjht.mall.product.api.dto;

import com.hjht.mall.product.api.entity.AttrEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Date 2020/6/4 9:04
 * @Created by ycl
 */
@Data
public class AttrDTO extends AttrEntity {

    /**
     * 属性分组id
     */
    @ApiModelProperty("属性分组id")
    @NotNull(message = "所属分组id不能为空")
    private Long attrGroupId;
}
