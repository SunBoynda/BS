package com.example.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName : LoginForm  //类名
 * @Description : 登录类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  16:53
 */
@Data
public class LoginForm {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
