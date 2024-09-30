package com.example.mealmaster.view.fragments.favourite_meals;

import com.example.mealmaster.model.database.DTOs.MealDTO;

public interface OnFavClickListener {
    void OnFavMealRmv(MealDTO meal);
    void OnFavMealClick(MealDTO meal);
}
