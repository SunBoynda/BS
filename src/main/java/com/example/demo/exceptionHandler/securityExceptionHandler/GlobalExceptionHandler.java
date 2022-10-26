package com.example.demo.exceptionHandler.securityExceptionHandler;

import com.example.demo.VO.ResultVO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exceptionHandler.GlobalException;
import com.example.demo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author wangyujie
 */
@ResponseBody
@Slf4j
//@ControllerAdvice
public class GlobalExceptionHandler {


    private final static String EXCEPTION_MSG_KEY = "Exception message : ";

    @ResponseBody
    @ExceptionHandler(GlobalException.class)
    public ResultVO handleSelfException(GlobalException exception, HttpServletResponse response) {
        log.error(EXCEPTION_MSG_KEY + exception.getMessage());
        return ResultVOUtil.error(exception);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException e) {
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return ResultVOUtil.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(HttpServletRequest request,
                                     Exception e) {
        if (e instanceof LockedException) {
            e = new GlobalException("账户被锁定，请联系管理员!", 401);
        } else if (e instanceof CredentialsExpiredException) {
            e = new GlobalException("密码过期，请联系管理员!", 401);
        } else if (e instanceof AccountExpiredException) {
            e = new GlobalException("账户过期，请联系管理员!", 401);
        } else if (e instanceof DisabledException) {
            e = new GlobalException("账户被禁用，请联系管理员!", 401);
        } else if (e instanceof BadCredentialsException) {
            e = new GlobalException("用户名或者密码输入错误，请重新输入!", 401);
        } else if (e instanceof AccessDeniedException) {
            e = new GlobalException("Forbidden:" + e.getMessage(), 403);
        }
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ResultVOUtil.error(globalException.getResultEnum());
        }
        if (e instanceof BindException) {
            //TODO,print parameters
            Map<String, String[]> parameterMap = request.getParameterMap();
            log.info("========================输出信息参数信息====================");
            parameterMap.forEach((s, strings) -> {
                log.info("param: " + s + ", value: " + strings);
            });
            log.info("========================参数打印完毕====================");
            BindException bindException = (BindException) e;
            List<ObjectError> errors = bindException.getAllErrors();
            String msg = null;
            for (ObjectError error : errors) {
                if (msg == null) {
                    msg = error.getDefaultMessage();
                } else {
                    msg += "," + error.getDefaultMessage();
                }
            }
            log.error(msg);
            ResultVOUtil.error(msg);
        }
        return ResultVOUtil.error("其他错误");
    }
}
