package com.hjht.mall.member.dao;

import com.hjht.mall.member.api.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author youchenglu
 * @email boyyoucr@outlook.com
 * @date 2020-05-29 00:20:26
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
