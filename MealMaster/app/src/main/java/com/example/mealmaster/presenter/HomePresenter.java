package com.example.mealmaster.presenter;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.home.HomeFragmentView;
import com.example.mealmaster.view.fragments.home.OnMealCLickListener;

import java.util.List;

public class HomePresenter implements NetworkCall{
    private MealRepository mealRepository;
    HomeFragmentView view;
    private OnMealCLickListener onMealCLickListener;
    public HomePresenter(HomeFragmentView view, MealRepository mealRepository, OnMealCLickListener onMealCLickListener) {
        this.mealRepository = mealRepository;
        this.view =view;
        this.onMealCLickListener = onMealCLickListener;
    }
    public void loadCategories() {
        mealRepository._allCategories(this);
    }
    public void loadMealOfTheDay() {
        mealRepository._lookupRandomMeal(this);
    }

    public void navigateToMealDetails(MealDTO meal) {
        onMealCLickListener.onMealClick(meal);
    }
    @Override
    public void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList) {
        view.displayCategories(categoriesList);
    }

    @Override
    public void onFailureResult(String errMsg) {
        view.showError(errMsg);
    }


    @Override
    public void OnGetMealSuccess(List<MealDTO> meal) {
        view.displayTodaysMeal(meal);
    }

    @Override
    public void OnGetMealByIDSuccess(MealDTO meal) {

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


}
