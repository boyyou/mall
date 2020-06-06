package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.CategoryEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listCategory();

    /**
     * 根据分类id查询分类所有父级
     * @param categoryId
     * @return
     */
    List<CategoryEntity> getParentPath(Long categoryId);

    /**
     * 批量删除分类
     * @param asList
     * @return
     */
    Object deleteBath(List<Long> asList);

    /**
     * 保存分类
     * @return
     */
    Object saveCategory(CategoryEntity categoryEntity);

    /**
     * 修改分类信息
     * @param categoryEntity
     * @return
     */
    Object updateCategory(CategoryEntity categoryEntity);
}

