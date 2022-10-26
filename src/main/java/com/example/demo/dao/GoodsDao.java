package com.example.demo.dao;

import com.example.demo.VO.GoodVO;
import com.example.demo.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    Goods adminSelect();

    Goods superAdminSelect();

    GoodVO selectByUserId(Integer id);
}