package com.example.threadpool;

/**
 * @author chenYanXin
 * @date 2018/9/14 17:27
 * Demo1
 */
public class Demo1 {

    public static void main(String[] args) {
        /*
         * 实验策略是创建两个线程都进行保存student，然后都休息一段时间（给个3秒）
         * A线程休息完后修改student中的年龄为11
         * B线程在休息完3秒后继续休息2秒，目的是为了等A修改完
         * B线程休息完后取出自己所存的Student，看看里面的age到底是19还是11
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次线程");
            ThreadPools.execute(ThreadLocalTest::setPerson);
        }
    }
}
