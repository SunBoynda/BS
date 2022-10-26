package com.example.demo.service.Impl;

import com.example.demo.VO.ResultVO;
import com.example.demo.VO.UserVO;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserRoleDao;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRole;
import com.example.demo.enums.ResultEnum;
import com.example.demo.enums.RoleEnum;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.form.RoleForm;
import com.example.demo.security.JwtProperties;
import com.example.demo.security.JwtUserDetailServiceImpl;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtil;
import com.example.demo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : UserServiceImpl  //类名
 * @Description : 用户实现类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/9/27  16:07
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String key = "anonymousUser";
        if (!userName.equals(key)) {
            return userDao.getUserByUserName(userName);
        }
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = userDao.getUserByUserName(userName);
        return user;
    }

    @Override
    public int getUserRole(Integer id) {
        int role = userDao.selectUserRoleById(id);
        return role;
    }

    @Override
    public ResultVO login(@RequestBody LoginForm loginForm, HttpServletResponse response) {
        User user = getUserByUserName(loginForm.getUserName());
        if (null == user) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST_ERROR);
        }
        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(loginForm.getUserName());
        if (!(new BCryptPasswordEncoder().matches(loginForm.getPassword(), userDetails.getPassword()))) {
            return ResultVOUtil.error(ResultEnum.PASSWORD_ERROR);
        }
        Authentication token = new UsernamePasswordAuthenticationToken(loginForm.getUserName(), loginForm.getPassword(), userDetails.getAuthorities());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String realToken = jwtTokenUtil.generateToken(userDetails);
        response.addHeader(jwtProperties.getTokenName(), realToken);
        Map<String, Serializable> map = new HashMap<>();
        map.put("name", user.getUserName());
        map.put("userId", user.getId());
        map.put("role", userDao.selectUserRoleById(user.getId()));
        map.put("token", realToken);
        return ResultVOUtil.success(map);
    }

    @Override
    public ResultVO register(RegisterForm registerForm) {
        boolean isHave = userDao.getUserByUserName(registerForm.getUserName()) != null;
        if (isHave) {
            return ResultVOUtil.error(ResultEnum.USER_EXIST_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        int insert = userDao.insert(user);
        if (insert != 1) {
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        //role默认为0；
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(RoleEnum.USER.getValue() + 1);
        userRoleDao.insert(userRole);
        return ResultVOUtil.success("注册成功");
    }

    @Override
    public ResultVO getCurrentUserVO() {
        User user = getCurrentUser();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        int role = userDao.selectUserRoleById(user.getId());
        userVO.setRole(role);
        return ResultVOUtil.success(userVO);
    }

    @Override
    public ResultVO modifyRole(RoleForm roleForm) {
        User user = userDao.selectByPrimaryKey(roleForm.getId());
        if (user == null) {
            return ResultVOUtil.error(ResultEnum.USER_EXIST_ERROR);
        }
        userRoleDao.modifyRoleById(roleForm.getId(), roleForm.getRole() + 1);
        return ResultVOUtil.success();
    }
}
