package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.RefundInfoEntity;

import java.util.Map;
import java.util.List;

/**
 * 退款信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存退款信息
     * @param  refundInfoEntity
     * @return
     */
    Object saveRefundInfo(RefundInfoEntity refundInfoEntity);

    /**
     * 批量删除退款信息
     * @param ids
     * @return
     */
    Object deleteBathRefundInfo(List<Long> ids);
}

