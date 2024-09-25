package com.example.mealmaster.model.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

@Dao
public interface FavMealDAO {
    @Insert
    void insertMeal(MealDTO meal);

    @Query("SELECT * FROM meals")
    List<MealDTO> getAllMeals();

    @Delete
    void deleteMeal(MealDTO product);

}
