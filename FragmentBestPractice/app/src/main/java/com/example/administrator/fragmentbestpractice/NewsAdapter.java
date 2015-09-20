package com.example.administrator.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/9/18.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceId;
    public NewsAdapter(Context context,int textViewReourceId,List<News> objects){
        super(context,textViewReourceId,objects);
        resourceId = textViewReourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        News news = getItem(position);
        View view;
        if (convertView ==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else {
            view = convertView;
        }
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;
    }
}
