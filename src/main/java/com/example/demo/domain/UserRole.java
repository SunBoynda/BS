package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * user_role
 *
 * @author
 */
@Data
public class UserRole implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}