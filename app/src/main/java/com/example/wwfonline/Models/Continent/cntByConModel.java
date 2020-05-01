package com.example.wwfonline.Models.Continent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cntByConModel {
    @SerializedName("conId")
    @Expose
    private Integer conId;
    @SerializedName("conName")
    @Expose
    private String conName;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
