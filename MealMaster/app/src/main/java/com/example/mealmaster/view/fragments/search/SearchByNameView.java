package com.example.mealmaster.view.fragments.search;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface SearchByNameView {
    void displaySearchByName(List<MealDTO> meals);
    void showError(String message);

}
