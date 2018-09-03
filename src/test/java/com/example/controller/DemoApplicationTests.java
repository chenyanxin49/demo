package com.example.controller;

import com.example.common.PoiDemo;
import com.example.rabbitmq.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private HelloWorld h;

    @Autowired
    private PoiDemo poi;

    @Autowired
    private Sender sender;

    @Test
    public void mqTest() throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            String msg = LocalDateTime.now().toString();
//            sender.send(msg);
//            Thread.sleep(1000);
//        }
    }

    @Test
    public void contextLoads() {
        System.out.println(h.home());
        File srcF = new File("E:\\武汉研发中心工作\\河长制资料\\宿州水文局数据库淮北数据梳理.xlsx");
        String fileName = "横沙乡2017小班信息1.xlsx";
        try {
            poi.batchImport(srcF, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
