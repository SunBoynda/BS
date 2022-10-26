package com.example.demo.VO;

import lombok.Data;

/**
 * @ClassName : UserVO  //类名
 * @Description : 用户视图  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  18:50
 */
@Data
public class UserVO {
    private Integer id;

    private String userName;

    private String password;

    private Integer role;
}
