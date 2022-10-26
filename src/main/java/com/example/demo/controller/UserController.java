package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.domain.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @ClassName : UserController  //类名
 * @Description : 用户登录  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  16:04
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
@CrossOrigin
@Api(tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResultVO login(@RequestBody @Valid LoginForm loginForm, HttpServletResponse response) {
        return userService.login(loginForm, response);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public ResultVO register(@RequestBody @Valid RegisterForm registerForm) {
        return userService.register(registerForm);
    }

}
