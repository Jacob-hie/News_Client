package com.hie2j.news_client;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/*
*   评论表
**/
public class Comment extends BmobObject {
    private String userId;
    private String newsId;
    private String newsJson;
    private BmobDate time;
    private String content;

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

    public BmobDate getTime() {
        return time;
    }

    public void setTime(BmobDate time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
