package com.example.common;

import com.example.domain.Player;
import com.example.threadpool.ThreadPools;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/19
 * Time     :       15:16
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * CountDownLatchDemo 使用 CountDownLatch 进行异步转同步操作
 */
public class CountDownLatchDemo {

    private static final int PLAYER_AMOUNT = 5;

    /**
     * 对于整个比赛，所有运动员结束后才算结束
     */
    private static final CountDownLatch END = new CountDownLatch(PLAYER_AMOUNT);

    public static void main(String[] args) {
        threadTest();
//        systemProperties();
    }

    private static void systemProperties() {

        //获取当前的系统属性
        Properties p = System.getProperties();

        //将属性列表输出
        p.list(System.out);

        //Runtime.getRuntime()获取当前运行时的实例
        Runtime runtime = Runtime.getRuntime();

        System.out.print("CPU个数:");
        //availableProcessors()获取当前电脑CPU数量
        System.out.println(runtime.availableProcessors());

        System.out.print("虚拟机内存总量:");
        //totalMemory()获取java虚拟机中的内存总量
        System.out.println(runtime.totalMemory());

        System.out.print("虚拟机空闲内存量:");
        //freeMemory()获取java虚拟机中的空闲内存量
        System.out.println(runtime.freeMemory());

        System.out.print("虚拟机使用最大内存量:");
        //maxMemory()获取java虚拟机试图使用的最大内存量
        System.out.println(runtime.maxMemory());
    }

    private static void threadTest() {

        // 对于每位运动员，CountDownLatch减1后即结束比赛
        CountDownLatch begin = new CountDownLatch(1);

        Player[] plays = new Player[PLAYER_AMOUNT];

        for (int i = 0; i < PLAYER_AMOUNT; i++) {
            plays[i] = new Player(i + 1, begin, END);
        }

        // 分配线程
        for (Player p : plays) {
            ThreadPools.execute(p);
        }

        System.out.println("Race begins!");
        begin.countDown();
        try {
            // 等待end状态变为0，即为比赛结束
            END.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Race ends!");
        }
        ThreadPools.shutDown();
    }
}