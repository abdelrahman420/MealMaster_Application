package com.example.mealmaster.view.fragments.Home;

import androidx.fragment.app.Fragment;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.view.fragments.MealDetails.MealDetailsFragment;

public interface OnMealCLickListener {
    void onMealClick(MealDTO meal);
}
