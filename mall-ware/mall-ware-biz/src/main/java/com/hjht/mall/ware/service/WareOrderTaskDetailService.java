package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.WareOrderTaskDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 库存工作单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存库存工作单
     * @return
     */
    Object saveWareOrderTaskDetail(WareOrderTaskDetailEntity wareOrderTaskDetailEntity);

    /**
     * 批量删除库存工作单
     * @param ids
     * @return
     */
    Object deleteBathWareOrderTaskDetail(List<Long> ids);
}

