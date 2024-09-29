package com.example.mealmaster.presenter;

import android.os.Bundle;


import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.MealDetails.MealDetailsView;

import java.util.List;

public class MealDetailsPresenter implements NetworkCall {

    private MealRepository mealRepository;
    private MealDetailsView view;
    private   MealDTO meal;
    public MealDetailsPresenter(MealDetailsView view,MealRepository mealRepository) {
        this.view = view;
        this.mealRepository = mealRepository;
    }
    public void loadMealDetails(Bundle arguments)
    {
        meal = (MealDTO) arguments.getSerializable("meal");
        view.showMealDetails(meal);
    }
    @Override
    public void OnGetMealSuccess(List<MealDTO> meals) {

    }

    @Override
    public void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList) {

    }


    @Override
    public void onSuccessListArea(List<AreaListDTO> AreaList) {

    }

    @Override
    public void onSuccessListIngredients(List<IngredientListDTO> IngredientsList) {

    }

    @Override
    public void onSuccessFilteredMeals(List<FilterMealDTO> FilterMealsList) {

    }

    @Override
    public void onFailureResult(String errMsg) {

    }
}
