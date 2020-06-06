package com.hjht.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.product.api.entity.SpuInfoDescEntity;

import java.util.List;
import java.util.Map;

/**
 * spu信息介绍
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:42:14
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存spu信息介绍
     * @param  spuInfoDescEntity
     * @return
     */
    Object saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity);

    /**
     * 批量删除spu信息介绍
     * @param spuIds
     * @return
     */
    Object deleteBathSpuInfoDesc(List<Long> spuIds);
}

