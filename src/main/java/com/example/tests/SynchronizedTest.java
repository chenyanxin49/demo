package com.example.tests;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/10
 * Time     :       18:59
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * SynchronizedTest
 */
public class SynchronizedTest {

    private static int COUNT = 0;

    private static ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) {

        // 定义一个有意义的线程名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        // 手动设置特定的线程池
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0, 1000)
                .forEach(i -> executor.execute(SynchronizedTest::increment));

//        stop(executor);

        System.out.println(COUNT);

        executor.submit(() -> {
            LOCK.lock();
            try {
                sleep(3);
            } finally {
                LOCK.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + LOCK.isLocked());
            System.out.println("Held by me: " + LOCK.isHeldByCurrentThread());
            boolean locked = LOCK.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        stop(executor);
    }

    private static void increment() {
//        synchronized (SynchronizedTest.class) {
//            COUNT = COUNT + 1;
//        }
        LOCK.lock();
        try {
            COUNT++;
        } finally {
            LOCK.unlock();
        }
    }

    private static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
