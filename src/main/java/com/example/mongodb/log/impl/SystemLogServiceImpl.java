package com.example.mongodb.log.impl;

import com.example.demo.mongodb.dao.SystemLogRepository;
import com.example.demo.mongodb.log.SystemLogService;
import com.example.demo.mongodb.model.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /***
     * 分页查询预约记录信息(个人版)
     * @param subscribe 预约记录信息对象
     * @return
     */
    @Override
    public Page<SystemLog> find(int page, int rows, SystemLog subscribe) {
        page = page < 1 ? 1 : page;
        PageRequest pageable = PageRequest.of(page - 1, rows < 1 ? 1 : rows,
                new Sort(Sort.Direction.DESC, "add_time"));
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true)
                //改变默认大小写忽略方式：忽略大小写;
                .withMatcher("userId", ExampleMatcher.GenericPropertyMatchers.contains());
        //用户id采用全员匹配方式
        Example<SystemLog> example = Example.of(subscribe, matcher);
        return systemLogRepository.findAll(example, pageable);
    }

    @Override
    public SystemLog findone(String sessionId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userId").is(sessionId).and("storeState").is(0)), SystemLog.class);
    }

    @Override
    public void insertOne(SystemLog systemLog) {
        mongoTemplate.save(systemLog);
        systemLogRepository.save(systemLog);
    }

    @Scheduled(cron = "0 58 23 * * * ")
    public void syncTask() {
        List<SystemLog> list = mongoTemplate.find(new Query(Criteria.where("storeState").is(0)), SystemLog.class);
       /*subscribe subscribe=new subscribe();
        subscribe.setStoreState(2);*/
//        list.stream()
//                .filter(x->strToDate(x.getSubscribeDate()).before(new Date()))
//                .forEach((y)->{
//                    y.setStoreState(2);
//                    UpdateResult ret = mongoTemplate.updateFirst(new Query(Criteria.where("id").is(new ObjectId(y.getId()))), MongoUtils.mongoUpdate(y), Subscribe.class);
//                });
    }
}
