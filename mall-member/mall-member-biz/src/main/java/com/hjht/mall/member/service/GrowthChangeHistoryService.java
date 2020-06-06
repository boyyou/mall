package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.GrowthChangeHistoryEntity;

import java.util.Map;
import java.util.List;

/**
 * 成长值变化历史记录
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存成长值变化历史记录
     * @param  growthChangeHistoryEntity
     * @return
     */
    Object saveGrowthChangeHistory(GrowthChangeHistoryEntity growthChangeHistoryEntity);

    /**
     * 批量删除成长值变化历史记录
     * @param ids
     * @return
     */
    Object deleteBathGrowthChangeHistory(List<Long> ids);
}

