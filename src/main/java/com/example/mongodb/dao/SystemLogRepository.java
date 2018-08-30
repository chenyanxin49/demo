package com.example.mongodb.dao;

import com.example.mongodb.model.SystemLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SystemLogRepository extends MongoRepository<SystemLog, String> {

    @Query("{?0:?1}")
    public List<SystemLog> find(String key, String value);

    /**
     * 有@Query声明查询, 方法名不需要严格遵守规定
     * 根据 手机号，和昵称搜索
     * @param phone 	手机号
     * @param nickname	昵称
     * @param pageable	分页
     * @return
     */
    @Query("{$and: [{'$or':[{'phone':?0}, {'visible.nickName':{'$regex':?1, $options:'si'}}]}]}")
    public Page<SystemLog> find(final String phone, final String nickname, Pageable pageable);
}
