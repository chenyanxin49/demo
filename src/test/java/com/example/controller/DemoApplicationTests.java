package com.example.controller;

import com.example.common.PoiDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private HelloWorld h;

    @Autowired
    private PoiDemo poi;

    @Test
    public void contextLoads() {
        System.out.println(h.home());
        File srcF = new File("E:\\上海项目\\树种班号信息\\2017.8.9\\横沙乡2017小班信息1.xlsx");
        String fileName = "横沙乡2017小班信息1.xlsx";
        try {
            poi.batchImport(srcF, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
