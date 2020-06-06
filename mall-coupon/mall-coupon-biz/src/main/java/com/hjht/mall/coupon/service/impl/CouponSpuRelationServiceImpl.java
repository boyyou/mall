package com.hjht.mall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.coupon.api.entity.CouponSpuRelationEntity;
import com.hjht.mall.coupon.dao.CouponSpuRelationDao;
import com.hjht.mall.coupon.service.CouponSpuRelationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("couponSpuRelationService")
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity> implements CouponSpuRelationService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponSpuRelationEntity> page = this.page(
                new Query<CouponSpuRelationEntity>().getPage(params),
                new QueryWrapper<CouponSpuRelationEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathCouponSpuRelation(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param couponSpuRelationEntity
    * @return
    */
    @Override
    public Object saveCouponSpuRelation(CouponSpuRelationEntity couponSpuRelationEntity) {
        baseMapper.insert(couponSpuRelationEntity);
        return Boolean.TRUE;
    }

}