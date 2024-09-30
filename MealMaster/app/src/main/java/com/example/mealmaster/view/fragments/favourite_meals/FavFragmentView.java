package com.example.mealmaster.view.fragments.favourite_meals;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface FavFragmentView {
    void showMeals(LiveData<List<MealDTO>> meals);
}
