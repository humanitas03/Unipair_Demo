package com.unipair_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;

/**
 * Created by USER on 2016-01-21.
 */
public class Activity_Launch extends Activity {
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launch);

        Handler handler = new Handler()
        {
            public void handleMessage(Message msg)
            {
                super.handleMessage(msg);
                startActivity(new Intent(Activity_Launch.this, Activity_Loginform.class));
                Log.i("00", "start!!!");
                finish();

            }
        };
        handler.sendEmptyMessageDelayed(0,3000);
    }

}
