package com.hjht.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.order.api.entity.PaymentInfoEntity;
import com.hjht.mall.order.dao.PaymentInfoDao;
import com.hjht.mall.order.service.PaymentInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("paymentInfoService")
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoDao, PaymentInfoEntity> implements PaymentInfoService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PaymentInfoEntity> page = this.page(
                new Query<PaymentInfoEntity>().getPage(params),
                new QueryWrapper<PaymentInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathPaymentInfo(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param paymentInfoEntity
    * @return
    */
    @Override
    public Object savePaymentInfo(PaymentInfoEntity paymentInfoEntity) {
        baseMapper.insert(paymentInfoEntity);
        return Boolean.TRUE;
    }

}