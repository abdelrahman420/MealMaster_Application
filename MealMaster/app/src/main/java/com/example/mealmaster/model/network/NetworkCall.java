package com.example.mealmaster.model.network;

import com.example.mealmaster.model.DTOs.AreaListDTO;
import com.example.mealmaster.model.DTOs.CategoriesDTO;
import com.example.mealmaster.model.DTOs.FilterMealDTO;
import com.example.mealmaster.model.DTOs.IngredientListDTO;
import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface NetworkCall {
    void OnGetMealSuccess(List<MealDTO> meals);
    void OnGetMealByIDSuccess(MealDTO meal);
    void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList);
    void onSuccessListArea(List<AreaListDTO> AreaList);
    void onSuccessListIngredients(List<IngredientListDTO> IngredientsList);
    void onSuccessFilteredMeals(List<FilterMealDTO> FilterMealsList);
    void onFailureResult(String errMsg);
}
