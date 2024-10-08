package com.example.mealmaster.view.fragments.search.filter_by_category;

import com.example.mealmaster.model.DTOs.CategoriesDTO;
import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface FilterByCategoryView {
    void displayAllCategories(List<CategoriesDTO> categories);
    void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
