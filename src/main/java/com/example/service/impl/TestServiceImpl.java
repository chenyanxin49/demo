package com.example.service.impl;

import com.example.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by      Intellij IDEA
 *
 * @author :       ChenYanxin
 * @date :       2018/9/12
 * Time    :       19:40
 * Version :       1.0
 * Company :       realtour
 * TestServiceImpl
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("service 1/0");
        int a = 1 / 0;
        System.out.println("11111111");
    }
}
