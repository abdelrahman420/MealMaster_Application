package com.example.mealmaster.presenter;

import android.os.Bundle;


import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsView;

import java.util.List;

public class MealDetailsPresenter {

    private MealRepository mealRepository;
    private MealDetailsView view;
    public MealDetailsPresenter(MealDetailsView view,MealRepository mealRepository) {
        this.view = view;
        this.mealRepository = mealRepository;
    }
    public void loadMealDetails(MealDTO meal)
    {
        view.showMealDetails(meal);
    }
    public void addMealToFavorites(MealDTO meal) {
        mealRepository._insertMeal(meal);
    }
}
