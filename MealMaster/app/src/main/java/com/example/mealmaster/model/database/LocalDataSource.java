package com.example.mealmaster.model.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface LocalDataSource {
    LiveData<List<MealDTO>> getStoreData();

    void delete(MealDTO meal);

    void insert(MealDTO meal);
}
