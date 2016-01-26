package com.unipair_demo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 2016-01-21.
 */

public class Activity_Loginform extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);


        Button connectBtn = (Button) findViewById(R.id.bt_cnt);
        connectBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Loginform.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}