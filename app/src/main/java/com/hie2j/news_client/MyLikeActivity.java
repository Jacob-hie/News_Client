package com.hie2j.news_client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MyLikeActivity extends AppCompatActivity {

    private RecyclerView rv_like;
    private List<Data> dataList = new ArrayList<>();
    private NewsListAdapter adapter;
    private LikeReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_like);
        setTitle("我的收藏");

        rv_like = findViewById(R.id.rv_like);
        rv_like.setLayoutManager(new LinearLayoutManager(MyLikeActivity.this));
        adapter = new NewsListAdapter(dataList);
        rv_like.setAdapter(adapter);

        initReceiver();
        getLikeNewsData();
    }

    private void initReceiver() {
        receiver = new LikeReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("LIKE_CHANGE");
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public void getLikeNewsData() {
        String userId = BmobUser.getCurrentUser(BmobUser.class).getObjectId();
        BmobQuery<Like> likeBmobQuery = new BmobQuery<>();
        likeBmobQuery.addWhereEqualTo("userid",userId);
        likeBmobQuery.addWhereEqualTo("isLike",true);
        likeBmobQuery.findObjects(new FindListener<Like>() {
            @Override
            public void done(List<Like> list, BmobException e) {
                if (e == null){
                    dataList.clear();
                    if (list != null && list.size() > 0){
                        for (Like like : list){
                            String newsJson = like.getNewsJson();
                            Data data = new Gson().fromJson(newsJson,Data.class);
                            dataList.add(data);
                        }
                        adapter.changeData(dataList);
                    }
                }
            }
        });
    }

    class LikeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            getLikeNewsData();
        }
    }
}
