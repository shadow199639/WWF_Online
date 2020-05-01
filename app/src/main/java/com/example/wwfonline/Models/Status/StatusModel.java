package com.example.wwfonline.Models.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusModel {
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("statusName")
    @Expose
    private String statusName;
    @SerializedName("animal")
    @Expose
    private List<Object> animal = null;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Object> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Object> animal) {
        this.animal = animal;
    }
}
