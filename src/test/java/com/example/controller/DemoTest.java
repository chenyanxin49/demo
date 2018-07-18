package com.example.controller;

import com.example.domain.UserA;
import org.apache.commons.lang3.StringUtils;

import java.security.Key;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//        LocalDate localDate = equalsTest();
//        iteratorTest();
//        listSortTest();
//        mapTest();
//        streamTest();
//        lambdaTest();
//        reduceTest();
//        mapOprTest();
        operationTest();
    }

    private static void operationTest() {
        byte m=-8;
        System.out.println("m的二 进 制码是："+Integer.toBinaryString(m));
        System.out.println("m>>2的二进制码是："+Integer.toBinaryString(m>>3));
        System.out.println("(m>>2)="+(m>>3));
        System.out.println("m<<2的二进制码是："+Integer.toBinaryString(m<<2));
        System.out.println("(m<<2)=:"+(m<<2));
        System.out.println("m>>>2的二进制码是："+Integer.toBinaryString(m>>>2));
        System.out.println(" m>>>2 :"+ (m>>>2));
    }

    private static void reduceTest() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double total = 0;
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            total = total + price;
//
//        }
//        System.out.println("Total : " + total);

        // New way:
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Total : " + bill);
    }

    private static void lambdaTest() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        complexFilter(languages, (str) -> str.length() > 4, (str) -> str.endsWith("a"));
    }

    private static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    private static void complexFilter(List<String> names, Predicate<String> condition, Predicate<String> condition1) {
        names.stream()
                .filter(condition.and(condition1))
                .forEach(System.out::println);
    }

    private static void streamTest() {
//        IntStream.of(1, 2, 3).forEach(System.out::println);
//        IntStream.range(1, 3).forEach(System.out::println);
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        Random seed = new Random();
        seed.nextInt();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
    }

    private static void mapOprTest() {
        Map<String, Integer> map = new HashMap<>(16);
        for (Integer i = 0; i < 10; i++) {
            map.put(i.toString(), i);
        }
        Map.Entry<String, Integer> r = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(r);
    }

    private static void mapTest() {
        Map<String, Integer> map = new HashMap<>(10000);
        for (Integer i = 0; i < 10000; i++) {
            map.put(i.toString(), i);
        }
        System.out.println("entrySet start : " + System.currentTimeMillis());
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key + " value = " + value);
        }
        System.out.println(map.size());
        System.out.println("entrySet end : " + System.currentTimeMillis());
        System.out.println("===========================");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            Integer integer = map.get(string);
//            System.out.println("key = " + string + " value = " + integer);
        }
        System.out.println("===========================");
        System.out.println("forEach start : " + System.currentTimeMillis());
        map.forEach((k, v) ->
                System.out.println("key = " + k + " value = " + v)
        );
        System.out.println("forEach end : " + System.currentTimeMillis());
    }

    private static LocalDate equalsTest() {
        Integer a = 15;
        Integer b = 15;
        boolean equals = a.equals(b);
        System.out.println("== " + (a == b) + "equals " + equals);
        Date d = new Date();
        d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
        return LocalDate.now();
    }

    private static void listSortTest() {
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

        l.sort((o1, o2) ->
                {
                    return o1.getAge().compareTo(o2.getAge());
                }
        );

        l.sort(Comparator.comparing(UserA::getAge));

        l.forEach(System.out::println);

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

    private static void iteratorTest() {
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
        System.out.println(list.size());
    }

}
