package com.example.tests;

/**
 * ${description}
 *
 * @author : chenYanXin
 * @date : 2019-01-22 16:17
 */
public class TempTest {
    public static void main(String[] args) {
        DateUtil now = DateUtil.now();
        System.out.println(now.format("hh:mm"));
    }
}
