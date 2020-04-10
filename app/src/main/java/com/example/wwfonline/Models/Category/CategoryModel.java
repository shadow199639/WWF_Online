package com.example.wwfonline.Models.Category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CategoryModel {

    @SerializedName("catId")
    @Expose
    private Integer catId;
    @SerializedName("catName")
    @Expose
    private String catName;
    @SerializedName("animal")
    @Expose
    private List<Object> animal = null;

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

    public List<Object> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Object> animal) {
        this.animal = animal;
    }
}
