package com.example.demo.form;

import lombok.Data;

/**
 * @ClassName : PeopleForm  //类名
 * @Description : 联系人表单  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/23  10:39
 */
@Data
public class PeopleForm {


    private String username;

    private String address;

    private String phone;

    /**
     * 0男 ，1女
     */
    private Integer sex;
}
