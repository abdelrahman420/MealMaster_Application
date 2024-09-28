package com.example.mealmaster.model.repsitory;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSource;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.network.RemoteDataSource;

import java.util.List;

public class MealRepositoryImpl implements MealRepository {

    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;
    private static MealRepository repo = null;

    public static MealRepository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        if (repo == null) {
            repo = new MealRepositoryImpl(remoteDataSource, localDataSource);
        }
        return repo;
    }

    public MealRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }




    @Override
    public LiveData<List<MealDTO>> getStoredMeals() {
        return localDataSource.getStoredData();
    }



    @Override
    public void insertMeal(MealDTO meal) {
        localDataSource.insert(meal);
    }

    @Override
    public void deleteMeal(MealDTO meal) {
        localDataSource.delete(meal);
    }

    @Override
    public void _searchMealsByName(String mealName, NetworkCall networkCallBack) {
        remoteDataSource.searchMealsByName(mealName,networkCallBack);
    }

    @Override
    public void _searchMealsByFirstLetter(char firstLetter, NetworkCall networkCallBack) {
        remoteDataSource.searchMealsByFirstLetter(firstLetter,networkCallBack);
    }

    @Override
    public void _lookupMealById(String mealId, NetworkCall networkCallBack) {
        remoteDataSource.lookupMealById(mealId,networkCallBack);
    }

    @Override
    public void _lookupRandomMeal(NetworkCall networkCallBack) {
        remoteDataSource.lookupRandomMeal(networkCallBack);
    }

    @Override
    public void _allCategories(NetworkCall networkCallback) {
        remoteDataSource.allCategories(networkCallback);
    }

    @Override
    public void _listAllAreas(NetworkCall networkCallback) {
        remoteDataSource.listAllAreas(networkCallback);
    }

    @Override
    public void _listAllIngredients(NetworkCall networkCallback) {
        remoteDataSource.listAllIngredients(networkCallback);
    }

    @Override
    public void _filterMealsByCategory(String category, NetworkCall networkCallback) {
        remoteDataSource.filterMealsByCategory(category,networkCallback);
    }

    @Override
    public void _filterMealsByArea(String area, NetworkCall networkCallback) {
        remoteDataSource.filterMealsByArea(area,networkCallback);
    }

    @Override
    public void _filterMealsByIngredient(String ingredient, NetworkCall networkCallback) {
        remoteDataSource.filterMealsByIngredient(ingredient,networkCallback);
    }
}
