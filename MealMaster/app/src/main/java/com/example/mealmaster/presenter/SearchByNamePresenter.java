package com.example.mealmaster.presenter;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.search.SearchByNameView;

import java.util.ArrayList;
import java.util.List;

public class SearchByNamePresenter implements NetworkCall {
    private final SearchByNameView view;
    private final MealRepository mealRepository;
    private List<MealDTO> Meals = new ArrayList<>();
    public SearchByNamePresenter(SearchByNameView view, MealRepository mealRepository) {
        this.view = view;
        this.mealRepository = mealRepository;
    }

    public void searchMealsByName(String query) {
        mealRepository._searchMealsByName(query,this);
    }

    @Override
    public void OnGetMealSuccess(List<MealDTO> meals) {
        Meals.clear();
        Meals.addAll(meals);
        view.displaySearchByName(meals);
    }

    @Override
    public void OnGetMealByIDSuccess(MealDTO meal) {

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
        view.showError(errMsg);
    }
}
