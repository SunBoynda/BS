package com.example.demo.service.Impl;

import com.example.demo.VO.ResultVO;
import com.example.demo.dao.PeopleDao;
import com.example.demo.domain.People;
import com.example.demo.enums.ResultEnum;
import com.example.demo.form.PeopleForm;
import com.example.demo.service.PeopleService;
import com.example.demo.utils.ResultVOUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : PeopleServiceImpl  //类名
 * @Description : 通讯录实现层  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/23  10:33
 */
@Slf4j
@Service
public class PeopleServiceImpl implements PeopleService {



    @Autowired
    private PeopleDao peopleDao;


    @Override
    public ResultVO getAllPeople() {

        List<People> peopleList = peopleDao.selectAll();
        return ResultVOUtil.success(peopleList);
    }

    @Override
    public ResultVO addPeople(PeopleForm peopleForm) {
        People people = new People();
        BeanUtils.copyProperties(peopleForm,people);
        int insert = peopleDao.insert(people);
        if (insert != 1) {
            return ResultVOUtil.error(ResultEnum.ADD_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO updatePeople(People peopleForm) {
        People people = new People();
        BeanUtils.copyProperties(peopleForm,people);
        int update = peopleDao.updateByPrimaryKey(people);
        if (update != 1) {
            return ResultVOUtil.error(ResultEnum.UPDATE_ERROR);
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO delPeopleById(Integer id) {
        int delete = peopleDao.deleteByPrimaryKey(id);
        if (delete != 1) {
            return ResultVOUtil.error(ResultEnum.DELETE_ERROR);
        }
        return ResultVOUtil.success();
    }
}
