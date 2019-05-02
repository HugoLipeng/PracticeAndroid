package com.qiniu.hugo.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qiniu.hugo.eventbus.event.MessageEvent;
import com.qiniu.hugo.eventbus.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
// 主页面
public class MainActivity extends Activity {
    private Button bt_to_b;
    private TextView tv_result;
    private Button bt_to_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    // 初始化view
    private void initView() {
        bt_to_b = (Button) findViewById(R.id.bt_to_b);
        bt_to_c = (Button) findViewById(R.id.bt_to_c);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    // 初始化数据
    private void initData() {
        // 注册
        EventBus.getDefault().register(this);

        bt_to_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 跳转到b页面
                Intent intent = new Intent(MainActivity.this, BActivity.class);
                startActivity(intent);
            }
        });

        // 发送粘性事件
        bt_to_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发送粘性事件
                EventBus.getDefault().postSticky(new StickyEvent("我是粘性事件"));

                // 跳转到c页面
                Intent intent = new Intent(MainActivity.this, CActivity.class);
                startActivity(intent);
            }
        });
    }

    // 订阅事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        // 显示传递过来的信息
        tv_result.setText(message);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(MessageEvent event) {
        tv_result.setText("name:" + event.name + " passwrod:" + event.password);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 解注册
        EventBus.getDefault().unregister(this);
    }
}
