package com.hie2j.news_client;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder>{
    private List<Data> dataList;

    public NewsListAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news,viewGroup,false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        final Data data = dataList.get(i);
        newsViewHolder.tv_author.setText(data.getAuthor_name());
        newsViewHolder.tv_date.setText(data.getDate());
        newsViewHolder.tv_title.setText(data.getTitle());
        Glide.with(newsViewHolder.iv_news.getContext()).load(data.getThumbnail_pic_s()).into(newsViewHolder.iv_news);

        newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewsDetailActivity.class);
                intent.putExtra("TITLE",data.getTitle());
                intent.putExtra("URL",data.getUrl());
                intent.putExtra("NEWSID",data.getUniquekey());
                intent.putExtra("NEWSJSON",new Gson().toJson(data));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void changeData(List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
}
