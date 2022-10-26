package com.example.demo.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName : GoodsForm  //类名
 * @Description : 申请物品  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  20:05
 */
@Data
public class GoodsForm {

    @ApiModelProperty("物品名")
    private String goodsName;

    @ApiModelProperty("数量")
    private Integer goodsNum;
}
