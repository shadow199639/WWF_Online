package com.example.wwfonline.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel {

    @SerializedName("newsId")
    @Expose
    private Integer newsId;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("head")
    @Expose
    private String head;
    @SerializedName("publishedD")
    @Expose
    private String publishedD;
    @SerializedName("publishedT")
    @Expose
    private String publishedT;
    @SerializedName("newsDetails")
    @Expose
    private List<Object> newsDetails = null;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPublishedD() {
        return publishedD;
    }

    public void setPublishedD(String publishedD) {
        this.publishedD = publishedD;
    }

    public String getPublishedT() {
        return publishedT;
    }

    public void setPublishedT(String publishedT) {
        this.publishedT = publishedT;
    }

    public List<Object> getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(List<Object> newsDetails) {
        this.newsDetails = newsDetails;
    }
}