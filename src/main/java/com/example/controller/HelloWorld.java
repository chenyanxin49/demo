package com.example.controller;

import com.example.domain.Child;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/hello")
public class HelloWorld {

    private final TestService testService;

    @Autowired
    public HelloWorld(TestService testService) {
        this.testService = testService;
    }

    @GetMapping()
    public String listAll() {
        return String.format(" hello world = %s", "listAll");
    }

    @GetMapping("/{id}")
    public String getT(@PathVariable String id) {
        return String.format(" hello world = %s", id);
    }

    @PostMapping("/child")
    public String postT(@RequestBody Child v) {
        return String.format(" hello world = %s", v);
    }

    @RequestMapping("/postT")
    public String testT(String v) {
        return String.format(" hello world = %s", v);
    }

    @GetMapping("/errorTest")
    public String error() {
        testService.test();
        return "hello world";
    }
}
