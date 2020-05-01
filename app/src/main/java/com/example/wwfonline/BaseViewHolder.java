package com.example.wwfonline;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wwfonline.Models.News.NewsModel;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public final void updateContent(Object item) {
        updateContentImp((T)item);
    }
    protected abstract void updateContentImp(T item);

}