package com.qiniu.hugo.getmyphonenumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private ListView lv;
	private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetNumber.getNumber(this);
        lv = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter(GetNumber.lists, this);
        lv.setAdapter(adapter);
    }
}