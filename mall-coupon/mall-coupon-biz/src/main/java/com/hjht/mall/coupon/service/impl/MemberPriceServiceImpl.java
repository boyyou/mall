package com.hjht.mall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjht.common.utils.PageUtils;
import com.hjht.common.utils.Query;
import com.hjht.mall.coupon.api.entity.MemberPriceEntity;
import com.hjht.mall.coupon.dao.MemberPriceDao;
import com.hjht.mall.coupon.service.MemberPriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements MemberPriceService {

    /**
    * 分页查询
    * @param params
    * @return
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberPriceEntity> page = this.page(
                new Query<MemberPriceEntity>().getPage(params),
                new QueryWrapper<MemberPriceEntity>()
        );

        return new PageUtils(page);
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public Object deleteBathMemberPrice(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }

    /**
    * 保存
    * @param memberPriceEntity
    * @return
    */
    @Override
    public Object saveMemberPrice(MemberPriceEntity memberPriceEntity) {
        baseMapper.insert(memberPriceEntity);
        return Boolean.TRUE;
    }

}