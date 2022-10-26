package com.example.demo.dao;

import com.example.demo.domain.People;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangyujie
 */
@Repository
public interface PeopleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(People record);

    int insertSelective(People record);

    People selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);

    List<People> selectAll();
}