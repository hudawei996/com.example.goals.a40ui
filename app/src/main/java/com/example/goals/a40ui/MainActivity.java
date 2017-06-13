package com.example.goals.a40ui;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.goals.a40ui.myViewPager.HuPagerAdapter;
import com.example.goals.a40ui.myViewPager.ScrollOffsetTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;

    private ViewPager viewpagerTop;
    private ViewPager mViewPager;
    private  Book mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book();
        mBook.setAlt("别名");
        mBook.setAuthor_intro("作者信息");
        mBook.setCatalog("目录");
        mBook.setTitle("服务效率");
        mBook.setSummary("内容简介");
        mBook.setImage("");

        setContentView(R.layout.activity_main);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.mipmap.back_topbar_noamal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.back_topbar_noamal);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

//        mBook = (Book) getIntent().getSerializableExtra("book");
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mBook.getTitle());
        //通过CollapsingToolbarLayout修改字体颜色
        collapsingToolbar.setExpandedTitleColor(Color.BLACK);//设置还没收缩时状态下字体颜色
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色


        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        //Glide.with(ivImage.getContext())
                //.load(mBook.getImages().getLarge())
                //.fitCenter()
                //.into(ivImage);



        viewpagerTop = (ViewPager) findViewById(R.id.viewpagerTop);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPagerOver(viewpagerTop);
        setupViewPager(mViewPager);
        //设置两个viewpager联动
        setTwoViewPagerMoveSameTime(viewpagerTop,mViewPager);


        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介"));
        tabLayout.addTab(tabLayout.newTab().setText("目录"));
        tabLayout.setupWithViewPager(mViewPager);

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d("展开状态", state.name());
                if( state == State.EXPANDED ) {
                    //展开状态
                    tabLayout.setVisibility(View.GONE);
                    toolbar.setNavigationIcon(R.mipmap.back_topbar_noamal);
//                    getSupportActionBar().setHomeAsUpIndicator(R.mipmap.back_topbar_white);

                }else if(state == State.COLLAPSED){
                    //折叠状态
                    tabLayout.setVisibility(View.VISIBLE);
                    toolbar.setNavigationIcon(R.mipmap.back_topbar_white);
                }else {
                    //中间状态
                    //tabLayout.setVisibility(View.GONE);
                    toolbar.setNavigationIcon(R.mipmap.back_topbar_noamal);
                }
            }
        });
    }

    private void setTwoViewPagerMoveSameTime(final ViewPager viewpager_top, final ViewPager mViewPager) {
        viewpager_top.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //viewpager_top.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {
                viewpagerTop.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DetailFragment.newInstance(mBook.getSummary()), "内容简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getAuthor_intro()), "作者简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getCatalog()), "目录");
        mViewPager.setAdapter(adapter);
    }

    private void setupViewPagerOver(ViewPager mViewPager) {
        /*MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DetailFragment.newInstance(mBook.getSummary()), "内容简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getAuthor_intro()), "作者简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getCatalog()), "目录");
        mViewPager.setAdapter(adapter);*/


        /*viewPager.setAdapter(new HuPagerAdapter(views));
        viewPager.setPageTransformer(true, new ScrollOffsetTransformer());
        //左右各多加载2页（默认1页）
        viewPager.setOffscreenPageLimit(2);*/


        HuPagerAdapter adapter1 = new HuPagerAdapter(getSupportFragmentManager());
        adapter1.addFragment(WeekFragment.newInstance(mBook.getSummary()), "内容简介");
        adapter1.addFragment(WeekFragment.newInstance(mBook.getAuthor_intro()), "作者简介");
        adapter1.addFragment(WeekFragment.newInstance(mBook.getCatalog()), "目录");
        mViewPager.setAdapter(adapter1);
        mViewPager.setPageTransformer(true, new ScrollOffsetTransformer());
        //左右各多加载2页（默认1页）
        mViewPager.setOffscreenPageLimit(2);


    }


    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }



}
