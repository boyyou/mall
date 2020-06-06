package com.hjht.mall.product.api.vo;

import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.entity.CategoryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Date 2020/6/4 10:46
 * @Created by ycl
 */
@Data
public class AttrVO extends AttrEntity {

    @ApiModelProperty("所属分类及其父分类")
    private List<CategoryEntity> parentPath;

    @ApiModelProperty("分组名称")
    private String groupName;


}
