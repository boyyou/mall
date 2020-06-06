package com.hjht.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjht.mall.product.api.entity.SpuCommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 14:21:40
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuCommentEntity> {
	
}
