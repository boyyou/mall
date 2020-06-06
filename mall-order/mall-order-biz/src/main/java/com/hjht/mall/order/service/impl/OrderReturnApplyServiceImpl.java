package com.hjht.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.order.api.entity.OrderReturnApplyEntity;
import com.hjht.mall.order.dao.OrderReturnApplyDao;
import com.hjht.mall.order.service.OrderReturnApplyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("orderReturnApplyService")
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyDao, OrderReturnApplyEntity> implements OrderReturnApplyService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderReturnApplyEntity> page = this.page(
                new Query<OrderReturnApplyEntity>().getPage(params),
                new QueryWrapper<OrderReturnApplyEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathOrderReturnApply(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param orderReturnApplyEntity
    * @return
    */
    @Override
    public Object saveOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity) {
        baseMapper.insert(orderReturnApplyEntity);
        return Boolean.TRUE;
    }

}