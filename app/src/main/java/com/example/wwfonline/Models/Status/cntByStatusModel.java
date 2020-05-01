package com.example.wwfonline.Models.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cntByStatusModel {
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("statusName")
    @Expose
    private String statusName;
    @SerializedName("count")
    @Expose
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
