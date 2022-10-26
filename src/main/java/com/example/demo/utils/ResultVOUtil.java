package com.example.demo.utils;


import com.example.demo.VO.ResultVO;
import com.example.demo.enums.ResultEnum;
import lombok.Data;


/**
 * @author wangyujie
 */
@Data
public class ResultVOUtil {

    /**
     * @param object
     * @return 有参成功结果
     * @author zty
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setStatus("success");
        resultVO.setData(object);
        return resultVO;
    }

    /***
     *
     * 无参成功结果
     *
     * @author zty
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 返回错误结果
     *
     * @param resultEnum
     */
    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setStatus("fail");
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }

    public static ResultVO error(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("错误");
        resultVO.setData(object);
        return resultVO;
    }

}

