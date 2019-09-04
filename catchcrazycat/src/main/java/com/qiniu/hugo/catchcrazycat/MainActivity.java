package com.qiniu.hugo.catchcrazycat;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.PercentFrameLayout);
		setContentView(new Playground(this));
	}

}
