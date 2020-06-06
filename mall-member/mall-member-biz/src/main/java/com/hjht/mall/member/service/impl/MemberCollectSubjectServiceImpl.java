package com.hjht.mall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.member.api.entity.MemberCollectSubjectEntity;
import com.hjht.mall.member.dao.MemberCollectSubjectDao;
import com.hjht.mall.member.service.MemberCollectSubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("memberCollectSubjectService")
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectDao, MemberCollectSubjectEntity> implements MemberCollectSubjectService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberCollectSubjectEntity> page = this.page(
                new Query<MemberCollectSubjectEntity>().getPage(params),
                new QueryWrapper<MemberCollectSubjectEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMemberCollectSubject(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param memberCollectSubjectEntity
    * @return
    */
    @Override
    public Object saveMemberCollectSubject(MemberCollectSubjectEntity memberCollectSubjectEntity) {
        baseMapper.insert(memberCollectSubjectEntity);
        return Boolean.TRUE;
    }

}