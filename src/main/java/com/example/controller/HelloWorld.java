package com.example.controller;

import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by      Intellij IDEA
 *
 * @author :      ChenYanxin
 * Date    :       2018-03-21
 * Time    :       14:00
 * Version :       1.0
 * Company :
 */
@RestController
public class HelloWorld {

    private final TestService testService;

    @Autowired
    public HelloWorld(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/hello")
    public String home() {
        System.out.println(123);
        return "hello world";
    }

    @RequestMapping("/errorTest")
    public String error() {
        testService.test();
        return "hello world";
    }

}
