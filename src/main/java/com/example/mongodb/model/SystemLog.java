package com.example.mongodb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "app_subscribe")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SystemLog {

    @Id
    @Field
    private String id;

    @Field
    private String name;

    @Field
    private String password;

    public SystemLog(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
