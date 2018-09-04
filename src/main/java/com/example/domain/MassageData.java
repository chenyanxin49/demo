package com.example.domain;

import lombok.Data;

import java.util.Map;

/**
 * @program: realtour-r8-qj-b2b
 * @description:
 * @author: chenYanXin
 * @create: 2018/9/3 11:21
 */
@Data
public class MassageData {

    private Map<String, String> head;
    private Object body;

}
