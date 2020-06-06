package com.hjht.mall.member.api.vo;

import com.hjht.common.entity.CommonUser;
import com.hjht.mall.member.api.entity.MemberEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Date 2020/6/1 14:00
 * @Created by ycl
 * 返回给前端的用户信息
 */
@Data
public class MemberLoginVO {

    /**
     * openId
     */
    @ApiModelProperty("openId")
    private String openId;

    /**
     * 用户信息
     */
    @ApiModelProperty("用户信息")
    private CommonUser memberEntity;

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;
}
