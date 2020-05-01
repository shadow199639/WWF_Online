package com.example.wwfonline.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Category.byCategoryModel;
import com.example.wwfonline.R;

import java.util.List;

public class CatListAdapter extends ArrayAdapter<byCategoryModel> {
    private Context context;
    private List<byCategoryModel> bycategoryModelList;

    public CatListAdapter(Context context, List<byCategoryModel> bycategoryModelList){
        super(context, R.layout.animal_list_layout, bycategoryModelList);
        this.context = context;
        this.bycategoryModelList = bycategoryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        byCategoryModel bycategoryModel = bycategoryModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(bycategoryModel.getAnimalName());

        return convertView;
    }
}
