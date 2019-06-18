package com.hie2j.news_client;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class NewsApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,"c4132474af8d773890eba6333f99ad1d");
    }
}
