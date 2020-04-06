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

import com.example.wwfonline.Models.AnimalDetailsModel;
import com.example.wwfonline.Models.NewsModel;
import com.example.wwfonline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimalDetailsAdapter extends ArrayAdapter<AnimalDetailsModel> {

    private Context context;
    private List<AnimalDetailsModel> animalDetailsModels;

    public AnimalDetailsAdapter(Context context, List<AnimalDetailsModel> animalDetailsModels){
        super(context, R.layout.animal_list_layout, animalDetailsModels);
        this.context = context;
        this.animalDetailsModels = animalDetailsModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.animal_list_layout, parent, false);

        AnimalDetailsModel animalDetailsModel = animalDetailsModels.get(position);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(animalDetailsModel.getAnimalName());

        return convertView;
    }
}
