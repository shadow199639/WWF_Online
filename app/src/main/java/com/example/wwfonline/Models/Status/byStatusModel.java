package com.example.wwfonline.Models.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class byStatusModel {
    @SerializedName("animalId")
    @Expose
    private Integer animalId;
    @SerializedName("animalName")
    @Expose
    private String animalName;
    @SerializedName("statusName")
    @Expose
    private String statusName;

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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
