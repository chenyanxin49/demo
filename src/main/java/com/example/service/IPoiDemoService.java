package com.example.service;

import com.example.domain.Person;

import java.util.List;

/**
 * Created by      Intellij IDEA
 *
 * @author :      ChenYanxin
 * Date    :       2018-03-21
 * Time    :       14:00
 * Version :       1.0
 * Company :       北京太比雅科技(武汉研发中心)
 */
public interface IPoiDemoService {


    /**
     * 批量保存区域实现
     * @param areas
     */
    public void saveBatch(List<Person> areas);

}
