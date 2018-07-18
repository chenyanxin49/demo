package com.example.controller;

import com.example.domain.UserA;

import java.time.LocalDate;
import java.util.*;

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
public class DemoTest {

    public static void main(String[] args) {
        Integer a = 155;
        Integer b = 155;
        boolean equals = a.equals(b);
        System.out.println(a == b);
        Date d = new Date();
        d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
        LocalDate localDate = LocalDate.now();
        int year1 = localDate.getYear();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Integer n = 1;
//        for (String item : list) {
//            if (n.toString().equals(item)) {
//                list.remove(item);
//                n++;
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (n.toString().equals(next)) {
                list.remove(next);
//                iterator.remove();
                n++;
            }
        }
//        System.out.println(list.size());

        UserA u1 = new UserA();
        UserA u2 = new UserA();
        u1.setAge(1);
        u2.setAge(2);

        List<UserA> l = new ArrayList<>();
        l.add(u1);
        l.add(u2);
        l.sort((o1, o2) ->
                {
                    if (o1.getAge() > o2.getAge()) {
                        return 1;
                    } else if (o1.getAge() < o2.getAge()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
        );
//        Comparator<UserA> comparator = new Comparator<UserA>() {
//            @Override
//            public int compare(UserA o1, UserA o2) {
//                if (o2.getAge() > o1.getAge()) {
//                    return 1;
//                } else if (o2.getAge() < o1.getAge()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        };
//        l.sort(comparator);
        System.out.println("args = [" + l + "]");
    }

}
