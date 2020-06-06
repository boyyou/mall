package com.hjht.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjht.mall.product.api.entity.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 14:21:40
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {
	
}
