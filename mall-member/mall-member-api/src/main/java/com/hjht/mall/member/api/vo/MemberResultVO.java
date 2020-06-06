package com.hjht.mall.member.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2020/5/31 18:45
 * @Created by ycl
 */
@Data
public class MemberResultVO implements Serializable {
    @ApiModelProperty("token")
    private String accessToken;
}
