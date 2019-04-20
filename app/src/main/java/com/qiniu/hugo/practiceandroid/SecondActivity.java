package com.qiniu.hugo.practiceandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by hugo on 2019/4/19.
 */

public class SecondActivity extends AppCompatActivity{

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout); 
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d(TAG, "onCreate: "+data);
    }
}
