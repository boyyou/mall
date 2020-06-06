package com.hjht.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.product.api.entity.SpuInfoDescEntity;
import com.hjht.mall.product.dao.SpuInfoDescDao;
import com.hjht.mall.product.service.SpuInfoDescService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoDescEntity> page = this.page(
                new Query<SpuInfoDescEntity>().getPage(params),
                new QueryWrapper<SpuInfoDescEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param spuIds
    * @return
    */
    @Override
    public Object deleteBathSpuInfoDesc(List<Long> spuIds) {
        baseMapper.deleteBatchIds(spuIds);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param spuInfoDescEntity
    * @return
    */
    @Override
    public Object saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity) {
        baseMapper.insert(spuInfoDescEntity);
        return Boolean.TRUE;
    }

}