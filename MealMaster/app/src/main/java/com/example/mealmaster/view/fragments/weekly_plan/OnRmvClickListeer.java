package com.example.mealmaster.view.fragments.weekly_plan;

import com.example.mealmaster.model.database.DTOs.MealPlanDTO;

public interface OnRmvClickListeer {
    void OnDayMealRmv(MealPlanDTO meal);
}
