package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderReturnApplyEntity;

import java.util.Map;
import java.util.List;

/**
 * 订单退货申请
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单退货申请
     * @param  orderReturnApplyEntity
     * @return
     */
    Object saveOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity);

    /**
     * 批量删除订单退货申请
     * @param ids
     * @return
     */
    Object deleteBathOrderReturnApply(List<Long> ids);
}

