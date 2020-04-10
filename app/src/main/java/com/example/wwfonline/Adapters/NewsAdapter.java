package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.wwfonline.Models.News.NewsModel;
import com.example.wwfonline.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsModel> {

    private Context context;
    private List<NewsModel> news;

    public NewsAdapter(Context context, List<NewsModel> news){
        super(context, R.layout.news_layout, news);
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.news_layout, parent, false);

        NewsModel newsModel = news.get(position);

        ImageView imgMain = (ImageView)convertView.findViewById(R.id.imgMain);
        Picasso.get().load(newsModel.getImg()).into(imgMain);

        TextView txtHeader = (TextView) convertView.findViewById(R.id.txtHeader);
        txtHeader.setText(newsModel.getHead());

        TextView txtDate = (TextView) convertView.findViewById(R.id.txtDate);
        txtDate.setText(newsModel.getPublishedD());

        TextView txtTime = (TextView) convertView.findViewById(R.id.txtTime);
        txtTime.setText(newsModel.getPublishedT());
        return convertView;
    }
}
