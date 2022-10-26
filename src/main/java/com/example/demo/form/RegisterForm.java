package com.example.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName : RegisterForm  //类名
 * @Description : 注册类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  17:03
 */
@Data
public class RegisterForm {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
