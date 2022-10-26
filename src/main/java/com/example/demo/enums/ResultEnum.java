package com.example.demo.enums;

import lombok.Getter;


/**
 * @author wangyujie
 */

@Getter
public enum ResultEnum {
    USER_EXIST_ERROR(1, "用户已存在"),
    DATABASE_OPTION_ERROR(2, "数据库操作失败"),
    USER_NOT_EXIST_ERROR(3, "用户不存在"),
    PASSWORD_ERROR(4, "密码错误"),
    AUTHENTICATION_ERROR(401, "用户认证失败,请重新登录"),
    PERMISSION_DENNY(403, "权限不足"),
    NOT_FOUND(404, "url错误,请求路径未找到"),
    SERVER_ERROR(500, "服务器未知错误:%s"),
    BIND_ERROR(511, "参数校验错误:%s"),
    INSERT_ERROR(5, "申请失败"),
    NOT_EXISTS(6, "物品不存在"),
    NOT_LOGIN(7, "用户未登录"),
    ADD_ERROR(8,"添加失败"),
    UPDATE_ERROR(9,"更新失败"),
    DELETE_ERROR(10,"删除失败"),
    REQUEST_METHOD_ERROR(550, "不支持%s的请求方式");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
