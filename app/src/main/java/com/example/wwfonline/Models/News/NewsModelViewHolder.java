package com.example.wwfonline.Models.News;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.wwfonline.BaseViewHolder;
import com.example.wwfonline.R;
import com.squareup.picasso.Picasso;

public class NewsModelViewHolder extends BaseViewHolder<NewsModel> {

    private final TextView txtHeader;
    private final TextView txtDate;
    private final TextView txtTime;
    private final ImageView imgMain;

    public NewsModelViewHolder(@NonNull View itemView) {
        super(itemView);
        txtHeader = itemView.findViewById(R.id.txtHeader);
        txtDate = itemView.findViewById(R.id.txtDate);
        txtTime = itemView.findViewById(R.id.txtTime);
        imgMain = itemView.findViewById(R.id.imgMain);
    }

    @Override
    protected void updateContentImp(NewsModel item) {
        txtHeader.setText(item.getHead());
        txtDate.setText(item.getPublishedD());
        txtTime.setText(item.getPublishedT());
        Picasso.get().load(item.getImg()).into(imgMain);
    }
}
