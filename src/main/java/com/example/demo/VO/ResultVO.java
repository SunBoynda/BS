package com.example.demo.VO;

import lombok.Data;


/**
 * @author wangyujie
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private String status;
    private T data;
}

