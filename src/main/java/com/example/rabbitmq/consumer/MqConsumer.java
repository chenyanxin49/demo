package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by      Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date    :       2018/8/30
 * Time    :       22:23
 * Version :       1.0
 * Company :       realtour
 * MqConsumer
 */
@Component
//@RabbitListener(queues = {"queue1","queue2"})
public class MqConsumer {

    private int n = 0;
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Listener: " + msg);
    }

    @RabbitListener(queues = "queue1")
    public String processMessage1(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自queue1队列的消息：" + msg);
        return "processMessage1";
    }

    @RabbitListener(queues = "queue2")
    public void processMessage2(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自queue2队列的消息：" + msg);
        n++;
        System.out.println(n);
        int a = 1/0;
    }

    @RabbitListener(queues = "queue3")
    public void processMessage3(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自queue3带死信队列的消息：" + msg);
//        n++;
//        System.out.println(n);
//        int a = 1/0;
    }

    @RabbitListener(queues = "deadLetterQueue")
    public void deadLetterQueue(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自deadLetterQueue死信队列的消息：" + msg);
//        n++;
//        System.out.println(n);
//        int a = 1/0;
    }
}
