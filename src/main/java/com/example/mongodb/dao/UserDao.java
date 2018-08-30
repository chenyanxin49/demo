package com.example.mongodb.dao;

import com.example.demo.mongodb.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao extends MongoBaseDao<UserEntity> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 创建对象
     *
     * @param user
     */
    public void insert(UserEntity user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    /**
     * 更新对象
     *
     * @param user
     */
    public void updateUser(UserEntity user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteUserById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserEntity.class);
    }

    public List<UserEntity> findUser(int pageIndex, int pageSize) {
        //分页查询
        Query query = new Query();
        // skip("跳过的数据条数") limit("一页的数据条数");
        query.skip((pageIndex - 1) * pageSize).limit(pageSize);
        return mongoTemplate.find(query, UserEntity.class);
    }
}
