package com.example.mealmaster.view.fragments.weekly_plan;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealPlanDTO;

import java.util.List;

public interface DayMealsView {
    void showDayMeals(LiveData<List<MealPlanDTO>> meals);
}
