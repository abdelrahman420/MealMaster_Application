package com.example.mealmaster.presenter;

import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.CategoryListDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.RemoteDataSource;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.view.fragments.HomeFragmentView;

import java.util.List;

public class CategoriesPresenter implements NetworkCall{
    private RemoteDataSource remoteDataSource;
    HomeFragmentView view;
    public CategoriesPresenter(HomeFragmentView view) {
        remoteDataSource = RemoteDataSourceImpl.getInstance();
        this.view =view;
    }
    public void loadCategories() {
        remoteDataSource.allCategories(this); // Fetching categories
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
    public void OnSearchMealSuccess(List<MealDTO> meals) {

    }

    @Override
    public void OnLookupRandomMealSuccess(List<MealDTO> meal) {

    }



    @Override
    public void onSuccessListCategories(List<CategoryListDTO> categoriesList) {

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
