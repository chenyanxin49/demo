package com.example.mongodb;

import com.example.apptest.ApplicationHandlerTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by      Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date    :       2018/8/28
 * Time    :       21:15
 * Version :       1.0
 * Company :       北京太比雅科技(武汉研发中心)
 * MongoDao
 */
@Component
public class MongoDao {

    public static void save() {
        MongoTemplate mongoTemplate = (MongoTemplate) ApplicationHandlerTest.getBean("mongoTemplate");
        mongoTemplate.save(1);
    }
}
