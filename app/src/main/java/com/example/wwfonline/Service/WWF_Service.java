package com.example.wwfonline.Service;

import com.example.wwfonline.Models.Animal.AnimalDetailsModel;
import com.example.wwfonline.Models.News.NewsModel;
import com.example.wwfonline.Models.News.NewsDetailsModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WWF_Service {
    @GET("/api/News")
    Call<List<NewsModel>> findAll();

    @GET("/api/NewsDetails/{id}")
    Call<NewsDetailsModel> getNewsById(@Path("id")int id);

    @GET("/api/AnimalDetails")
    Call<List<AnimalDetailsModel>> findAllAnimals();

    @GET("/api/AnimalDetails/{id}")
    Call<AnimalDetailsModel> getAnimalById(@Path("id")int id);

}