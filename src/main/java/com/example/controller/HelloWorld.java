package com.example.controller;

import com.example.domain.Child;
import org.springframework.web.bind.annotation.*;

/**
 * Created by      Intellij IDEA
 *
 * @author :      ChenYanxin
 * Date    :       2018-03-21
 * Time    :       14:00
 * Version :       1.0
 * Company :       北京太比雅科技(武汉研发中心)
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping("/{v}")
    public String getT(@PathVariable Child v) {
        return String.format(" hello world = %s", v);
    }
    @PostMapping("/child")
    public String postT(@RequestBody Child v) {
        return String.format(" hello world = %s", v);
    }
}
