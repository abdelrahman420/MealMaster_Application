package com.example.mealmaster.model.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

@Dao
public interface FavMealDAO {
    @Query("SELECT * FROM meals")
    LiveData<List<MealDTO>> getFavMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(MealDTO meal);

    @Delete
    void deleteMeal(MealDTO meal);

}
