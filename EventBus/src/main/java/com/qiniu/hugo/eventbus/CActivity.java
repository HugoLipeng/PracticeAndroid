package com.qiniu.hugo.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qiniu.hugo.eventbus.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
// C页面
public class CActivity extends Activity {
    private TextView tv_c_result;
    private Button bt_show_data;
    private TextView tv_title;
    private Boolean isFirstFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_c);

        initView();

        initData();
    }

    private void initData() {

        bt_show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFirstFlag) {
                    isFirstFlag = false;
                    EventBus.getDefault().register(CActivity.this);//注册之后,马上就能收到刚刚postSticky发送的事件
                }
            }
        });
    }

    private void initView() {
        tv_c_result = (TextView)findViewById(R.id.tv_c_result);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_title.setText("C页面");

        bt_show_data = (Button)findViewById(R.id.bt_show_data);
    }

    //注意,和之前的方法一样,只是多了一个 sticky = true 的属性.
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(StickyEvent event){
        tv_c_result.setText(event.msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isFirstFlag = true;
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(CActivity.class);
    }
}
