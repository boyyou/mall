package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.PurchaseDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存
     * @return
     */
    Object savePurchaseDetail(PurchaseDetailEntity purchaseDetailEntity);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Object deleteBathPurchaseDetail(List<Long> ids);
}

