package com.hjht.mall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.member.api.entity.GrowthChangeHistoryEntity;
import com.hjht.mall.member.dao.GrowthChangeHistoryDao;
import com.hjht.mall.member.service.GrowthChangeHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("growthChangeHistoryService")
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryDao, GrowthChangeHistoryEntity> implements GrowthChangeHistoryService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GrowthChangeHistoryEntity> page = this.page(
                new Query<GrowthChangeHistoryEntity>().getPage(params),
                new QueryWrapper<GrowthChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathGrowthChangeHistory(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param growthChangeHistoryEntity
    * @return
    */
    @Override
    public Object saveGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity) {
        baseMapper.insert(growthChangeHistoryEntity);
        return Boolean.TRUE;
    }

}