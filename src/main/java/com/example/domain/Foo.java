package com.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/26
 * Time     :       11:22
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Foo
 */
public class Foo {
    private String name;
    private List<Bar> bars = new ArrayList<>();

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }
}
