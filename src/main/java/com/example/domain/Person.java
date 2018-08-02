package com.example.domain;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/17
 * Time     :       10:48
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Person
 */
public class Person {

    private String name;
    private String gender;
    private Integer age;

    public interface Sex {
        /**
         * 男人
         */
        String MALE = "male";
        /**
         * 女人
         */
        String FEMALE = "female";
    }

    public Person() {
    }

    public Person(Integer age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(Integer age) {
        this.age = age;
    }

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
