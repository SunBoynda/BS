package com.example.demo.service.Impl;

import com.example.demo.VO.GoodVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.dao.GoodsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Goods;
import com.example.demo.domain.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.form.GoodsForm;
import com.example.demo.service.GoodsService;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVOUtil;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : GoodsServiceImpl  //类名
 * @Description : 物品实现类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  20:12
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public ResultVO apply(GoodsForm goodsForm) {
        User user = userService.getCurrentUser();
        if (user == null) {
            return ResultVOUtil.error(ResultEnum.NOT_LOGIN);
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsForm, goods);
        goods.setUserId(user.getId());
        goods.setStatus(0);
        int insert = goodsDao.insert(goods);
        if (insert != 1) {
            return ResultVOUtil.error(ResultEnum.INSERT_ERROR);
        }
        return ResultVOUtil.success("申请成功");
    }

    @Override
    public ResultVO adminSelect() {
        Goods goods = goodsDao.adminSelect();
        if (goods == null) {
            return ResultVOUtil.success(ResultEnum.NOT_EXISTS);
        }
        return ResultVOUtil.success(goods);
    }

    @Override
    public ResultVO adminApply(Integer id) {
        Goods goods = goodsDao.selectByPrimaryKey(id);
        if (goods == null) {
            return ResultVOUtil.success(ResultEnum.NOT_EXISTS);
        }
        if (goods.getStatus() != 0) {
            return ResultVOUtil.error(ResultEnum.PERMISSION_DENNY);
        }
        goods.setStatus(1);
        int update = goodsDao.updateByPrimaryKey(goods);
        if (update != 1) {
            return ResultVOUtil.error(ResultEnum.INSERT_ERROR);
        }
        return ResultVOUtil.success("审核成功");
    }

    @Override
    public ResultVO superAdminSelect() {
        Goods goods = goodsDao.superAdminSelect();
        if (goods == null) {
            return ResultVOUtil.success(ResultEnum.NOT_EXISTS);
        }
        return ResultVOUtil.success(goods);
    }

    @Override
    public ResultVO superAdminApply(Integer id) {
        Goods goods = goodsDao.selectByPrimaryKey(id);
        if (goods == null) {
            return ResultVOUtil.success(ResultEnum.NOT_EXISTS);
        }
        if (goods.getStatus() != 1) {
            return ResultVOUtil.error(ResultEnum.PERMISSION_DENNY);
        }
        goods.setStatus(2);
        int update = goodsDao.updateByPrimaryKey(goods);
        if (update != 1) {
            return ResultVOUtil.error(ResultEnum.INSERT_ERROR);
        }
        return ResultVOUtil.success("审核成功");
    }

    @Override
    public ResultVO getUserGoods() {
        User user = userService.getCurrentUser();
        if (user == null) {
            return ResultVOUtil.error(ResultEnum.NOT_LOGIN);
        }
        GoodVO goods = goodsDao.selectByUserId(user.getId());
        return ResultVOUtil.success(goods);
    }
}
