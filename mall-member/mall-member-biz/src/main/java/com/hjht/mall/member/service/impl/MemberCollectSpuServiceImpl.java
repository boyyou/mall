package com.hjht.mall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.member.api.entity.MemberCollectSpuEntity;
import com.hjht.mall.member.dao.MemberCollectSpuDao;
import com.hjht.mall.member.service.MemberCollectSpuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("memberCollectSpuService")
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuDao, MemberCollectSpuEntity> implements MemberCollectSpuService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberCollectSpuEntity> page = this.page(
                new Query<MemberCollectSpuEntity>().getPage(params),
                new QueryWrapper<MemberCollectSpuEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMemberCollectSpu(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param memberCollectSpuEntity
    * @return
    */
    @Override
    public Object saveMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity) {
        baseMapper.insert(memberCollectSpuEntity);
        return Boolean.TRUE;
    }

}