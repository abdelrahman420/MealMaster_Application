package com.example.mealmaster.view.fragments.meal_details;

import com.example.mealmaster.model.DTOs.MealDTO;

public interface MealDetailsView {
    void showMealDetails(MealDTO meal);
    void OnAddToFav(MealDTO meal);
    void showDatePickerDialog();
    void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth);
}
