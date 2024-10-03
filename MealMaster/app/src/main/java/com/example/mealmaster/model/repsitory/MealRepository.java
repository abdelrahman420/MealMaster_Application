package com.example.mealmaster.model.repsitory;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;
import com.example.mealmaster.model.network.NetworkCall;

import java.util.List;

public interface MealRepository {
    LiveData<List<MealDTO>> _getStoredMeals();


    void _insertMeal(MealDTO meal);

    void _deleteMeal(MealDTO meal);

    void _searchMealsByName(String mealName, NetworkCall networkCallBack);
    void _searchMealsByFirstLetter(char firstLetter, NetworkCall networkCallBack);
    void _lookupMealById(String mealId, NetworkCall networkCallBack);
    void _lookupRandomMeal(NetworkCall networkCallBack);
    void _allCategories(NetworkCall networkCallback);
    void _listAllAreas(NetworkCall networkCallback);
    void _listAllIngredients(NetworkCall networkCallback);
    void _filterMealsByCategory(String category, NetworkCall networkCallback);
    void _filterMealsByArea(String area, NetworkCall networkCallback);
    void _filterMealsByIngredient(String ingredient, NetworkCall networkCallback);
    void _insertInMealPlan(MealPlanDTO meal);
    void _deleteFromMealPlan(MealPlanDTO meal);
    LiveData<List<MealPlanDTO>> _getMealsByDate(String date);
}
