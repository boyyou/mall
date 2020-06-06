package com.hjht.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjht.mall.product.api.dto.AttrGetDTO;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.vo.AttrVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-25 14:21:40
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {

    IPage<AttrVO> getPageByCatelogId(@Param("page") Page page, @Param("attrGetDTO") AttrGetDTO attrGetDTO);

    AttrVO getInfoById(Long attrId);
}
