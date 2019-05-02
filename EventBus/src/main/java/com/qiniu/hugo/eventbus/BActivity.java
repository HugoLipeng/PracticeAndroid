package com.qiniu.hugo.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qiniu.hugo.eventbus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
// B页面
public class BActivity extends Activity {
    private TextView tv_title;
    private Button bt_send_data;
    private Button bt_send_object_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_b);

        initView();

        initData();
    }

    private void initData() {
        // 普通
        bt_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发布消息
                EventBus.getDefault().post("发送普通数据");

                finish();
            }
        });

        // 对象
        bt_send_object_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发布对象数据
                EventBus.getDefault().post(new MessageEvent("dahaige","123456"));

                finish();
            }
        });
    }

    private void initView() {
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("B页面");

        bt_send_object_data = (Button)findViewById(R.id.bt_send_object_data);
        bt_send_data = (Button)findViewById(R.id.bt_send_data);
    }
}
