package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.AttrAttrgroupRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存属性&属性分组关联
     * @param  attrAttrgroupRelationEntity
     * @return
     */
    Object saveAttrAttrgroupRelation(AttrAttrgroupRelationEntity attrAttrgroupRelationEntity);

    /**
     * 批量删除属性&属性分组关联
     * @param ids
     * @return
     */
    Object deleteBathAttrAttrgroupRelation(List<Long> ids);
}

