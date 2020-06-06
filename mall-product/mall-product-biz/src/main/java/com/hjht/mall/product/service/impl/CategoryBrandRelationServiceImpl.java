package com.hjht.mall.product.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.BrandEntity;
import com.hjht.mall.product.api.entity.CategoryBrandRelationEntity;
import com.hjht.mall.product.api.vo.BrandSimpleVO;
import com.hjht.mall.product.dao.BrandDao;
import com.hjht.mall.product.dao.CategoryBrandRelationDao;
import com.hjht.mall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private BrandDao brandDao;

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathCategoryBrandRelation(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
     * 查询某个分类下面的所有品牌
     * @return
     */
    @Override
    public List<BrandEntity> listBrand(Long catelogId) {
        //查询某个分类下的所有品牌
        List<CategoryBrandRelationEntity> categoryBrandRelationEntities = baseMapper.selectList(new LambdaQueryWrapper<CategoryBrandRelationEntity>().eq(CategoryBrandRelationEntity::getCatelogId, catelogId));
        List<Long> collect = categoryBrandRelationEntities.stream().map(CategoryBrandRelationEntity::getBrandId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(collect)){
            List<BrandEntity> brandEntities = brandDao.selectList(new LambdaQueryWrapper<BrandEntity>().in(BrandEntity::getBrandId, collect));
            return brandEntities;
        }
        return null;
    }

    /**
    * 保存
    * @param categoryBrandRelationEntity
    * @return
    */
    @Override
    public Object saveCategoryBrandRelation(CategoryBrandRelationEntity categoryBrandRelationEntity) {
        baseMapper.insert(categoryBrandRelationEntity);
        return Boolean.TRUE;
    }

}