package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.PurchaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存采购信息
     * @return
     */
    Object savePurchase(PurchaseEntity purchaseEntity);

    /**
     * 批量删除采购信息
     * @param ids
     * @return
     */
    Object deleteBathPurchase(List<Long> ids);
}

