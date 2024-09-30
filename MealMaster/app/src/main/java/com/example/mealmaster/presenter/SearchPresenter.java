package com.example.mealmaster.presenter;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.home.OnMealCLickListener;
import com.example.mealmaster.view.fragments.search.SearchFragmentView;

import java.util.List;

public class SearchPresenter implements NetworkCall {
    private MealRepository mealRepository;
    SearchFragmentView view;
    private OnMealCLickListener onMealCLickListener;
    public SearchPresenter(SearchFragmentView view, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.view =view;
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

    }

    @Override
    public void onFailureResult(String errMsg) {

    }
}
