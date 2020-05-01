package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Status.byStatusModel;
import com.example.wwfonline.R;

import java.util.List;

public class StatusListAdapter extends ArrayAdapter<byStatusModel> {
    private Context context;
    private List<byStatusModel> byStatusModelList;

    public StatusListAdapter(Context context, List<byStatusModel> byStatusModelList){
        super(context, R.layout.animal_list_layout, byStatusModelList);
        this.context = context;
        this.byStatusModelList = byStatusModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        byStatusModel byStatusModel = byStatusModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(byStatusModel.getAnimalName());

        return convertView;
    }
}
