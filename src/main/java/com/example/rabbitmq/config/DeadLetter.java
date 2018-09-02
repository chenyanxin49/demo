package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by      Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date    :       2018/9/2
 * Time    :       19:53
 * Version :       1.0
 * Company :       realtour
 * DeadLeater
 */
@Configuration
public class DeadLetter {

//    @Bean
    public Queue maintainQueue() {
        Map<String,Object> args=new HashMap<>();
        // 设置该Queue的死信的信箱
        args.put("x-dead-letter-exchange", "DEAD_LETTER_EXCHANGE");
        // 设置死信routingKey
        args.put("x-dead-letter-routing-key", "DEAD_ROUTING_KEY");
        // 重试次数到了之后根据上面的地址发送到死信队列
        return new Queue("ROUTING_KEY",true,false,false,args);
    }

//    @Bean
    public Binding maintainBinding() {
        // 绑定上面带死信的队列到默认路由
        return BindingBuilder.bind(maintainQueue()).to(DirectExchange.DEFAULT)
                .with("ROUTING_KEY");
    }

    @Bean
    public Queue deadLetterQueue(){
        return new Queue("deadLetterQueue");
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange("deadLetterExchange", true, false);
    }

    @Bean
    public Binding deadLetterBindding(){
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with("DEAD_ROUTING_KEY");
    }
}
