package com.example.domain;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/17
 * Time     :       10:48
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * UserA
 */
public class UserA {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
