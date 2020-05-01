package com.example.wwfonline.Service;

import com.example.wwfonline.Models.Animal.AnimalDetailsModel;
import com.example.wwfonline.Models.Category.CategoryModel;
import com.example.wwfonline.Models.Category.byCategoryModel;
import com.example.wwfonline.Models.Category.cntByCatModel;
import com.example.wwfonline.Models.Continent.ConModel;
import com.example.wwfonline.Models.Continent.byConModel;
import com.example.wwfonline.Models.Continent.cntByConModel;
import com.example.wwfonline.Models.News.NewsModel;
import com.example.wwfonline.Models.News.NewsDetailsModel;
import com.example.wwfonline.Models.Status.StatusModel;
import com.example.wwfonline.Models.Status.byStatusModel;
import com.example.wwfonline.Models.Status.cntByStatusModel;

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

    @GET("/api/Category")
    Call<List<CategoryModel>> findAllCat();

    @GET("/api/Status")
    Call<List<StatusModel>> findAllStat();

    @GET("/api/Continent")
    Call<List<ConModel>> findAllCon();


    @GET("/api/byCategory/{cname}")
    Call<List<byCategoryModel>> findCatByName(@Path("cname")String cname);

    @GET("/api/byStatus/{sname}")
    Call<List<byStatusModel>> findStatusByName(@Path("sname")String sname);

    @GET("/api/byCon/{cname}")
    Call<List<byConModel>> findConByName(@Path("cname")String cname);


    @GET("/api/cntByCat")
    Call<List<cntByCatModel>> findCntByCat();

    @GET("/api/cntByCon")
    Call<List<cntByConModel>> findCntByCon();

    @GET("/api/cntByStatus")
    Call<List<cntByStatusModel>> findCntByStatus();

}