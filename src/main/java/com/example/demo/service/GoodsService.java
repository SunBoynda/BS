package com.example.demo.service;

import com.example.demo.VO.ResultVO;

import com.example.demo.form.GoodsForm;
import org.springframework.stereotype.Service;

@Service
public interface GoodsService {

    ResultVO apply(GoodsForm goodsForm);

    ResultVO adminSelect();

    ResultVO adminApply(Integer id);

    ResultVO superAdminSelect();

    ResultVO superAdminApply(Integer id);

    ResultVO getUserGoods();
}
