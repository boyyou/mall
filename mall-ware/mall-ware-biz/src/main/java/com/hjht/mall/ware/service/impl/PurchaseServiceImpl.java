package com.hjht.mall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.ware.api.entity.PurchaseEntity;
import com.hjht.mall.ware.dao.PurchaseDao;
import com.hjht.mall.ware.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                new QueryWrapper<PurchaseEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathPurchase(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param purchaseEntity
    * @return
    */
    @Override
    public Object savePurchase(PurchaseEntity purchaseEntity) {
        baseMapper.insert(purchaseEntity);
        return Boolean.TRUE;
    }

}