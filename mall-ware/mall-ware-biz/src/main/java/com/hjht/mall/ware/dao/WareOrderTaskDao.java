package com.hjht.mall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjht.mall.ware.api.entity.WareOrderTaskEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存工作单
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 19:20:05
 */
@Mapper
public interface WareOrderTaskDao extends BaseMapper<WareOrderTaskEntity> {
	
}
