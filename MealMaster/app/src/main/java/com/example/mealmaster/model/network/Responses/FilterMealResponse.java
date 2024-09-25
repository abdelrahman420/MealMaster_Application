package com.example.mealmaster.model.network.Responses;

import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterMealResponse {

    @SerializedName("meals")
    List<FilterMealDTO> meals;


    public void setMeals(List<FilterMealDTO> meals) {
        this.meals = meals;
    }
    public List<FilterMealDTO> getMeals() {
        return meals;
    }

}
