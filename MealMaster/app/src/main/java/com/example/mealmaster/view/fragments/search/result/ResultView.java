package com.example.mealmaster.view.fragments.search.result;

import com.example.mealmaster.model.DTOs.MealDTO;

import java.util.List;

public interface ResultView {
        void showData(List<MealDTO> meals);
}
