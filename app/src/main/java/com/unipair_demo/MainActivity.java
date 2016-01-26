package com.unipair_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Activity act = this;
    GridView gridView;
    private List<ResolveInfo> apps;
    private PackageManager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        pm = getPackageManager();
        apps = pm.queryIntentActivities(mainIntent, 0);

        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridview1);
        gridView.setAdapter(new gridAdapter());

        ImageButton captureBtn = (ImageButton) findViewById(R.id.capture);
        captureBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    public class gridAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public gridAdapter(){
            inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        public final int getCount(){
            return apps.size();
        }

        public final Object getItem(int position)
        {
            return apps.get(position);
        }

        public final long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {
                convertView = inflater.inflate(R.layout.items,parent,false);

            }

            final ResolveInfo info = apps.get(position);

            ImageView imageView = (ImageView) convertView
                    .findViewById(R.id.itemview);

            Log.v("[program]", info.activityInfo.packageName + "," + info.activityInfo.name);

            //그리드 뷰 매핑 및 이벤트 핸들러
//            imageView.setOnClickListener(new Button.OnClickListener() {
//                public void OnClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_RUN);
//                    intent.setComponent(new ComponentName(
//                                    info.activityInfo.packageName,
//                                    info.activityInfo.name)
//                    );
//                    act.startActivity(intent);
//                    String msg = info.activityInfo.packageName + ", "
//                            + info.activityInfo.name;
//
//                    Toast.makeText(act, msg, Toast.LENGTH_LONG).show();
//                }
//            });
            return convertView;
        }
    }


}
