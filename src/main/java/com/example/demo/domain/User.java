package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String userName;

    private String password;

    private static final long serialVersionUID = 1L;
}