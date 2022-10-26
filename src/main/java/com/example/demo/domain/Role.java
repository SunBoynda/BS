package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * role
 *
 * @author
 */
@Data
public class Role implements Serializable {
    private Integer id;

    /**
     * 0表示普通用户，1表示普通管理员，2表示超级管理员
     */
    private Integer role;

    private static final long serialVersionUID = 1L;
}