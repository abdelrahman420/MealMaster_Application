package com.example.mealmaster.model.network;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface NetworkCall {
    void OnSearchMealSuccess(List<MealDTO> meals);
    void OnLookupRandomMealSuccess(List<MealDTO> meal);
    void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList);

    void onSuccessListArea(List<AreaListDTO> AreaList);
    void onSuccessListIngredients(List<IngredientListDTO> IngredientsList);
    void onSuccessFilteredMeals(List<FilterMealDTO> FilterMealsList);
    void onFailureResult(String errMsg);


}
