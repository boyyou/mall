package com.hjht.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.order.api.entity.PaymentInfoEntity;

import java.util.Map;
import java.util.List;

/**
 * 支付信息表
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:54:09
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存支付信息表
     * @param  paymentInfoEntity
     * @return
     */
    Object savePaymentInfo(PaymentInfoEntity paymentInfoEntity);

    /**
     * 批量删除支付信息表
     * @param ids
     * @return
     */
    Object deleteBathPaymentInfo(List<Long> ids);
}

