package com.example.controller;

import com.example.serivce.IPoiDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by      Intellij IDEA
 *
 * @author :      ChenYanxin
 * Date    :       2018-03-21
 * Time    :       14:00
 * Version :       1.0
 * Company :       北京太比雅科技(武汉研发中心)
 */
@Controller
public class HelloWorld {

    @Autowired
    private IPoiDemoService poiDemoService;

    @ResponseBody
    @RequestMapping("/hello")
    public String home() {
        Class<? extends IPoiDemoService> aClass = poiDemoService.getClass();
        return String.format(" hello world = %s", aClass);
    }

}
