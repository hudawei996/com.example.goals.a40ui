package com.example.goals.a40ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout content;
    private TextView mTextMessage;
    private BottomNavigationView navigation;

    private int currentIndex = 0;//控制当前需要显示第几个Fragment
    private ArrayList<Fragment> fragmentArrayList;//用List来存储Fragment,List的初始化没有写
    private Fragment mCurrentFrgment;//显示当前Fragment

    private FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (FrameLayout) findViewById(R.id.content);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setOnClickListener(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragment();

    }

    private void initFragment() {
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList = new ArrayList<Fragment>(3);
        fragmentArrayList.add(new MineFragment());
        fragmentArrayList.add(new ContentFragment());
        //fragmentArrayList.add(new Tab3Fragment());

        navigation.setSelectedItemId(R.id.navigation_home);
        changeTab(0);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
//                    MineFragment mineFragment = new MineFragment();
//                    fragmentArrayList.add(mineFragment);
//                    changeTab(0);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    ContentFragment contentFragment = new ContentFragment();
//                    fragmentArrayList.add(contentFragment);
//                    changeTab(1);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    gotoMine();
                    return true;
            }
            return false;
        }

    };

    private void changeTab(int index) {
        currentIndex = index;

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        if (null != mCurrentFrgment) {
            ft.hide(mCurrentFrgment);
        }
        //先根据Tag从FragmentTransaction事物获取之前添加的Fragment
        Fragment fragment = getFragmentManager().findFragmentByTag(fragmentArrayList.get(currentIndex).getClass().getName());

        if (null == fragment) {
            //如fragment为空，则之前未添加此Fragment。便从集合中取出
            fragment = fragmentArrayList.get(index);
        }
        mCurrentFrgment = fragment;

        //判断此Fragment是否已经添加到FragmentTransaction事物中
        if (!fragment.isAdded()) {
            ft.add(R.id.content, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }


    private void gotoSunshine() {
        Intent intent = new Intent(this, SunshineActivity.class);
        startActivity(intent);
    }

    private void gotoMine() {
        Intent intent = new Intent(this, MineActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message:
                gotoSunshine();
                break;
        }
    }
}
