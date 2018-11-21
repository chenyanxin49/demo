package com.pattern.observer.wechat;

import com.pattern.observer.ObserverAble;
import com.pattern.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatServer
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/11/21 21:07
 */
public class ChatServer implements ObserverAble {

    private List<Observer> observers;

    private String message;

    public ChatServer() {
        observers = new ArrayList<>();
    }

    /**
     * 注册观察者
     *
     * @param msg 要发送的消息
     */
    public void sendInformation(String msg) {
        System.out.println("要推送的消息：" + msg);
        message = msg;
        notifyObserver();
    }

    /**
     * 注册观察者
     *
     * @param o 观察者
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     *
     * @param o 观察者
     */
    @Override
    public void removeObserver(Observer o) {
        if (!observers.isEmpty()) {
            observers.remove(o);
        }
    }

    /**
     * 通知观察者
     */
    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(message));
    }
}
