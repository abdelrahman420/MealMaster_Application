package com.example.mealmaster.view.fragments.search;

import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface FilterByCategoryView {
    void displayAllCategories(List<CategoriesDTO> categories);
    void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
