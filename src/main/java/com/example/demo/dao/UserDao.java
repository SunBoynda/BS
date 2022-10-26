package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author wangyujie
 */
@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUserName(String userName);

    Integer selectUserRoleById(Integer id);


}