package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.accessctro.RoleControl;
import com.example.demo.enums.RoleEnum;
import com.example.demo.form.RoleForm;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : AdminController  //类名
 * @Description : 管理员  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  19:08
 */
@RestController
@Slf4j
@RequestMapping("/api/admin")
@CrossOrigin
@Api(tags = "管理员接口")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/modifyRole")
    @ApiOperation("更改用户角色(仅限超级管理员)")
    @RoleControl(role = RoleEnum.SUPPER_ADMIN)
    public ResultVO modifyRole(@RequestBody RoleForm roleForm) {
        return userService.modifyRole(roleForm);
    }


}
