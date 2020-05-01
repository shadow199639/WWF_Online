package com.example.wwfonline.ui.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wwfonline.R;

public class StatisticsFragment extends Fragment implements View.OnClickListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        Button allCon = (Button) view.findViewById(R.id.allCon);
        allCon.setOnClickListener(this);

        Button allCat = (Button) view.findViewById(R.id.allCat);
        allCat.setOnClickListener(this);

        Button allStat = (Button) view.findViewById(R.id.allStatus);
        allStat.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allCon:
                Intent intent1 = new Intent(getActivity(), StatActivity.class);
                String type1 = "byCon";
                intent1.putExtra("type", type1);
                startActivity(intent1);
                break;
            case R.id.allCat:
                Intent intent2 = new Intent(getActivity(), StatActivity.class);
                String type2 = "byCat";
                intent2.putExtra("type", type2);
                startActivity(intent2);
                break;
            case R.id.allStatus:
                Intent intent3 = new Intent(getActivity(), StatActivity.class);
                String type3 = "byStat";
                intent3.putExtra("type", type3);
                startActivity(intent3);
                break;

        }
    }
}
