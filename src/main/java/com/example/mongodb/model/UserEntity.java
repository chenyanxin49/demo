package com.example.mongodb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author chenyanxin
 */
@Data
@Document(collection = "sysInfo_user")
public class UserEntity {

    /**
     * 条件查询用id 可以不加注解
     * 但加注解括号里的名字就必须跟数据库一致，
     * 条件查询用_id 注解就没意义了
     */
    @Field("id")
    private Integer id;
    @Field("name")
    private String userName;
    @Indexed
    private String passWord;

}
