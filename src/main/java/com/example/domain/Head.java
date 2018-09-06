package com.example.domain;

import lombok.Data;

/**
 * @program: realtour-r8-qj-b2b
 * @description:
 * @author: chenYanXin
 * @create: 2018/9/3 17:39
 */
@Data
public class Head {
    private ApiMsg apiMsg;
    private String partnerId = "f60ce42a-636d-c002-8721-f5ba6c15cbc2";
    private String function;
    private String sign;
    private String time;
    private String tokenId = "";
}
