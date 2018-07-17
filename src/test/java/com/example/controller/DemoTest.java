package com.example.controller;

import com.example.domain.UserA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/17
 * Time     :       10:51
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * DemoTest
 */
@RunWith(SpringRunner.class)
public class DemoTest {

    @Test
    public void demoTest(){
        UserA a = new UserA();
        UserA b = new UserA();
        a.setName("a");
        b.setName("a");
        boolean equals = a.equals(b);
        System.out.println(equals);
    }
}
