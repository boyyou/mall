package com.hjht.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjht.mall.product.api.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 14:21:40
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
