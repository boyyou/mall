package com.hjht.mall.member.api.dto;





import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Date 2020/5/29 20:52
 * @Created by ycl
 */
@Data
public class MemberRegisterDTO implements Serializable {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空!")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空!")
    private String password;

    @ApiModelProperty("确认密码")
    @NotBlank(message = "确认密码不能为空!")
    private String confiromPassword;

    @ApiModelProperty("电话号码")
    @NotBlank(message = "电话号码不能为空!")
    private String mobile;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空!")
    private String code;

}
