package com.example.wwfonline.Models.Category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cntByCatModel {
    @SerializedName("catId")
    @Expose
    private Integer catId;
    @SerializedName("catName")
    @Expose
    private String catName;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
