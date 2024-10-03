package com.example.mealmaster.presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.search.SearchFragmentView;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter implements NetworkCall {
    private MealRepository mealRepository;
    private SearchFragmentView view;
    private List<MealDTO> Meals = new ArrayList<>();
    private List<FilterMealDTO> FilterMealsList;
    private int mealsCounter = 0;


    public SearchPresenter(SearchFragmentView view, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.view =view;

    }

    public void getMealByArea(String area) {
        mealRepository._filterMealsByArea(area, this);
    }

    public void getMealByIngredient(String ingredient) {
        mealRepository._filterMealsByIngredient(ingredient,this);
    }

    public void getMealByCategory(String category) {
        mealRepository._filterMealsByCategory(category, this);
    }
    public void loadAllCategories() {
        mealRepository._allCategories(this);
    }
    public void loadAllCountries() {
        mealRepository._listAllAreas(this);
    }
    public void loadAllIngredients() {
        mealRepository._listAllIngredients(this);
    }

    @Override
    public void OnGetMealSuccess(List<MealDTO> meals) {

    }

    @Override
    public void OnGetMealByIDSuccess(MealDTO meal) {
        Meals.add(meal);
        mealsCounter++;
        if(mealsCounter == FilterMealsList.size())
        {
            view.displaySearchResults(Meals);
            mealsCounter = 0;
        }
    }

    @Override
    public void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList) {
        view.displayAllCategories(categoriesList);
    }

    @Override
    public void onSuccessListArea(List<AreaListDTO> AreaList) {
        view.displayAllCountries(AreaList);
    }

    @Override
    public void onSuccessListIngredients(List<IngredientListDTO> IngredientsList) {
        view.displayAllIngredients(IngredientsList);
    }

    @Override
    public void onSuccessFilteredMeals(List<FilterMealDTO> FilterMealsList) {
        this.FilterMealsList = FilterMealsList;
        for (FilterMealDTO meal : FilterMealsList) {
            mealRepository._lookupMealById(meal.getIdMeal(), this);
        }
    }

    @Override
    public void onFailureResult(String errMsg) {

    }
}
