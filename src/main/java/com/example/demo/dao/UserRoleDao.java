package com.example.demo.dao;

import com.example.demo.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wangyujie
 */
@Repository
public interface UserRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void modifyRoleById(@Param("id") Integer id, @Param("role") Integer role);
}