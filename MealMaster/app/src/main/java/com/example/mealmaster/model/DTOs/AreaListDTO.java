package com.example.mealmaster.model.DTOs;


import com.google.gson.annotations.SerializedName;


public class AreaListDTO {

    @SerializedName("strArea")
    String strArea;

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }
    public String getStrArea() {
        return strArea;
    }

}