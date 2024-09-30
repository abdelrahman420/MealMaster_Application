package com.example.mealmaster.view.fragments.meal_details;

import com.example.mealmaster.model.database.DTOs.MealDTO;

public interface MealDetailsView {
    void showMealDetails(MealDTO meal);
    void OnAddToFav(MealDTO meal);
}
