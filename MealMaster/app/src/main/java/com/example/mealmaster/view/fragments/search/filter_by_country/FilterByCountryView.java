package com.example.mealmaster.view.fragments.search.filter_by_country;

import com.example.mealmaster.model.DTOs.AreaListDTO;
import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface FilterByCountryView {
    void displayAllCountries(List<AreaListDTO> countries);
    void displaySearchResults(List<MealDTO> meals);
    void showError(String message);
}
