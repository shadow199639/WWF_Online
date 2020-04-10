package com.example.wwfonline.Models.Animal;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.wwfonline.BaseViewHolder;
import com.example.wwfonline.R;

public class AnimalDetailsModelViewHolder extends BaseViewHolder<AnimalDetailsModel> {
    private final TextView txtName;

    public AnimalDetailsModelViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
    }

    @Override
    protected void updateContentImp(AnimalDetailsModel item) {
        txtName.setText(item.getAnimalName());
    }
}
