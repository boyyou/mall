package com.hjht.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.ware.api.entity.WareInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 仓库信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-28 23:18:27
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存仓库信息
     * @return
     */
    Object saveWareInfo(WareInfoEntity wareInfoEntity);

    /**
     * 批量删除仓库信息
     * @param ids
     * @return
     */
    Object deleteBathWareInfo(List<Long> ids);
}

