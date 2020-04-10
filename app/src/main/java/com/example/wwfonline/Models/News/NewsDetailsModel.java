package com.example.wwfonline.Models.News;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsDetailsModel {

    @SerializedName("dnewsId")
    @Expose
    private Integer dnewsId;
    @SerializedName("newsId")
    @Expose
    private Integer newsId;
    @SerializedName("dIng")
    @Expose
    private String dIng;
    @SerializedName("head")
    @Expose
    private String head;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("news")
    @Expose
    private Object news;

    public Integer getDnewsId() {
        return dnewsId;
    }

    public void setDnewsId(Integer dnewsId) {
        this.dnewsId = dnewsId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getDIng() {
        return dIng;
    }

    public void setDIng(String dIng) {
        this.dIng = dIng;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getNews() {
        return news;
    }

    public void setNews(Object news) {
        this.news = news;
    }
}