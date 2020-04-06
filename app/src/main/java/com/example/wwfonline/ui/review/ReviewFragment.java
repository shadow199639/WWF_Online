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
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAll:
                Intent intent1 = new Intent(getActivity(), AnimalListActivity.class);
                String type1 = "allAnimals";
                intent1.putExtra("type", type1);
                startActivity(intent1);
                break;
        }
    }
}
