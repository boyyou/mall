package com.hjht.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;

import com.hjht.mall.member.dao.IntegrationChangeHistoryDao;
import com.hjht.mall.member.api.entity.IntegrationChangeHistoryEntity;
import com.hjht.mall.member.service.IntegrationChangeHistoryService;


@Service("integrationChangeHistoryService")
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryDao, IntegrationChangeHistoryEntity> implements IntegrationChangeHistoryService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IntegrationChangeHistoryEntity> page = this.page(
                new Query<IntegrationChangeHistoryEntity>().getPage(params),
                new QueryWrapper<IntegrationChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathIntegrationChangeHistory(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param integrationChangeHistoryEntity
    * @return
    */
    @Override
    public Object saveIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity) {
        baseMapper.insert(integrationChangeHistoryEntity);
        return Boolean.TRUE;
    }

}