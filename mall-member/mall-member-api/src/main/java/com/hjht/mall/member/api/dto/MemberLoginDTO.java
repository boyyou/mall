package com.hjht.mall.member.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Date 2020/5/30 14:35
 * @Created by ycl
 */
@Data
public class MemberLoginDTO {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空!")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空!")
    private String password;
}
