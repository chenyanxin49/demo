package com.example.threadpool;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author chenYanXin
 * @date 2018/9/14 17:27
 * Demo1
 */
public class Demo1 {

    public static void main(String[] args) {
        String s = methodTest();
        System.out.println(s);
    }

    private static String methodTest() {
        try {
            int i = 1 / 0;
            System.out.println("/0");
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(("123456".toLowerCase() + "@user").getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            System.out.println(new BigInteger(1, md.digest()).toString(16));
            return "normal";
        } catch (Exception ex) {
            System.out.println("catch到了");
        } finally {
            System.out.println("finally");
        }
        return "finally";
    }
}
