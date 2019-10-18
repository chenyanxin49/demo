package com.example.tests;

import com.alibaba.fastjson.JSONObject;
import com.example.common.EncryptUtil;
import com.example.common.HttpUtil;
import com.example.common.JsonUtil;
import com.example.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
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

    private static Logger logger = LoggerFactory.getLogger(DemoTest.class);

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
//        flatMapTest();
//        threadTest();
//        executorsTest();
//        invokeAllTest();
//        invokeAnyTest();
//        scheduledExecutorTest();
//        m1((Integer) 1);
//        formatter();
//        stringFormat();
//        messageFormat();
//        printf();
//        useByteBuffer();
//        byteOrder();
//        compact();
//        viewBuffer();
//        testProcessHandle();
//        variableHandlesTest();
//        System.out.println(JSONObject.parseObject(encryptTest()));
//        jsonTest();
//        Bar bar = tTest(Bar.class);
//        assert bar != null;
//        System.out.println(bar.getName());
//        Foo foo = tTest(Foo.class);
//        assert foo != null;
//        System.out.println(foo.getName());
//        Foo f = null;
//        Foo f1 = new Foo("1");
//        List<Foo> l = new ArrayList<>();
//        l.add(f1);
//        l.add(f);
//        List<String> collect = l.stream().map(x -> x.getName()).collect(Collectors.toList());
//        String[] strArr = new String[] { "www.micmiu.com",
//                "!@#$%^&*()_+{}[]|\"'?/:;<>,.", "！￥……（）——：；“”‘’《》，。？、", "不要啊",
//                "やめて韩佳人", "한가인" };
//        for (String str : strArr) {
//            System.out.println("===========> 测试字符串：" + str);
//            System.out.println("Unicode判断结果 ：" + ChineseChUtil.isChinese(str));
//            System.out.println("详细判断列表：");
//            char[] ch = str.toCharArray();
//            for (char c : ch) {
//                System.out.println(c + " --> " + (ChineseChUtil.isChinese(c) ? "是" : "否"));
//            }
//        }

//        DateUtil d = DateUtil.now();
//        d.setMonth(12).setDayOfMonth(27);
//        System.out.println(d.localDateTime.getDayOfWeek());
//        System.out.println(d.with(DayOfWeek.SUNDAY));
//        System.out.println(d.localDateTime.getDayOfWeek());
//        System.out.println("01中国6FeL.Lwt".substring("01中国6FeL.Lwt".lastIndexOf(".")));
//        Foo f1 = new Foo("1");
//        f1.setBars(Arrays.asList(new Bar("bar1"),new Bar("bar2"),new Bar("bar3")));
//        f1.setBar(new Bar("bar"));
//        Foo foo = cloneObject(f1);
//        System.out.println(foo.toString());
        DateUtil d = DateUtil.now();
        System.out.println(d.format("EEEE"));
    }

    /**
     * 对象深克隆
     *
     * @param model 对象
     * @param <T>   泛型
     * @return 克隆的新对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T cloneObject(T model) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(model);
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void dateTest1() {
        DateUtil dateUtil = DateUtil.now().with(DayOfWeek.of(1)).plusDays(7);
        String firstDay = dateUtil.format("yyyy-MM-dd");
        String lastDay = dateUtil.plusDays(6).format("yyyy-MM-dd");
        System.out.println(firstDay + "==" + lastDay);
        System.out.println(dateUtil.parseOf("2018-09-08").format());
    }

    private static <T> T tTest(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class);
            T t = constructor.newInstance("lisi");
            Method[] bar = clazz.getMethods();
            for (Method method : bar) {
                System.out.println(method.getName());
                if ("getName".equals(method.getName())) {
                    System.out.println(method.invoke(t));
                }
                if ("setName".equals(method.getName())) {
                    method.invoke(t, "lisi");
                }
                throw new RuntimeException();
            }
            Method setName = clazz.getMethod("setName", String.class);
            setName.invoke(t, "ls");
            return t;
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    private static void jsonTest() {
        String s = JSONObject.toJSONString(new Person("1905", "154", 19000));
        System.out.println(s);
        Child child = JSONObject.parseObject(s, Child.class);
        System.out.println(child);
        System.out.println(JsonUtil.toJsonString(child));
        String strno = ",1,1,2 , ,,,3, ";
        for (String string : StringUtils.split(strno, ",")) {
            System.out.println(string);
        }
    }

    private static String encryptTest() {
        RequestApiData jsonParams = new RequestApiData();
        Head head = new Head();
        Map<String, String> body = new HashMap<>();
        head.setPartnerId("f60ce42a-636d-c002-8721-f5ba6c15cbc2");
        head.setFunction("GetSysDestinationDetail");
        head.setTokenId("");
        body.put("DestinationId", "000D6FD7-3971-457A-AF0A-3C4397F2B7BE");
        String time = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        head.setTime(time);
        String apiMd5 = EncryptUtil.getAPIMd5(JSONObject.toJSONString(body).concat(time), "QKCEHS5./37jghI@GSCG");
        head.setSign(apiMd5);
        jsonParams.setHead(head);
        jsonParams.setBody(JSONObject.toJSONString(body));
        String s = JSONObject.toJSONString(jsonParams);
        return HttpUtil.doPostForJson("http://r8.realtour-develop.cn/Api/ApiForB2B/ApiForB2B.ashx", s);
    }

    private static void exceptionTest() throws Exception {

        // 异常捕获后就不会再往下传递

        BufferedReader bufferedWriter = new BufferedReader(new FileReader("a.txt"));
        int read = bufferedWriter.read();
        try {
            exceptionTest();
        } catch (Exception e) {
            logger.error("getMessage:{}", e.getMessage());
            logger.error("getCause:{}", e.getCause());
            logger.error("getLocalizedMessage:{}", e.getLocalizedMessage());
            logger.error("getClass:{}", e.getClass().toString());
            logger.error("getClass:{}", e.getClass().getName());
            e.printStackTrace();
            System.out.println("Exception");
        }
    }

    private static void variableHandlesTest() {
        try {
            Demo instance = new Demo();
            System.out.println(instance);
            VarHandle arrayVarHandle = MethodHandles.arrayElementVarHandle(int[].class);

            // 访问public成员 proteced成员
            VarHandle countHandle = MethodHandles.lookup()
                    .in(Demo.class)
                    .findVarHandle(Demo.class, "count", int.class);
            countHandle.set(instance, 99);

            // 访问private成员
            countHandle = MethodHandles.privateLookupIn(Demo.class, MethodHandles.lookup())
                    .findVarHandle(Demo.class, "name", String.class);
            countHandle.set(instance, "hello world");
            // 替换指定位置，指定数值的值
            arrayVarHandle.compareAndSet(instance.arrayData, 1, 5, 100);
            arrayVarHandle.compareAndSet(instance.arrayData, 0, 3, 300);
            System.out.println(instance);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void testProcessHandle() {
        final ProcessHandle processHandle = ProcessHandle.current();
        final ProcessHandle.Info info = processHandle.info();
        System.out.println("Process info =>");
        System.out.format("PID: %s%n", processHandle.pid());
        info.arguments().ifPresent(args -> System.out.format("Arguments: %s%n", Arrays.toString(args)));
        info.command().ifPresent(command -> System.out.format("Command: %s%n", command));
        info.commandLine()
                .ifPresent(commandLine -> System.out.format("Command line: %s%n", commandLine));
        info.startInstant()
                .ifPresent(startInstant -> System.out.format("Start time: %s%n", startInstant));
        info.totalCpuDuration()
                .ifPresent(cpuDuration -> System.out.format("CPU time: %s%n", cpuDuration));
        info.user().ifPresent(user -> System.out.format("User: %s%n", user));
    }

    private static void useByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 1);
        buffer.put(new byte[3]);
        buffer.putChar('A');
        buffer.putFloat(0.0f);
        buffer.putLong(10, 100L);
        System.out.println(buffer.getChar(4));
        System.out.println(buffer.remaining());
    }

    private static void byteOrder() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.getInt(0));
    }

    private static void compact() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put(new byte[16]);
        buffer.flip();
        buffer.getInt();
        buffer.compact();
        System.out.println(buffer.position());
    }

    private static void viewBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putInt(1);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(2);
        System.out.println(buffer.getInt());
    }

    public void uncaughtException(Thread t, Throwable e) {
        System.err.printf("%s: %s at line %d of %s%n",
                t.getName(),
                e.toString(),
                e.getStackTrace()[0].getLineNumber(),
                e.getStackTrace()[0].getFileName());
    }

    private static void printf() {
        //printf
        String filename = "E:\\123.txt";
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                System.out.printf("Line %d: %s%n", i++, line);
            }

            Files.walk(Paths.get("target"), FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);
        } catch (Exception e) {
            System.err.printf("Unable to open file named '%s': %s",
                    filename, e.getMessage());
        }
    }

    private static void stringFormat() {
        // Format a string containing a date.
        Calendar c = new GregorianCalendar(1995, Calendar.MAY, 23);
        String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
        // -> s == "Duke's Birthday: May 23, 1995"
        System.out.println(s);
    }

    private static void formatter() {
        StringBuilder sb = new StringBuilder();
        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb, Locale.US);
        // Explicit argument indices may be used to re-order output.
        formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
        // -> " d  c  b  a"
        // Optional locale as the first argument can be used to get
        // locale-specific formatting of numbers.  The precision and width can be
        // given to round and align the value.
        formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);
        // -> "e =    +2,7183"
        // The '(' numeric flag may be used to format negative numbers with
        // parentheses rather than a minus sign.  Group separators are
        // automatically inserted.
        formatter.format("Amount gained or lost since last statement: $ %(,.2f", 6217.58);
        // -> "Amount gained or lost since last statement: $ (6,217.58)"
    }

    private static void messageFormat() {
        String msg = "欢迎光临，当前（{0}）等待的业务受理的顾客有{1}位，请排号办理业务！";
        MessageFormat mf = new MessageFormat(msg);
        String fmsg = mf.format(new Object[]{new Date(), 35});
        System.out.println(fmsg);
    }

    /**
     * 包装类型高于基本类型，传参优先考虑基本类型
     */
    private static void m1(Integer i) {
        System.out.println("this is integer");
    }

    private static void m1(double d) {
        System.out.println("this is double");
    }

    private static void scheduledExecutorTest() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
            long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.println("Remaining Delay: " + remainingDelay);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    private static void invokeAnyTest() {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        try {
            String result = executor.invokeAny(callables);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void invokeAllTest() {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        try {
            executor.invokeAll(callables).stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executorsTest() {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        });

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        try {
            Integer result = future.get(1, TimeUnit.SECONDS);

            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.err.println("tasks interrupted");
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    private static void threadTest() {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！可以被重复调用。
        task.run();

        Thread thread = new Thread(task);
        // 启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
        thread.start();

        System.out.println("Done!");

        Thread t = new Thread(DemoTest::pong);
//        t.run();
        t.start();
        System.out.println("ping");
    }

    private static void pong() {
        System.out.println("pong" + Thread.currentThread().getName());
    }

    private static void flatMapTest() {
//        List<Foo> foos = new ArrayList<>();
//          // create foos
//        IntStream
//                .range(1, 4)
//                .forEach(i -> foos.add(new Foo("Foo" + i)));
//          // create bars
//        foos.forEach(f ->
//                IntStream
//                        .range(1, 4)
//                        .forEach(i -> f.getBars().add(new Bar("Bar" + i + " <- " + f.getName()))));
//        foos.stream()
//                .flatMap(foo -> foo.getBars().stream())
//                .forEach(bar -> System.out.println(bar.getName()));

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.getName()))
                        .forEach(f.getBars()::add))
                .flatMap(f -> f.getBars().stream())
                .forEach(b -> System.out.println(b.getName()));

        int[] arr = {4, 12, 1, 3, 5, 7, 9};

        long count = Arrays.stream(arr).filter(x -> x > 2).peek(System.out::println).count();
        System.out.println(count);

        final int num = 3;
        Function<Integer, Integer> fun = (from) -> from * num;
        System.out.println(fun.apply(5));
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
//        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
//                .withLocale(Locale.GERMAN);
//
//        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
//        System.out.println(xmas);

//        Date d = new Date();
//        d.setTime(d.getTime() - 24 * 60 * 60 * 1000);
//        System.out.println(d);

//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter df1 = DateTimeFormatter.ISO_DATE_TIME;
//        System.out.println(df1.parse("2011-12-03T10:15:30+01:00"));
//        System.out.println(df.parse("2012-07-01"));

        LocalDate localDate = LocalDate.now();
//        LocalDateTime ld = LocalDateTime.now();
//        Instant i = Instant.now();
        System.out.println(String.format("%s %s", localDate.toString(), LocalTime.now().toString().substring(0, 8)));
//        System.out.println(df.format(localDate));
        LocalDate firstDayOfThisMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth);

        // 取本月第2天：
        LocalDate secondDayOfThisMonth = localDate.withDayOfMonth(2);
        System.out.println(secondDayOfThisMonth);

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth);

        // 取下一天：
        LocalDate nextDay = lastDayOfThisMonth.plusDays(1);
        System.out.println(nextDay);

        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOf2015);

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

        List<Integer> arr = List.of(4, 12, 1, 3, 5, 7, 9);

        arr.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
        System.out.println(arr.stream().reduce(-10, (x, y) -> x + y));
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

    private static void streamTest() {
//        IntStream.of(1, 2, 3).forEach(System.out::println);
//        IntStream.range(1, 3).forEach(System.out::println);
//        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        Random seed = new Random();
        Supplier<Integer> random = () -> seed.nextInt(3) + 1;
        Stream.generate(random).limit(3).forEach(System.out::println);

        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));
        List<Person> filtered = persons.stream()
                .filter(p -> p.getName().startsWith("P"))
                .collect(Collectors.toList());
        System.out.println(filtered);    // [Peter, Pamela]

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        String phrase = persons
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(phrase);

        // 需要传递一个收集器的四个组成部分：供应器、累加器、组合器和终止器。
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                        StringJoiner::merge,                        // combiner (j1, j2) -> j1.merge(j2)
                        StringJoiner::toString);                // finisher
        String names = persons
                .stream()
                .collect(personNameCollector);
        System.out.println(names);  // MAX | PETER | PAMELA | DAVID

        int[] arr = {4, 12, 1, 3, 5, 7, 9};

        List<Integer> list = Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);

//        Set<Integer> set = list.stream().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set);

        Map<String, Person> map = persons.stream()
                .collect(Collectors.toMap(Person::getName, a -> a));
        System.out.println(map);
    }

    private static void mapOprTest() {
        Map<String, Integer> map = new HashMap<>(16);
        for (Integer i = 0; i < 10; i++) {
            map.put(i.toString(), i);
        }
        Map.Entry<String, Integer> r = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElse(null);
        // 用get需要保证有值，否则会抛出异常
        map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).ifPresent(System.out::println);

        System.out.println(r);

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));

        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                });
        boolean a = stream.anyMatch(s -> true);    // ok
//        a = stream.noneMatch(s -> true);   // exception 因为流已经关闭

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                });
        a = streamSupplier.get().anyMatch(s -> true);   // ok
        a = streamSupplier.get().noneMatch(s -> true);  // ok
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
        Comparator<Person> comparator = Comparator.comparingInt(Person::getAge);

        Person p1 = new Person("John", 1);
        Person p2 = new Person("Alice", 1);

        int compare = comparator.compare(p1, p2);// > 0
        int compare1 = comparator.reversed().compare(p1, p2);// < 0
        System.out.println(compare + "==" + compare1);

    }

    private static void listSortTest() {
        Person u1 = new Person();
        Person u2 = new Person();
        u1.setAge(1);
        u2.setAge(2);

        List<Person> l = new ArrayList<>();
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
//        l.sort(Comparator.comparing(Person::getAge));
        // 遍历输出
//        l.forEach(System.out::println);
        // 还可以用流写成
        l.stream().sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge())).forEach(System.out::println);

//        Comparator<Person> comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
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
