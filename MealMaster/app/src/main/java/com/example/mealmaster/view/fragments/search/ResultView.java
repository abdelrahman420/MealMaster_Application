package com.example.mealmaster.view.fragments.search;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface ResultView {
        void showData(List<MealDTO> meals);
}
