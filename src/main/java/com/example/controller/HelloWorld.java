package com.example.controller;

import com.example.domain.Child;
import com.example.domain.Person;
import com.example.mapper.PersonMapper;
import com.example.service.TestService;
import com.example.tests.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        DateUtil d = DateUtil.now();
        System.out.println(d.format("EEEE"));
        return d.format("EEEE");
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

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/person")
    public List<Person> listPerson(){
        return personMapper.selectByExample(null);
    }
}
