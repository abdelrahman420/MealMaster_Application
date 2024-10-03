package com.example.mealmaster.view.fragments.search;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface SearchFragmentView {
    void displayAllCategories(List<CategoriesDTO> categories);
    void displayAllCountries(List<AreaListDTO> countries);
    void displayAllIngredients(List<IngredientListDTO> ingredients);
    public void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
