package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Continent.byConModel;
import com.example.wwfonline.R;

import java.util.List;

public class ConListAdapter extends ArrayAdapter<byConModel> {
    private Context context;
    private List<byConModel> byConModelList;

    public ConListAdapter(Context context, List<byConModel> byConModelList){
        super(context, R.layout.animal_list_layout, byConModelList);
        this.context = context;
        this.byConModelList = byConModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        byConModel byConModel = byConModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(byConModel.getAnimalName());

        return convertView;
    }
}
