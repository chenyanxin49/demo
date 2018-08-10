package com.example.domain;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/19
 * Time     :       15:18
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Player
 */
public class Player implements Runnable {
    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;

    public Player(int i, CountDownLatch begin, CountDownLatch end) {
        super();
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            // 等待begin的状态为0
            begin.await();
            // 随机分配时间，即运动员完成时间
            Random r = new Random();
            int i = r.nextInt(5);
            Thread.sleep(i);
            System.out.println("Play" + id + " arrived. use " + i);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 使end状态减1，最终减至0
            end.countDown();
        }
    }
}
