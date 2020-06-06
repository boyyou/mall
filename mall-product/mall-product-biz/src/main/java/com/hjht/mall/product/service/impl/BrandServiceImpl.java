package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.BrandEntity;
import com.hjht.mall.product.api.entity.CategoryBrandRelationEntity;
import com.hjht.mall.product.api.entity.CategoryEntity;
import com.hjht.mall.product.dao.BrandDao;
import com.hjht.mall.product.service.BrandService;
import com.hjht.mall.product.service.CategoryBrandRelationService;
import com.hjht.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param brandIds
    * @return
    */
    @Override
    public Object deleteBathBrand(List<Long> brandIds) {
        baseMapper.deleteBatchIds(brandIds);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param brandEntity
    * @return
    */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Object saveBrand(BrandEntity brandEntity) {
        Long catelogId = brandEntity.getCatelogId();
        CategoryEntity byId = categoryService.getById(catelogId);
        if (byId == null){
            throw new RuntimeException("该分类不存在");
        }
        baseMapper.insert(brandEntity);
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setBrandId(brandEntity.getBrandId());
        categoryBrandRelationEntity.setBrandName(brandEntity.getName());
        categoryBrandRelationEntity.setCatelogId(catelogId);
        categoryBrandRelationEntity.setCatelogName(byId.getName());
        categoryBrandRelationService.save(categoryBrandRelationEntity);
        return Boolean.TRUE;
    }

}