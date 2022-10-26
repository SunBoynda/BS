package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * people
 * @author 
 */
@Data
public class People implements Serializable {
    private Integer id;

    private String username;

    private String address;

    private String phone;

    /**
     * 0男 ，1女
     */
    private Integer sex;

    private static final long serialVersionUID = 1L;
}