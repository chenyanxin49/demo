package com.example.json;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Person;

/**
 * JsonMain
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/9/24 20:32
 */
public class JsonMain {
    public static void main(String[] args) {
        Person person = JSONObject.parseObject("{ids:3,names:123}", Person.class);
        System.out.println(person);
    }
}
