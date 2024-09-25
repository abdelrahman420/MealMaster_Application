package com.example.mealmaster.model.network.Responses;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AreaListResponse {

    @SerializedName("meals")
    List<AreaListDTO> areaListDTOMeals;


    public void setMeals(List<AreaListDTO> areaListDTOMeals) {
        this.areaListDTOMeals = areaListDTOMeals;
    }
    public List<AreaListDTO> getMeals() {
        return areaListDTOMeals;
    }

}