package com.qiniu.hugo.network;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}