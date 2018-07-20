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
        /*
         * 　　1、线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。
         *
         * 　　2、当调用 execute() 方法添加一个任务时，线程池会做如下判断：
         *
         * 　　 a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
         *
         * 　　 b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
         *
         * 　　 c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
         *
         * 　　 d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”。
         *
         * 　　3、当一个线程完成任务时，它会从队列中取下一个任务来执行
         *
         *    4、当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，
         *      如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。
         *
         *      并不是先加入任务就一定会先执行。假设队列大小为 10，corePoolSize 为 3，maximumPoolSize 为 6，
         *      那么当加入 20 个任务时，执行的顺序就是这样的：首先执行任务 1、2、3，然后任务 4~13 被放入队列。这时候队列满了，
         *      任务 14、15、16 会被马上执行，而任务 17~20 则会抛出异常。最终顺序是：1、2、3、14、15、16、4、5、6、7、8、9、10、11、12、13。
         *
         * int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler
         *    int corePoolSize 指的是保留的线程池大小。
         *
         * 　　int maximumPoolSize 指的是线程池的最大大小。
         *
         * 　　long keepAliveTime 指的是空闲线程结束的超时时间。
         *
         * 　　TimeUnit unit 是一个枚举，表示 keepAliveTime 的单位。
         *
         * 　　BlockingQueue<Runnable> workQueue 表示存放任务的队列。
         *
         *    ThreadFactory threadFactory 定义线程名
         *
         *    RejectedExecutionHandler 超出处理能力时
         * 　　ThreadPoolExecutor.AbortPolicy：表示拒绝任务并抛出异常
         *
         * 　　ThreadPoolExecutor.DiscardPolicy：表示拒绝任务但不做任何动作
         *
         * 　　ThreadPoolExecutor.CallerRunsPolicy：表示拒绝任务，并在调用者的线程中直接执行该任务
         *
         * 　　ThreadPoolExecutor.DiscardOldestPolicy：表示先丢弃任务队列中的第一个任务，然后把这个任务加进队列。
         *
         *    BlockingQueue 只是一个接口，常用的实现类有 LinkedBlockingQueue 和 ArrayBlockingQueue。
         *    用 LinkedBlockingQueue 的好处在于没有大小限制。这样的话，因为队列不会满，所以 execute() 不会抛出异常，
         *    而线程池中运行的线程数也永远不会超过 corePoolSize 个，keepAliveTime 参数也就没有意义了。
         */

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
