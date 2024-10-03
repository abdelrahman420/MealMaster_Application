package com.example.mealmaster.model.database;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;

import java.util.List;

public interface LocalDataSource {
    LiveData<List<MealDTO>> getStoredData();

    void delete(MealDTO meal);

    void insert(MealDTO meal);
    void insertInMealPlan(MealPlanDTO meal);
    void deleteFromMealPlan(MealPlanDTO meal);
    LiveData<List<MealPlanDTO>> getMealsByDate(String date);
}
