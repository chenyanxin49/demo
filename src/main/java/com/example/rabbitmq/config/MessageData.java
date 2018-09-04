package com.example.rabbitmq.config;

import lombok.Data;

/**
 * @program: realtour-r8-qj-b2b
 * @description:
 * @author: chenYanXin
 * @create: 2018/9/4 10:39
 */
@Data
public class MessageData {
    /**
     * 主键随机id
     */
    private String mqMsgId;

    /**
     * 对象类别名称
     */
    private String objectType;

    /**
     * 对象的主键Key
     */
    private String objectKeyId;

    /**
     * 扩展数据
     */
    private String extendData;

    /**
     * 消息入队时间
     */
    private String createTime;
}
