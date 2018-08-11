package com.example.tests;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
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

    private static ReentrantLock lock = new ReentrantLock();

    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        // 定义一个有意义的线程名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        // 手动设置特定的线程池
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//        IntStream.range(0, 1000)
//                .forEach(i -> executor.execute(SynchronizedTest::increment));

//        lockTest(executor);

//        reentrantReadWriteLockTest(executor);

//        stampedLockTest(executor);

//        stampedLockTest2(executor);

//        lockTest3(executor);

        semaphoreTest(executor);

        stop(executor);

        System.out.println(COUNT);
    }

    private static void semaphoreTest(ExecutorService executor) {
        // 锁通常授予对变量或资源的独占访问权，而信号量则能够维护整套许可证。
        // 在不同的情况下，必须限制对应用程序某些部分的并发访问量
        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                // 这里调用 tryAcquire() 获取型号量设置了超时时间1秒，意味着当线程获取信号量失败后可以阻塞等待1秒再获取。
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(2);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));
    }

    private static void lockTest3(ExecutorService executor) {
        // 有时将读锁转换为写锁并不需要再次解锁和锁定是有用的。
        // StampedLock 为此提供了tryConvertToWriteLock() 方法
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.readLock();
            try {
                if (COUNT == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    /*
                     * 该任务首先获得一个读锁，并将当前的变量计数值打印到控制台。
                     * 但是，如果当前值为 0，我们要分配一个新的值23。我们首先必须将读锁转换为写锁，以不打破其他线程的潜在并发访问。
                     * 调用 tryConvertToWriteLock() 不会阻塞，但可能会返回 0，指示当前没有写锁定可用。
                     * 在这种情况下，我们调用writeLock（）来阻塞当前线程，直到写锁可用
                     */
                    if (stamp == 0L) {
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    COUNT = 23;
                }
                System.out.println(COUNT);
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                map.put("foo", "bar");
                System.out.println(map.entrySet());
                sleep(2);
            } finally {
                lock.unlockWrite(stamp);
            }
        });
    }

    private static void stampedLockTest2(ExecutorService executor) {
        // 通过调用 tryOptimisticRead() 来获取乐观读写锁，
        // tryOptimisticRead()总是返回一个值，而不会阻塞当前线程，也不管锁是否可用。
        // 如果有一个写锁激活则返回0。可以通过 lock.validate(stamp) 来检查返回的标记(long 值)是否有效。
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });
    }

    private static void lockTest(ExecutorService executor) {
        // 如果一个线程已经获得了锁，后续线程调用 lock() 会暂停线程，
        // 直到锁被释放，永远只有一个线程能获取锁。
        executor.submit(() -> {
            lock.lock();
            try {
                sleep(3);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });
    }

    private static void reentrantReadWriteLockTest(ExecutorService executor) {
        // ReadWriteLock 指定了另一种类型的锁，即读写锁。读写锁实现的逻辑是，
        // 当没有线程在写这个变量时，其他的线程可以读取这个变量，
        // 所以就是当没有线程持有写锁时，读锁就可以被所有的线程持有。
        // 如果读取比写更频繁，这将增加系统的性能和吞吐量。
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            readWriteLock.writeLock().lock();
            try {
                sleep(1);
                map.put("foo", "bar");
                System.out.println(map.entrySet());
            } finally {
                readWriteLock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                sleep(2);
            } finally {
                readWriteLock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);
    }

    private static void stampedLockTest(ExecutorService executor) {
        // 与 ReadWriteLock 不同的是，StampedLock 的锁定方法返回一个 long 值，
        // 可以利用这个值检查是否释放锁和锁是否仍然有效。另外 StampedLock 支持另外一种称为乐观锁的模式。
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
                System.out.println(map.entrySet());
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(2);
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);
    }

    private static void increment() {
//        synchronized (SynchronizedTest.class) {
//            COUNT = COUNT + 1;
//        }
        // ReentrantLock 类是一个互斥锁，它和 synchronized 关键字访问的隐式锁具有相同的功能，
        // 但它具有扩展功能。它也实现了可重入的功能
        lock.lock();
        try {
            COUNT++;
        } finally {
            lock.unlock();
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
