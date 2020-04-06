package com.example.wwfonline.Service;

import com.example.wwfonline.Models.AnimalDetailsModel;
import com.example.wwfonline.Models.NewsModel;
import com.example.wwfonline.Models.NewsDetailsModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WWF_Service {
    @GET("/api/AnimalDetails")
    Call<List<AnimalDetailsModel>> findAllAnimals();

    @GET("/api/News")
    Call<List<NewsModel>> findAll();

    @GET("/api/NewsDetails/{id}")
    Call<NewsDetailsModel> getNewsById(@Path("id")int id);
}