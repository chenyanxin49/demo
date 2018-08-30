package com.example.rabbitmq.provider;

import com.example.rabbitmq.constant.MyConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfTopic {

    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue(MyConstant.Rabbitmq.PROVIDER_QUEQUS_ONE);
    }

    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue(MyConstant.Rabbitmq.PROVIDER_QUEQUS_TWO);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(MyConstant.Rabbitmq.EXCHANGE_ONE);
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(MyConstant.Rabbitmq.ROUTINGKEY_ONE);
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(MyConstant.Rabbitmq.ROUTINGKEY_TWO);//*表示一个词,#表示零个或多个词
    }

}
