package com.example.wwfonline.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wwfonline.BaseViewHolder;
import com.example.wwfonline.Models.Animal.AnimalDetailsModel;
import com.example.wwfonline.Models.Animal.AnimalDetailsModelViewHolder;
import com.example.wwfonline.Models.News.NewsModel;
import com.example.wwfonline.Models.News.NewsModelViewHolder;
import com.example.wwfonline.OnNewsListener;
import com.example.wwfonline.R;

import java.util.ArrayList;
import java.util.List;




public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final OnNewsListener listener;
    private List items = new ArrayList();


    public MyAdapter(OnNewsListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(viewType, parent, false);

        if (viewType == R.layout.news_layout)
            return new NewsModelViewHolder(layout);
        else if (viewType == R.layout.animal_list_layout) {
            return new AnimalDetailsModelViewHolder(layout);
        } else {
            return null;
        }
    }

    @Override
    public final void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.updateContent(items.get(position)); }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItems(List newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof NewsModel)
            return R.layout.news_layout;
        else if (items.get(position) instanceof AnimalDetailsModel)
            return R.layout.animal_list_layout;
        else
            return 0; //чтоб на всякий случай

    }
}
