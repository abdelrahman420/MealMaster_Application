package com.example.mealmaster.model.network.Responses;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public class MealResponse {
    List<MealDTO> meals;

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public MealResponse(List<MealDTO> meals) {
        this.meals = meals;
    }
}
