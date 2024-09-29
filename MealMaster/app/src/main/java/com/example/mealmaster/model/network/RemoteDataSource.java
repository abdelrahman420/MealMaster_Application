package com.example.mealmaster.model.network;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface RemoteDataSource {
    void searchMealsByName(String mealName, NetworkCall networkCallBack);
    void searchMealsByFirstLetter(char firstLetter, NetworkCall networkCallBack);
    void lookupMealById(String mealId, NetworkCall networkCallBack);
    void lookupRandomMeal(NetworkCall networkCallBack);
    void allCategories(NetworkCall networkCallback);
    void listAllAreas(NetworkCall networkCallback);
    void listAllIngredients(NetworkCall networkCallback);
    void filterMealsByCategory(String category, NetworkCall networkCallback);
    void filterMealsByArea(String area, NetworkCall networkCallback);
    void filterMealsByIngredient(String ingredient, NetworkCall networkCallback);
}
