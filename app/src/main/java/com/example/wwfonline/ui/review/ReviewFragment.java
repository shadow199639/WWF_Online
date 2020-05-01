package com.example.wwfonline.ui.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.wwfonline.R;
import com.example.wwfonline.ui.statistics.StatisticsFragment;

public class ReviewFragment extends Fragment implements View.OnClickListener{


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review, container, false);
        Button btnAll = (Button) view.findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);

        Button btnStatus = (Button) view.findViewById(R.id.btnStatus);
        btnStatus.setOnClickListener(this);

        Button btnContinent = (Button) view.findViewById(R.id.btnContinent);
        btnContinent.setOnClickListener(this);

        Button btnCat = (Button) view.findViewById(R.id.btnCat);
        btnCat.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAll:
                Intent intent1 = new Intent(getActivity(), AnimalListActivity.class);
                String animalList = "allAnimals";
                intent1.putExtra("animalList", animalList);
                startActivity(intent1);
                break;

            case R.id.btnCat:
                Intent intent2 = new Intent(getActivity(), AnimalTypeActivity.class);
                String type1 = "byCat";
                intent2.putExtra("type", type1);
                startActivity(intent2);
                break;

            case R.id.btnContinent:
                Intent intent3 = new Intent(getActivity(), AnimalTypeActivity.class);
                String type2 = "byCon";
                intent3.putExtra("type", type2);
                startActivity(intent3);
                break;

            case R.id.btnStatus:
                Intent intent4 = new Intent(getActivity(), AnimalTypeActivity.class);
                String type3 = "byStat";
                intent4.putExtra("type", type3);
                startActivity(intent4);
                break;
        }
    }
}
