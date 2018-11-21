package com.pattern.observer;

import com.pattern.observer.observer.Observer;

/**
 * observerable
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/11/21 21:06
 */
public interface ObserverAble {

    /**
     * 注册观察者
     *
     * @param o 观察者
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     *
     * @param o 观察者
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
