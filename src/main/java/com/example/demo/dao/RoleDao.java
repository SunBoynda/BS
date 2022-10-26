package com.example.demo.dao;

import com.example.demo.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}