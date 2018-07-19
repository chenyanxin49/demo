package com.example.common;

import com.example.domain.Player;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

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

    public static void main(String[] args) {

        // 对于每位运动员，CountDownLatch减1后即结束比赛
        CountDownLatch begin = new CountDownLatch(1);

        // 对于整个比赛，所有运动员结束后才算结束
        CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);

        Player[] plays = new Player[PLAYER_AMOUNT];

        for (int i = 0; i < PLAYER_AMOUNT; i++) {
            plays[i] = new Player(i + 1, begin, end);
        }

        // 定义一个有意义的线程名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        // 手动设置特定的线程池
        ExecutorService exe = new ThreadPoolExecutor(PLAYER_AMOUNT, PLAYER_AMOUNT + 2, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        // 分配线程
        for (Player p : plays) {
            exe.execute(p);
        }

        System.out.println("Race begins!");
        begin.countDown();
        try {
            // 等待end状态变为0，即为比赛结束
            end.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Race ends!");
        }
        exe.shutdown();
    }
}
