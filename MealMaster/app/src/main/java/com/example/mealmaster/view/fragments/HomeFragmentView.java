package com.example.mealmaster.view.fragments;

import com.example.mealmaster.model.database.DTOs.CategoriesDTO;

import java.util.List;

public interface HomeFragmentView {
    void displayCategories(List<CategoriesDTO> categories);
    void showError(String message);
}
