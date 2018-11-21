package com.pattern.observer;

import com.pattern.observer.observer.Observer;
import com.pattern.observer.observer.user.User;
import com.pattern.observer.wechat.ChatServer;

/**
 * TestMain
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/11/21 21:32
 */
public class TestMain {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Observer zs = new User("zs");
        Observer ls = new User("ls");
        Observer ww = new User("ww");
        chatServer.registerObserver(zs);
        chatServer.registerObserver(ls);
        chatServer.registerObserver(ww);

        chatServer.sendInformation("java is the best programming language in the world!");
        System.out.println("remove lisi----------------");
        chatServer.removeObserver(ls);
        chatServer.sendInformation("java is the best programming language!");
    }
}
