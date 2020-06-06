package com.hjht.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;

import com.hjht.mall.member.dao.MemberSocialDao;
import com.hjht.mall.member.api.entity.MemberSocialEntity;
import com.hjht.mall.member.service.MemberSocialService;


@Service("memberSocialService")
public class MemberSocialServiceImpl extends ServiceImpl<MemberSocialDao, MemberSocialEntity> implements MemberSocialService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberSocialEntity> page = this.page(
                new Query<MemberSocialEntity>().getPage(params),
                new QueryWrapper<MemberSocialEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 三方账号批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMemberSocial(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 三方账号保存
    * @param memberSocialEntity
    * @return
    */
    @Override
    public Object saveMemberSocial(MemberSocialEntity memberSocialEntity) {
        baseMapper.insert(memberSocialEntity);
        return Boolean.TRUE;
    }

}