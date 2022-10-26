package com.example.demo.VO;

import lombok.Data;

/**
 * @ClassName : GoodVO  //类名
 * @Description : 物品视图  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  21:20
 */
@Data
public class GoodVO {

    private Integer id;
    private String goodsName;

    private Integer goodsNum;

    private Integer status;

}
