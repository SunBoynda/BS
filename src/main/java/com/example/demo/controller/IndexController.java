package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.accessctro.RoleControl;
import com.example.demo.enums.RoleEnum;
import com.example.demo.form.GoodsForm;
import com.example.demo.service.GoodsService;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : IndexController  //类名
 * @Description : 主页  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  20:00
 */
@RestController
@Slf4j
@RequestMapping("/api/index")
@CrossOrigin
@Api(tags = "业务接口")
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getUserGoods")
    @ApiOperation("用户查看自己的物品")
    public ResultVO getUserGoods() {
        return goodsService.getUserGoods();
    }

    @ApiOperation("普通用户申请")
    @PostMapping("/apply")
    public ResultVO apply(@RequestBody GoodsForm goodsForm) {
        return goodsService.apply(goodsForm);
    }


    @GetMapping("/adminSelect")
    @ApiOperation("普通管理员查看待审核的物品")
    @RoleControl(role = RoleEnum.ADMIN)
    public ResultVO adminSelect() {
        return goodsService.adminSelect();
    }

    @PostMapping("/adminApply")
    @ApiOperation("普通管理员审核")
    @RoleControl(role = RoleEnum.ADMIN)
    public ResultVO adminApply(Integer id) {
        return goodsService.adminApply(id);
    }

    @GetMapping("/superAdminSelect")
    @ApiOperation("超级管理员查看审核物品")
    @RoleControl(role = RoleEnum.SUPPER_ADMIN)
    public ResultVO superAdminSelect() {
        return goodsService.superAdminSelect();
    }

    @PostMapping("/superAdminApply")
    @ApiOperation("超级管理员审核")
    @RoleControl(role = RoleEnum.SUPPER_ADMIN)
    public ResultVO SuperAdminApply(Integer id) {
        return goodsService.superAdminApply(id);
    }

    @GetMapping("/getCurrent")
    @ApiOperation("获取当前用户信息")
    public ResultVO getCurrentUser() {
        return userService.getCurrentUserVO();
    }
}
