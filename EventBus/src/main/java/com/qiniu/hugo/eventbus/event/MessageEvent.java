package com.qiniu.hugo.eventbus.event;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public class MessageEvent {
    public String name;
    public String password;

    public MessageEvent(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
