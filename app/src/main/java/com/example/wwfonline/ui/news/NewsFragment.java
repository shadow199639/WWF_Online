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
    private ListView listViewNews;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        listViewNews = v.findViewById(R.id.listNews);
        APIClient.getInstance()
                .getAPI()
                .findAll()
                .enqueue(new Callback<List<NewsModel>>() {
                    @Override
                    public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "Load Successful", Toast.LENGTH_SHORT).show();
                            news = (List<NewsModel>) response.body();
                            listViewNews.setAdapter(new NewsAdapter(getContext(), news));
                            listViewNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    NewsModel newsModel = news.get(position);
                                    Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                                    intent.putExtra("id", newsModel.getNewsId());
                                    startActivity(intent);
                                }
                            });

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

}