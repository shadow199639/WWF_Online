package com.example.wwfonline.Models.Continent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConModel {
    @SerializedName("conId")
    @Expose
    private Integer conId;
    @SerializedName("conName")
    @Expose
    private String conName;
    @SerializedName("animalonconttinents")
    @Expose
    private List<Object> animalonconttinents = null;

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

    public List<Object> getAnimalonconttinents() {
        return animalonconttinents;
    }

    public void setAnimalonconttinents(List<Object> animalonconttinents) {
        this.animalonconttinents = animalonconttinents;
    }
}
