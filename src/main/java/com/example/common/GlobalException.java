package com.example.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: realtour-r8-qj-b2b
 * @description: 全局异常处理类
 * @author: 周成平
 * @create: 2018-08-21 14:26
 **/
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object resole(HttpServletRequest request, Exception e) {
        System.out.println("GlobalException" + e.getMessage() + e.getCause());
        return "error world";
    }

}
