package com.example.wwfonline.Models.Category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class byCategoryModel {
    @SerializedName("animalId")
    @Expose
    private Integer animalId;
    @SerializedName("animalName")
    @Expose
    private String animalName;
    @SerializedName("catName")
    @Expose
    private String catName;

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
