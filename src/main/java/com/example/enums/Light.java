package com.example.enums;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/20
 * Time     :       17:12
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Light
 */
public enum Light {
    // 利用构造函数传参

    RED(1), GREEN(3), YELLOW(2);

    // 定义私有变量

    private int nCode;

    // 构造函数，枚举类型只能为私有

    private Light(int nCode) {

        this.nCode = nCode;

    }

    @Override
    public String toString() {

        return String.valueOf(this.nCode);

    }
}
