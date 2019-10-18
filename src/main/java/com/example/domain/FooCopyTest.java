package com.example.domain;

import lombok.Data;

import java.io.Serializable;
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
@Data
public class FooCopyTest implements Serializable {
    private String name;
    private String name1;
    private Bar bar;
    private List<Bar> bars = new ArrayList<>();

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

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
