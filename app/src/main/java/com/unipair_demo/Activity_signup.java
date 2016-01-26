package com.unipair_demo;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by USER on 2016-01-25.
 */
public class Activity_signup extends Activity {

    ActionBar actionBar;  //ActionBar 참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_main);

        //Activity 객체는 이미 ActionBar를 가지고 있으므로
        //이미 존해하는 ActionBar 객체를 얻어오기.(API 10버전 이상에서 사용가능)
        actionBar = getActionBar();

        //ActionBar가 Tab를 보여줄 수 있는 모양이 되도록 설정
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        //ActionBar에 추가 될 Tab 참조변수
        ActionBar.Tab tab = null;

        //첫번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab = actionBar.newTab(); //ActionBar에 붇는 Tab객체 생성
        tab.setText("Analog");    //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);

        //두번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab = actionBar.newTab();//ActionBar에 붇는 Tab객체 생성
        tab.setText("회원전용");   //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);

        //세번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab = actionBar.newTab(); //ActionBar에 붇는 Tab객체 생성
        tab.setText("업주전용");   //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);


        //Tab의 선택변화를 인지하는 Listener 객체 생성
        //(Button의 onClickListner 처럼 생각하시면 됩니다.)
        ActionBar.TabListener listener = new ActionBar.TabListener() {

            //Tab의 선택이 벗어날 때 호출
            //첫번째 파라미터 : 선택에서 벗어나는 Tab 객체
            //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // TODO Auto-generated method stub

            }

            //Tab이 선택될 때 호출
            //첫번째 파라미터 : 선택된 Tab 객체
            //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // TODO Auto-generated method stub

                //선택된 Tab객체의 위치값(왼족 처음부터 0,1,2....순으로 됨)
                int position = tab.getPosition();

                switch (position) {
                    case 0: //가장 왼쪽 Tab 선택(Analog)

                        //MainActivity가 보여 줄 View를
                        //res폴더>>layout폴더>>layout_tab_0.xml 로 설정
                        setContentView(R.layout.activity_sign);
                        break;

                    case 1: //두번째 Tab 선택(Digital)

                        //MainActivity가 보여 줄 View를
                        //res폴더>>layout폴더>>layout_tab_1.xml 로 설정
                        setContentView(R.layout.activity_sign2);
                        break;

                }


            }

            //Tab이 재 선택될 때 호출
            //첫번째 파라미터 : 재 선택된 Tab 객체
            //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // TODO Auto-generated method stub

            }
        };
    }
}