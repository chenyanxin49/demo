package com.example.controller;

import com.example.domain.UserA;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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
//        equalsTest();
//        iteratorTest();
//        listSortTest();
//        mapTest();
//        streamTest();
//        lambdaTest();
//        reduceTest();
//        mapOprTest();
//        operationTest();
//        dateTest();

    }

    private static void operationTest() {
        byte m = -8;
        System.out.println("m的二 进 制码是：" + Integer.toBinaryString(m));
        System.out.println("m>>2的二进制码是：" + Integer.toBinaryString(m >> 3));
        System.out.println("(m>>2)=" + (m >> 3));
        System.out.println("m<<2的二进制码是：" + Integer.toBinaryString(m << 2));
        System.out.println("(m<<2)=:" + (m << 2));
        System.out.println("m>>>2的二进制码是：" + Integer.toBinaryString(m >>> 2));
        System.out.println(" m>>>2 :" + (m >>> 2));
    }

    private static void dateTest() {
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
//        System.out.println(xmas);

        Date d = new Date();
        d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
//        System.out.println(d);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df1 = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(df1.parse("2011-12-03T10:15:30+01:00"));
        System.out.println(df.parse("2012-07-01"));

        LocalDate localDate = LocalDate.now();
        LocalDateTime ld = LocalDateTime.now();
        Instant i = Instant.now();
//        System.out.println(i);
//        System.out.println(df.format(localDate));

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
        Double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .orElse(null);
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

        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
        System.out.println(
                names.stream()
                        .filter(name -> name.length() == 4)
                        .collect(Collectors.joining(", ")));
        int sum1 = IntStream.iterate(7, e -> e - 1)
                .limit(7)
                .sum();
        System.out.println(sum1);

        System.out.println(
                names.stream()
                        .filter(name -> name.startsWith("J"))
                        .filter(name -> name.length() > 3)
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", ")));
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
        Map.Entry<String, Integer> r = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElse(null);
        // 用get需要保证有值，否则会抛出异常
//        Map.Entry<String, Integer> r = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(r);
    }

    private static void mapTest() {
        Map<Integer, String> map = new HashMap<>(10000);
        for (Integer i = 0; i < 30; i++) {
            map.put(i, i.toString());
        }
//        System.out.println("entrySet start : " + System.nanoTime());
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println("key = " + key + " value = " + value);
//        }
//        System.out.println(map.size());
//        System.out.println("entrySet end : " + System.nanoTime());
//        System.out.println("===========================");
//        Set<String> strings = map.keySet();
//        for (String string : strings) {
//            Integer integer = map.get(string);
////            System.out.println("key = " + string + " value = " + integer);
//        }
//        System.out.println("===========================");
//        System.out.println("forEach start : " + System.nanoTime());
//        map.forEach((k, v) ->
//                System.out.println("key = " + k + " value = " + v)
//        );
//        System.out.println("forEach end : " + System.nanoTime());
//        map.computeIfPresent(3, (num, val) -> val + num);
//        System.out.println(map.get(3));
//
//        map.computeIfPresent(9, (num, val) -> null);
//        System.out.println(map.containsKey(9));
//
//        map.computeIfAbsent(23, num -> "val" + num);
//        System.out.println(map.containsKey(23));
//
//        map.putIfAbsent(30, "bam");
//        System.out.println(map.getOrDefault(30, "not found"));
//        System.out.println(map.get(30));

        map.merge(9, "concat", String::concat);
        System.out.println(map.get(9));
        map.put(9, map.get(9).concat("new"));
        System.out.println(map.get(9));
    }

    private static void equalsTest() {
        Integer a = 15;
        Integer b = 15;
        boolean equals = a.equals(b);
//        System.out.println("== " + (a == b) + "equals " + equals);

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
        Comparator<UserA> comparator = Comparator.comparingInt(UserA::getAge);

        UserA p1 = new UserA("John", 1);
        UserA p2 = new UserA("Alice", 1);

        int compare = comparator.compare(p1, p2);// > 0
        int compare1 = comparator.reversed().compare(p1, p2);// < 0
        System.out.println(compare + "==" + compare1);

    }

    private static void listSortTest() {
        UserA u1 = new UserA();
        UserA u2 = new UserA();
        u1.setAge(1);
        u2.setAge(2);

        List<UserA> l = new ArrayList<>();
        l.add(u1);
        l.add(u2);
//        l.sort((o1, o2) ->
//                {
//                    if (o1.getAge() > o2.getAge()) {
//                        return 1;
//                    } else if (o1.getAge() < o2.getAge()) {
//                        return -1;
//                    } else {
//                        return 0;
//                    }
//                }
//        );
        // 上面可以简化为
//        l.sort((o1, o2) ->
//                {
//                    return o1.getAge().compareTo(o2.getAge());
//                }
//        );
        // 再次简化为
//        l.sort(Comparator.comparing(UserA::getAge));
        // 遍历输出
//        l.forEach(System.out::println);
        // 还可以用流写成
        l.stream().sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge())).forEach(System.out::println);

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
//        System.out.println("args = [" + l + "]");
    }

    private static void iteratorTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Integer n = 2;
        // 并发修改时，如果只有两个元素，删除第一个元素不会报错，删除第一个元素后指标为1，长度为1，
        // 结束循环，没有机会进入next()方法，所以不会抛出异常
        for (String item : list) {
            if (n.toString().equals(item)) {
                list.remove(item);
                n++;
            }
        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if (n.toString().equals(next)) {
//                list.remove(next);
////                iterator.remove();
//                n++;
//            }
//        }
        System.out.println(list.size());
    }

}
