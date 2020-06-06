package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.OrderSettingEntity;

import java.util.Map;
import java.util.List;

/**
 * 订单配置信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单配置信息
     * @param  orderSettingEntity
     * @return
     */
    Object saveOrderSetting(OrderSettingEntity orderSettingEntity);

    /**
     * 批量删除订单配置信息
     * @param ids
     * @return
     */
    Object deleteBathOrderSetting(List<Long> ids);
}

