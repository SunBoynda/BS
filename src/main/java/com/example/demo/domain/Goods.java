package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * goods
 *
 * @author
 */
@Data
public class Goods implements Serializable {
    private Integer id;

    private Integer userId;

    private String goodsName;

    private Integer goodsNum;

    /**
     * 0表示提交申请，1表示普通管理员审核，2表示超级管理员审核
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}