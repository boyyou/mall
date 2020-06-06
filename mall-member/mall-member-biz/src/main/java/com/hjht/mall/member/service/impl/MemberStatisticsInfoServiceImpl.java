package com.hjht.mall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.member.api.entity.MemberStatisticsInfoEntity;
import com.hjht.mall.member.dao.MemberStatisticsInfoDao;
import com.hjht.mall.member.service.MemberStatisticsInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("memberStatisticsInfoService")
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoDao, MemberStatisticsInfoEntity> implements MemberStatisticsInfoService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberStatisticsInfoEntity> page = this.page(
                new Query<MemberStatisticsInfoEntity>().getPage(params),
                new QueryWrapper<MemberStatisticsInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMemberStatisticsInfo(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param memberStatisticsInfoEntity
    * @return
    */
    @Override
    public Object saveMemberStatisticsInfo(MemberStatisticsInfoEntity memberStatisticsInfoEntity) {
        baseMapper.insert(memberStatisticsInfoEntity);
        return Boolean.TRUE;
    }

}