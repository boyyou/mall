package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderOperateHistoryEntity;

import java.util.Map;
import java.util.List;

/**
 * 订单操作历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单操作历史记录
     * @param  orderOperateHistoryEntity
     * @return
     */
    Object saveOrderOperateHistory(OrderOperateHistoryEntity orderOperateHistoryEntity);

    /**
     * 批量删除订单操作历史记录
     * @param ids
     * @return
     */
    Object deleteBathOrderOperateHistory(List<Long> ids);
}

