package com.example.mealmaster.model.database;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public interface LocalDataSource {
    LiveData<List<MealDTO>> getStoredData();

    void delete(MealDTO meal);

    void insert(MealDTO meal);
}
