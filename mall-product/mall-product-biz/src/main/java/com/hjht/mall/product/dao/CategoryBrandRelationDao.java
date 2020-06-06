package com.hjht.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjht.mall.product.api.entity.CategoryBrandRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 14:21:40
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {
	
}
