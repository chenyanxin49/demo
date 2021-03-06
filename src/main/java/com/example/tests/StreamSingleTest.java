package com.example.tests;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Foo;
import com.example.domain.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/2
 * Time     :       16:18
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * StreamSingleTest
 */
public class StreamSingleTest {

    public static void main(String[] args) {
//        tryWithResources();
//        createStream();
//        streamChangeTest();
//        mapTest();
//        filterTest();
//        forEachTest();
//        reduceTest();
//        limitSkipTest();
//        sortedTest();
//        minMaxDistinctTest();
//        matchTest();
//        generateTest();
//        iterateTest();
//        collectorsTest();
        Foo foo = new Foo("foo");
        String s = JSONObject.toJSONString(foo);
        Foo foo1 = JSONObject.parseObject(s, Foo.class);

    }

    private static void collectorsTest() {
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier())
                .limit(20)
                .collect(Collectors.groupingBy(Person::getAge));
        personGroups.forEach((key, value) -> System.out.println("Age " + key + " = " + value.size()));

        Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
                limit(20).
                collect(Collectors.partitioningBy(p -> p.getAge() < 18));
        System.out.println("Children number: " + children.get(true).size());
        System.out.println("Adult number: " + children.get(false).size());
    }

    private static void iterateTest() {
        // seed 第一个，f(seed) 为第二个，f(f(seed)) 第三个
        // iterate 时候管道必须有 limit 这样的操作来限制 Stream 大小。
        Stream.iterate(0, n -> n + 3)
                .limit(10)
                .forEach(x -> System.out.print(x + " "));
    }

    private static void generateTest() {
        Random seed = new Random();
        // 限定随机数区间用 seed.nextInt(10)为 0~9 nextInt(10)+1 为 1~10
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random)
                .limit(10)
                .forEach(System.out::println);

        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10)
                .forEach(System.out::println);

        Stream.generate(new PersonSupplier())
                .limit(10)
                .forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
    }

    private static class PersonSupplier implements Supplier<Person> {
        private int index = 0;
        private Random random = new Random();

        @Override
        public Person get() {
            return new Person("StormTestUser" + ++index, random.nextInt(36) + 1);
        }
    }

    private static void matchTest() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("name" + 1, 10));
        persons.add(new Person("name" + 2, 21));
        persons.add(new Person("name" + 3, 34));
        persons.add(new Person("name" + 4, 6));
        persons.add(new Person("name" + 5, 55));
        boolean isAllAdult = persons.stream()
                .allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = persons.stream()
                .anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
        boolean isThereNoneOld = persons.stream()
                .noneMatch(p -> p.getAge() > 60);
        System.out.println("None old man? " + isThereNoneOld);
    }

    private static void minMaxDistinctTest() {
        try (BufferedReader br = new BufferedReader(new FileReader("e:\\123.txt"))) {
            int longest = br.lines()
                    .mapToInt(String::length)
                    .max()
                    .orElse(-1);
            System.out.println(longest);

            BufferedReader br1 = new BufferedReader(new FileReader("e:\\123.txt"));
            List<String> words = br1.lines()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.length() > 0)
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(words);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void sortedTest() {
        List<Person> persons = new ArrayList<>();

        IntStream
                .range(1, 6)
                .forEach(i -> persons.add(new Person("name" + i, i)));

        List<Person> personList2 = persons.stream()
                .limit(2)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(personList2);
    }

    private static void limitSkipTest() {
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            Person person = new Person("name" + i, i);
            persons.add(person);
        }

        List<String> personList1 = persons.stream().
                map(Person::getName)
                .limit(10)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(personList1);

        List<Person> personList2 = persons.stream()
                // (p1, p2) -> p1.getName().compareTo(p2.getName())
                .sorted(Comparator.comparing(Person::getAge))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(personList2);

    }

    private static void reduceTest() {
        IntStream integers = IntStream.range(1, 3);
        Integer sum = integers.reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("1", String::concat);
        System.out.println(concat);

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        // 求和，sumValue = 4, 有起始值
        int sumValue = Stream.of(1, 2).reduce(1, Integer::sum);
        System.out.println(sumValue);

        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);
    }

    private static void findFirstTest() {
        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);
        getLength(strA);
        getLength("");
        System.out.println(getLength(strB));
    }

    private static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
        if (text != null) {
            System.out.println(text);
        }
    }

    private static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }

    private static void forEachTest() {
        List<Person> roster = Arrays.asList(
                new Person("max", "male", 21),
                new Person("alice", "female", 18),
                new Person("allen", "male", 23),
                new Person("barry", "female", 20)
        );

        // Java 8
        roster.stream()
                .filter(p -> p.getGender().equals(Person.Sex.MALE))
                .forEach(p -> System.out.println(p.getName()));

        // Pre-Java 8
        for (Person p : roster) {
            if (p.getGender().equals(Person.Sex.MALE)) {
                System.out.println(p.getName());
            }
        }

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void tryWithResources() {
        // 可以自动关闭资源，但并不会捕捉异常，所以要带上catch
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\123.txt"))) {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filterTest() {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums)
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\123.txt"));
            List<String> output = reader.lines().
                    flatMap(line -> Stream.of(line.split("\\s"))).
                    filter(word -> word.length() > 0).
                    collect(Collectors.toList());
            output.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void mapTest() {

        List<String> wordList = Arrays.asList("anyMatch", "allMatch", "noneMatch", "findFirst", "findAny", "limit");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        System.out.println(output);

        List<Integer> num = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNum = num.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNum);

        // 有一些场景，是一对多映射关系的，这时需要 flatMap。将层级结构扁平化，就是将最底层元素抽出来放到一起
        Stream<List<Integer>> inputStream = Stream.of(
                Collections.singletonList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                // flatMap((childList) -> childList.stream());
                        flatMap(Collection::stream);
    }

    private static void createStream() {
        Stream<Integer> stream;
//        stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        stream.forEach(System.out::println);

//        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        stream.forEach(System.out::println);

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        // 需要高于java9
////        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        // 或者使用并行流 parallelStream();
//        stream = list.stream();
//        stream.forEach(System.out::println);

        IntStream intStream;
        // 从1开始，=9结束
//        IntStream intStream = IntStream.range(1, 9);
//        intStream.forEach(System.out::println);

        intStream = new Random().ints(1, 10);
        intStream.limit(10).forEach(System.out::println);

//        final int[] i = {0};
//        stream = Stream.generate(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return i[0]++;
//        });
//        stream.forEach(System.out::println);
    }

    private static void streamChangeTest() {
        // 1,2,3,4,5 range是< rangeClosed是<=
        IntStream intStream = IntStream.range(1, 6);
        intStream.forEach(System.out::println);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = list.stream();
        // 1. Array
//        Integer[] strArray1 = stream.toArray(Integer[]::new);

        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");
        Stream<String> stream1 = list1.stream();
        // 2. Collection
//        List<String> list11 = stream1.collect(Collectors.toList());
        List<String> list2 = stream1.collect(Collectors.toCollection(ArrayList::new));
//        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));

        // 3. String
//        String str = stream1.collect(Collectors.joining()).toString();
    }
}
