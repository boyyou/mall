package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.IntegrationChangeHistoryEntity;

import java.util.Map;
import java.util.List;

/**
 * 积分变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存积分变化历史记录
     * @param  integrationChangeHistoryEntity
     * @return
     */
    Object saveIntegrationChangeHistory(IntegrationChangeHistoryEntity integrationChangeHistoryEntity);

    /**
     * 批量删除积分变化历史记录
     * @param ids
     * @return
     */
    Object deleteBathIntegrationChangeHistory(List<Long> ids);
}

