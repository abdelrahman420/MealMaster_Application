package com.example.mealmaster.view.fragments.search.search_by_name;

import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface SearchByNameView {
    void displaySearchByName(List<MealDTO> meals);
    void showError(String message);

}
