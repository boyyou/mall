package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderEntity;

import java.util.Map;
import java.util.List;

/**
 * 订单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单
     * @param  orderEntity
     * @return
     */
    Object saveOrder(OrderEntity orderEntity);

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    Object deleteBathOrder(List<Long> ids);
}

