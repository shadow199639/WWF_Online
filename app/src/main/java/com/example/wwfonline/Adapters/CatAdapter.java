package com.example.wwfonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wwfonline.Models.Category.CategoryModel;
import com.example.wwfonline.R;

import java.util.List;

public class CatAdapter extends ArrayAdapter<CategoryModel> {
    private Context context;
    private List<CategoryModel> categoryModelList;

    public CatAdapter(Context context, List<CategoryModel> categoryModelList){
        super(context, R.layout.animal_list_layout, categoryModelList);
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        CategoryModel categoryModel = categoryModelList.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(categoryModel.getCatName());

        return convertView;
    }
}
