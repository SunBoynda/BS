package com.example.demo.exceptionHandler;

import com.example.demo.enums.ResultEnum;
import lombok.Data;


/**
 * @author wangyujie
 */
@Data
public class GlobalException extends RuntimeException {
    private ResultEnum resultEnum;

    private String message;
    private Integer code;

    public GlobalException(ResultEnum resultEnum) {
        super();
        this.message = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public GlobalException(String message, Integer code) {
        super();
        this.message = message;
        this.code = code;
    }
}
