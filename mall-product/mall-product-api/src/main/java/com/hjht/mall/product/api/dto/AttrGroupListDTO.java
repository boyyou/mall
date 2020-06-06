package com.hjht.mall.product.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date 2020/6/5 13:41
 * @Created by ycl
 */
@Data
public class AttrGroupListDTO {
    @ApiModelProperty("删除的集合")
    @Valid
    List<AttrGroupDTO> list;
}
