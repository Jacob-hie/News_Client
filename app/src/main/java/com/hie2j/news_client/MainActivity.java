package com.hie2j.news_client;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private NewsFragmentAdapter adapter;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;

    private TextView tv_like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragmentList();
        initViews();
    }

    private void initFragmentList() {
        NewsFragment fragment1 = new NewsFragment();
        fragment1.setType("top");
        NewsFragment fragment2 = new NewsFragment();
        fragment2.setType("shehui");
        NewsFragment fragment3 = new NewsFragment();
        fragment3.setType("yule");
        NewsFragment fragment4 = new NewsFragment();
        fragment4.setType("tiyu");
        NewsFragment fragment5 = new NewsFragment();
        fragment5.setType("caijing");
        NewsFragment fragment6 = new NewsFragment();
        fragment1.setType("keji");
        NewsFragment fragment7 = new NewsFragment();
        fragment2.setType("shishang");
        NewsFragment fragment8 = new NewsFragment();
        fragment3.setType("junshi");
        NewsFragment fragment9 = new NewsFragment();
        fragment4.setType("guoji");
        NewsFragment fragment10 = new NewsFragment();
        fragment5.setType("guonei");
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        fragmentList.add(fragment5);
//        fragmentList.add(fragment6);
//        fragmentList.add(fragment7);
//        fragmentList.add(fragment8);
//        fragmentList.add(fragment9);
//        fragmentList.add(fragment10);
    }

    private void initViews() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
//        tv6 = findViewById(R.id.tv6);
//        tv7 = findViewById(R.id.tv7);
//        tv8 = findViewById(R.id.tv8);
//        tv9 = findViewById(R.id.tv9);
//        tv10 = findViewById(R.id.tv10);

        tv1.setBackgroundColor(Color.GREEN);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(4);
            }
        });
//        tv6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(5);
//            }
//        });
//        tv7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(6);
//            }
//        });
//        tv8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(7);
//            }
//        });
//        tv9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(8);
//            }
//        });
//        tv10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(9);
//            }
//        });
        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(6);
        adapter = new NewsFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        indexSetBackgroundColor(position);
                        break;
                    case 1:
                        indexSetBackgroundColor(position);
                        break;
                    case 2:
                        indexSetBackgroundColor(position);
                        break;
                    case 3:
                        indexSetBackgroundColor(position);
                        break;
                    case 4:
                        indexSetBackgroundColor(position);
                        break;
                    case 5:
                        indexSetBackgroundColor(position);
                        break;
                    case 6:
                        indexSetBackgroundColor(position);
                        break;
                    case 7:
                        indexSetBackgroundColor(position);
                        break;
                    case 8:
                        indexSetBackgroundColor(position);
                        break;
                    case 9:
                        indexSetBackgroundColor(position);
                        break;
                }
            }
        });

        tv_like = findViewById(R.id.tv_like);
        tv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断当前用户是否已登陆 没登陆先去登陆
                if (BmobUser.getCurrentUser(BmobUser.class) == null){
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    return;
                }

                Intent intent = new Intent(MainActivity.this,MyLikeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void indexSetBackgroundColor(int i) {
        switch (i){
            case 0:
                tv1.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
//                tv6.setBackgroundColor(Color.TRANSPARENT);
//                tv7.setBackgroundColor(Color.TRANSPARENT);
//                tv8.setBackgroundColor(Color.TRANSPARENT);
//                tv9.setBackgroundColor(Color.TRANSPARENT);
//                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 1:
                tv2.setBackgroundColor(Color.GREEN);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
//                tv6.setBackgroundColor(Color.TRANSPARENT);
//                tv7.setBackgroundColor(Color.TRANSPARENT);
//                tv8.setBackgroundColor(Color.TRANSPARENT);
//                tv9.setBackgroundColor(Color.TRANSPARENT);
//                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 2:
                tv3.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
//                tv6.setBackgroundColor(Color.TRANSPARENT);
//                tv7.setBackgroundColor(Color.TRANSPARENT);
//                tv8.setBackgroundColor(Color.TRANSPARENT);
//                tv9.setBackgroundColor(Color.TRANSPARENT);
//                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 3:
                tv4.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
//                tv6.setBackgroundColor(Color.TRANSPARENT);
//                tv7.setBackgroundColor(Color.TRANSPARENT);
//                tv8.setBackgroundColor(Color.TRANSPARENT);
//                tv9.setBackgroundColor(Color.TRANSPARENT);
//                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 4:
                tv5.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
//                tv6.setBackgroundColor(Color.TRANSPARENT);
//                tv7.setBackgroundColor(Color.TRANSPARENT);
//                tv8.setBackgroundColor(Color.TRANSPARENT);
//                tv9.setBackgroundColor(Color.TRANSPARENT);
//                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            /*case 5:
                tv6.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv7.setBackgroundColor(Color.TRANSPARENT);
                tv8.setBackgroundColor(Color.TRANSPARENT);
                tv9.setBackgroundColor(Color.TRANSPARENT);
                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 6:
                tv7.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
                tv6.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv8.setBackgroundColor(Color.TRANSPARENT);
                tv9.setBackgroundColor(Color.TRANSPARENT);
                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 7:
                tv8.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
                tv6.setBackgroundColor(Color.TRANSPARENT);
                tv7.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv9.setBackgroundColor(Color.TRANSPARENT);
                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 8:
                tv9.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
                tv6.setBackgroundColor(Color.TRANSPARENT);
                tv7.setBackgroundColor(Color.TRANSPARENT);
                tv8.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                tv10.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 9:
                tv10.setBackgroundColor(Color.GREEN);
                tv2.setBackgroundColor(Color.TRANSPARENT);
                tv3.setBackgroundColor(Color.TRANSPARENT);
                tv4.setBackgroundColor(Color.TRANSPARENT);
                tv5.setBackgroundColor(Color.TRANSPARENT);
                tv6.setBackgroundColor(Color.TRANSPARENT);
                tv7.setBackgroundColor(Color.TRANSPARENT);
                tv8.setBackgroundColor(Color.TRANSPARENT);
                tv9.setBackgroundColor(Color.TRANSPARENT);
                tv1.setBackgroundColor(Color.TRANSPARENT);
                break;*/
        }

    }


}
