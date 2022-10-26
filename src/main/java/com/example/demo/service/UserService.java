package com.example.demo.service;

import com.example.demo.VO.ResultVO;
import com.example.demo.domain.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.form.RoleForm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyujie
 */
@Service
public interface UserService {

    User getCurrentUser();


    /**
     * 根据用户名获得用户
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    int getUserRole(Integer id);

    ResultVO login(LoginForm loginForm, HttpServletResponse response);

    ResultVO register(RegisterForm registerForm);

    ResultVO getCurrentUserVO();

    ResultVO modifyRole(RoleForm roleForm);
}
