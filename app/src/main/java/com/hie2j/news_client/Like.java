package com.hie2j.news_client;

import cn.bmob.v3.BmobObject;

public class Like extends BmobObject{
    private String userId;
    private String newsId;
    private String newsJson;
    private boolean isLike;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsJson() {
        return newsJson;
    }

    public void setNewsJson(String newsJson) {
        this.newsJson = newsJson;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
