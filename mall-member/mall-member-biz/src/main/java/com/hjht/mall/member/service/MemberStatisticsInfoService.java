package com.hjht.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjht.common.utils.PageUtils;
import com.hjht.mall.member.api.entity.MemberStatisticsInfoEntity;

import java.util.Map;
import java.util.List;

/**
 * 会员统计信息
 *
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:25
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存会员统计信息
     * @param  memberStatisticsInfoEntity
     * @return
     */
    Object saveMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity);

    /**
     * 批量删除会员统计信息
     * @param ids
     * @return
     */
    Object deleteBathMemberStatisticsInfo(List<Long> ids);
}

