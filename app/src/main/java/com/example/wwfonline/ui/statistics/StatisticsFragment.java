package com.example.wwfonline.ui.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wwfonline.Adapters.AnimalDetailsAdapter;
import com.example.wwfonline.Adapters.NewsAdapter;
import com.example.wwfonline.Models.AnimalDetailsModel;
import com.example.wwfonline.Models.NewsModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import com.example.wwfonline.ui.news.NewsDetailsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsFragment extends Fragment {

    private ListView listViewAnimalDetails;
    private List<AnimalDetailsModel> animalDetailsModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {

    }
}
