package com.example.wwfonline.Models.Continent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class byConModel {
    @SerializedName("animalId")
    @Expose
    private Integer animalId;
    @SerializedName("animalName")
    @Expose
    private String animalName;
    @SerializedName("conName")
    @Expose
    private String conName;

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

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }
}
