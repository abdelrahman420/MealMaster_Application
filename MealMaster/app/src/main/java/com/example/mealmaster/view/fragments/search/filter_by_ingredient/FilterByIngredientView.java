package com.example.mealmaster.view.fragments.search.filter_by_ingredient;

import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface FilterByIngredientView {
    void displayAllIngredients(List<IngredientListDTO> ingredients);
    void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
