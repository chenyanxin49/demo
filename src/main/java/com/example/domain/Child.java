package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/17
 * Time     :       10:48
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Person
 */
@Data
public class Child {

    @JSONField(name = "name")
    private String nameId;
    private Integer age;

}
