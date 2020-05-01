package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Continent.ConModel;
import com.example.wwfonline.R;

import java.util.List;

public class ConAdapter extends ArrayAdapter<ConModel> {

    private Context context;
    private List<ConModel> conModelList;

    public ConAdapter(Context context, List<ConModel> conModelList){
        super(context, R.layout.animal_list_layout, conModelList);
        this.context = context;
        this.conModelList = conModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        ConModel conModel = conModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(conModel.getConName());

        return convertView;
    }
}
