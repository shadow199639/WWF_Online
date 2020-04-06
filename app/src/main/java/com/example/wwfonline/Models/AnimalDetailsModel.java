package com.example.wwfonline.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimalDetailsModel {
    @SerializedName("animalId")
    @Expose
    private Integer animalId;
    @SerializedName("catName")
    @Expose
    private String catName;
    @SerializedName("statusName")
    @Expose
    private String statusName;
    @SerializedName("animalName")
    @Expose
    private String animalName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("habitat")
    @Expose
    private String habitat;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("img")
    @Expose
    private String img;

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
