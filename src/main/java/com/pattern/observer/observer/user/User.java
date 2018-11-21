package com.pattern.observer.observer.user;

import com.pattern.observer.observer.Observer;
import lombok.Data;

/**
 * User
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/11/21 21:16
 */
@Data
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    /**
     * 拉取消息
     */
    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    private void read() {
        System.out.println(name + "用户接收到的消息：" + message);
    }
}
