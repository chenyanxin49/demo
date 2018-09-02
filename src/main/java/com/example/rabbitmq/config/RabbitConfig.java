package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: realtour-r8-qj-b2b
 * @description: rabbitMQ 配置类
 * @author: chenYanXin
 * @create: 2018/8/30 17:49
 */
@Configuration
public class RabbitConfig {

    /**
     * 声明队列
     */
    @Bean
    public Queue queue1() {
        // true表示持久化该队列
        return new Queue("queue1", true);
    }

    /**
     * 声明队列
     */
    @Bean
    public Queue queue2() {
        // true表示持久化该队列
        return new Queue("queue2", true);
    }

    @Bean
    public Queue queue3() {
        Map<String,Object> args=new HashMap<>();
        // 设置该Queue的死信的信箱
        args.put("x-dead-letter-exchange", "deadLetterExchange");
        // 设置死信routingKey
        args.put("x-dead-letter-routing-key", "DEAD_ROUTING_KEY");
        // 重试次数到了之后根据上面的地址发送到死信队列
        return new Queue("queue3",true,false,false,args);
    }

    /**
     * 声明交互器
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(topicExchange()).with("key.#");
    }

}