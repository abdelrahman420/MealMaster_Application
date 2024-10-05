package com.example.mealmaster.view.fragments.home;

import com.example.mealmaster.model.DTOs.CategoriesDTO;
import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface HomeFragmentView {
    void displayCategories(List<CategoriesDTO> categories);
    void showError(String message);
    void displayTodaysMeal(List<MealDTO> meal);

}
