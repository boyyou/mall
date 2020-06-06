package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderReturnReasonEntity;

import java.util.Map;
import java.util.List;

/**
 * 退货原因
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存退货原因
     * @param  orderReturnReasonEntity
     * @return
     */
    Object saveOrderReturnReason(OrderReturnReasonEntity orderReturnReasonEntity);

    /**
     * 批量删除退货原因
     * @param ids
     * @return
     */
    Object deleteBathOrderReturnReason(List<Long> ids);
}

