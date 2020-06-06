package com.hjht.mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;

import com.hjht.mall.coupon.dao.SeckillSkuNoticeDao;
import com.hjht.mall.coupon.api.entity.SeckillSkuNoticeEntity;
import com.hjht.mall.coupon.service.SeckillSkuNoticeService;


@Service("seckillSkuNoticeService")
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity> implements SeckillSkuNoticeService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuNoticeEntity> page = this.page(
                new Query<SeckillSkuNoticeEntity>().getPage(params),
                new QueryWrapper<SeckillSkuNoticeEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathSeckillSkuNotice(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param seckillSkuNoticeEntity
    * @return
    */
    @Override
    public Object saveSeckillSkuNotice(SeckillSkuNoticeEntity seckillSkuNoticeEntity) {
        baseMapper.insert(seckillSkuNoticeEntity);
        return Boolean.TRUE;
    }

}