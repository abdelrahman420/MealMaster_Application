package com.example.mealmaster.view.fragments.search;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;

import java.util.List;

public interface SearchFragmentView {
    void displayAllCategories(List<CategoriesDTO> categories);
    void displayAllCountries(List<AreaListDTO> countries);
    void displayAllIngredients(List<IngredientListDTO> ingredients);
    void showError(String message);
}
