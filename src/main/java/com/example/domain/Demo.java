package com.example.domain;

import java.util.Arrays;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/30
 * Time     :       17:33
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Demo
 */
public class Demo {

    public int count = 1;
    protected long sum = 100;
    private String name = "init";
    public int[] arrayData = new int[]{3, 5, 7};

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", sum=" + sum +
                ", data=" + Arrays.toString(arrayData) +
                '}';
    }
}
