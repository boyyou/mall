package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.WareSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品库存
     * @return
     */
    Object saveWareSku(WareSkuEntity wareSkuEntity);

    /**
     * 批量删除商品库存
     * @param ids
     * @return
     */
    Object deleteBathWareSku(List<Long> ids);
}

