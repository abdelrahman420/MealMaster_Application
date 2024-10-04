package com.example.mealmaster.view.fragments.search.filter_by_country;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface FilterByCountryView {
    void displayAllCountries(List<AreaListDTO> countries);
    void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
