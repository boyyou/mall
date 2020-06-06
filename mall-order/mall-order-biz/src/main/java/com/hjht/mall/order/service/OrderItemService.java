package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderItemEntity;

import java.util.Map;
import java.util.List;

/**
 * 订单项信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单项信息
     * @param  orderItemEntity
     * @return
     */
    Object saveOrderItem(OrderItemEntity orderItemEntity);

    /**
     * 批量删除订单项信息
     * @param ids
     * @return
     */
    Object deleteBathOrderItem(List<Long> ids);
}

