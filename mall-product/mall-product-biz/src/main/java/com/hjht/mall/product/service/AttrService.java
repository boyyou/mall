package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.dto.AttrDTO;
import com.hjht.mall.product.api.dto.AttrGetDTO;
import com.hjht.mall.product.api.entity.AttrEntity;
import com.hjht.mall.product.api.vo.AttrVO;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<AttrVO> getPageByCatelogId(Page page, AttrGetDTO attrGetDTO);

    AttrVO getInfoById(Long attrId);

    /**
     * 保存商品属性
     * @param  attrDTO
     * @return
     */
    Object saveAttr(AttrDTO attrDTO);

    /**
     * 修改商品属性
     * @param  attrDTO
     * @return
     */
    Object updateAttr(AttrDTO attrDTO);

    /**
     * 批量删除商品属性
     * @param attrIds
     * @return
     */
    Object deleteBathAttr(List<Long> attrIds);
}

