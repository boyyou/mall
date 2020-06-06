package com.hjht.mall.product.api.vo;

import com.hjht.mall.product.api.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

/**
 * @Date 2020/5/26 17:22
 * @Created by ycl
 */
@Data
public class CategoryVO extends CategoryEntity {


    List<CategoryVO> childs;
}
