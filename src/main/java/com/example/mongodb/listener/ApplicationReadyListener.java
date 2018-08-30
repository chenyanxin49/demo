package com.example.mongodb.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;

/**
 * @ClassName ApplicationReadyListener
 * @Description TODO
 * @Author yukun
 * @Date 2018/8/29 17:05
 * @Version 1.0
 * <p>
 * 首先，通过Spring Boot启动过程了解到，可以通过ApplicationListener监听“完成容器刷新事件”；
 * <p>
 * 接着，通过MongoTemplate源码了解到，可以通过MappingMongoConverter.setTypeMapper设置新的TypeMapper对象；
 * <p>
 * 结合上述两个情况，可以通过监听事件，在事件发生之后，重新设置TypeMapper对象，即可达到需求。
 */
@Configuration
public class ApplicationReadyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        MongoConverter converter = mongoTemplate.getConverter();
        if (converter.getTypeMapper().isTypeKey("_class")) {
            ((MappingMongoConverter) converter).setTypeMapper(new DefaultMongoTypeMapper(null));
        }
    }
}
