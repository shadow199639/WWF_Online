package com.example.wwfonline.ui.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wwfonline.Adapters.MyAdapter;
import com.example.wwfonline.Adapters.NewsAdapter;
import com.example.wwfonline.Models.News.NewsModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends Fragment {

    private List<NewsModel> news;
    private MyAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View v) {
        adapter = new MyAdapter();
        RecyclerView listViewNews = v.findViewById(R.id.listNews);
        listViewNews.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        listViewNews.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        APIClient.getInstance()
                .getAPI()
                .findAll()
                .enqueue(new Callback<List<NewsModel>>() {
                    @Override
                    public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "Load Successful", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), "Server is not returned any data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                        Toast.makeText(getContext(), "There is no internet connection", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void onItemsObtainedFromServer(List<NewsModel> items) {
        adapter.updateItems(items);
    }

}