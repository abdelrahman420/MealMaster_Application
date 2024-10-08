package com.example.mealmaster.presenter;

import com.example.mealmaster.model.DTOs.AreaListDTO;
import com.example.mealmaster.model.DTOs.CategoriesDTO;
import com.example.mealmaster.model.DTOs.FilterMealDTO;
import com.example.mealmaster.model.DTOs.IngredientListDTO;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repository.MealRepository;
import com.example.mealmaster.view.fragments.search.filter_by_ingredient.FilterByIngredientView;

import java.util.ArrayList;
import java.util.List;

public class FilterIngredientPresenter implements NetworkCall {


    private MealRepository mealRepository;
    private FilterByIngredientView view;
    private List<MealDTO> Meals = new ArrayList<>();
    private List<FilterMealDTO> FilterMealsList;
    private int mealsCounter = 0;

    public FilterIngredientPresenter(FilterByIngredientView view, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.view = view;
    }

    public void loadAllIngredients() {
        mealRepository._listAllIngredients(this);
    }

    public void getMealByIngredient(String ingredient) {
        mealRepository._filterMealsByIngredient(ingredient, this);
    }

    @Override
    public void OnGetMealSuccess(List<MealDTO> meals) {

    }

    @Override
    public void OnGetMealByIDSuccess(MealDTO meal) {
        Meals.add(meal);
        mealsCounter++;
        if (mealsCounter == FilterMealsList.size()) {
            view.displaySearchResults(Meals);
            mealsCounter = 0;
        }
    }

    @Override
    public void onSuccessAllMealCategories(List<CategoriesDTO> categoriesList) {

    }

    @Override
    public void onSuccessListArea(List<AreaListDTO> AreaList) {
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
        view.showError(errMsg);
    }
}


