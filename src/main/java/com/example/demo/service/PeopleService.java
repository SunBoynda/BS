package com.example.demo.service;


/**
 * @author wangyujie
 */

import com.example.demo.VO.ResultVO;
import com.example.demo.domain.People;
import com.example.demo.form.PeopleForm;
import org.springframework.stereotype.Service;

@Service
public interface PeopleService {
    ResultVO getAllPeople();

    ResultVO addPeople(PeopleForm peopleForm);

    ResultVO updatePeople(People peopleForm);

    ResultVO delPeopleById(Integer id);
}
