package com.example.threadpool;

import com.example.domain.Person;

/**
 * @author chenYanXin
 * @date 2018/9/14 17:34
 * ThreadLocalTest
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Person> THREAD_LOCAL = new ThreadLocal<>();

    public static void setPerson() {
        if (THREAD_LOCAL.get()!= null) {
            System.out.println(Thread.currentThread().getName() + THREAD_LOCAL.get() + "直接拿到");
        } else {
            Person student = new Person();
            student.setAge(19);
            THREAD_LOCAL.set(student);
            System.out.println(Thread.currentThread().getName() + "Person 设置完成");
        }
//        THREAD_LOCAL.remove();
    }

}
