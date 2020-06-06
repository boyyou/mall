package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.BrandEntity;
import com.hjht.mall.product.api.entity.CategoryBrandRelationEntity;
import com.hjht.mall.product.api.vo.BrandSimpleVO;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存品牌分类关联
     * @param  categoryBrandRelationEntity
     * @return
     */
    Object saveCategoryBrandRelation(CategoryBrandRelationEntity categoryBrandRelationEntity);

    /**
     * 批量删除品牌分类关联
     * @param ids
     * @return
     */
    Object deleteBathCategoryBrandRelation(List<Long> ids);

    List<BrandEntity> listBrand(Long catelogId);
}

