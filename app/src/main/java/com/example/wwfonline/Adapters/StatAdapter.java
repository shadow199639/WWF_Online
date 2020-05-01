package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Status.StatusModel;
import com.example.wwfonline.R;

import java.util.List;

public class StatAdapter extends ArrayAdapter<StatusModel> {
    private Context context;
    private List<StatusModel> statusModelList;

    public StatAdapter(Context context, List<StatusModel> statusModelList){
        super(context, R.layout.animal_list_layout, statusModelList);
        this.context = context;
        this.statusModelList = statusModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        StatusModel statusModel = statusModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(statusModel.getStatusName());

        return convertView;
    }
}
