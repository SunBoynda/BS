package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.domain.People;
import com.example.demo.form.PeopleForm;
import com.example.demo.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : PeopleController  //类名
 * @Description : 通讯录  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/23  10:29
 */
@RestController
@Slf4j
@RequestMapping("/api/people")
@CrossOrigin
@Api(tags = "通讯录接口")
public class PeopleController {
        @Autowired
        private PeopleService peopleService;


        @ApiOperation("展示通讯录")
        @GetMapping("/getAllPeople")
        public ResultVO getAllPeople() {
            return peopleService.getAllPeople();
        }

        @ApiOperation("添加新联系人")
        @PostMapping("/addPeople")
        public ResultVO addPeople(@RequestBody PeopleForm peopleForm) {
            return peopleService.addPeople(peopleForm);
        }
        @ApiOperation("更新联系人")
        @PostMapping("/updatePeople")
        public ResultVO updatePeople(@RequestBody People peopleForm) {
            return peopleService.updatePeople(peopleForm);
        }
        @ApiOperation("删除联系人")
        @GetMapping("/delPeople")
        public ResultVO delPeopleById(@RequestParam("id")Integer id) {
            return peopleService.delPeopleById(id);
        }
}
