package com.example.rabbitmq.constant;

public interface MyConstant {

    interface System{
        public static final Integer mystats=1;
    }

    interface Rabbitmq{
        //队列1
        public static final String PROVIDER_QUEQUS_ONE="topic.message";

        //队列2
        public static final String PROVIDER_QUEQUS_TWO="topic.messages";

        //交换机1
        public static final String EXCHANGE_ONE="exchange";

        //topic1
        public static final String ROUTINGKEY_ONE="topic.message";

        //topic2
        public static final String ROUTINGKEY_TWO="topic.messages";
    }

    interface redisConfig{
        //数据库0的索引
        public static final String ZERO="0";

        //数据库1的索引
        public static final String ONE="1";

        //数据库2的索引
        public static final String TWO="2";
    }

}
