package com.example.domain;

import java.io.Serializable;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/26
 * Time     :       11:22
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Bar
 */
public class Bar implements Serializable {

    private String name;

    public Bar() {
    }

    public Bar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                '}';
    }
}
