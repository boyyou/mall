package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.WareOrderTaskEntity;

import java.util.List;
import java.util.Map;

/**
 * 库存工作单
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存库存工作单
     * @return
     */
    Object saveWareOrderTask(WareOrderTaskEntity wareOrderTaskEntity);

    /**
     * 批量删除库存工作单
     * @param ids
     * @return
     */
    Object deleteBathWareOrderTask(List<Long> ids);
}

