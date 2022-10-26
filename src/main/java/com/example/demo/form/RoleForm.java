package com.example.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName : RoleForm  //类名
 * @Description : 角色更改  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  19:26
 */
@Data
public class RoleForm {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("角色")
    private Integer role;
}
