package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: realtour-r8-qj-b2b
 * @description: RabbitMQ工具类
 * @author: 周成平
 * @create: 2018-08-21 14:29
 **/
public class MqTools {

    @Autowired
    private RabbitTemplate rabbitTemplate;

}
