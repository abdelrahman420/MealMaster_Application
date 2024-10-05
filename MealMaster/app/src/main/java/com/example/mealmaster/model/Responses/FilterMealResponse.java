package com.example.mealmaster.model.Responses;

import com.example.mealmaster.model.DTOs.FilterMealDTO;
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
