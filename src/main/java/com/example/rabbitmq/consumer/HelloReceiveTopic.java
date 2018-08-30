package com.example.rabbitmq.consumer;

import com.example.rabbitmq.constant.MyConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class HelloReceiveTopic {

    @RabbitListener(queues= MyConstant.Rabbitmq.PROVIDER_QUEQUS_ONE)    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues= MyConstant.Rabbitmq.PROVIDER_QUEQUS_TWO)    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

}
