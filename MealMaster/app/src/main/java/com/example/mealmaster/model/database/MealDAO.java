package com.example.mealmaster.model.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDAO {
    @Insert
    void insertMeal(MealDTO meal);

    @Query("SELECT * FROM meals")
    List<MealDTO> getAllMeals();

    @Delete
    void deleteMeal(MealDTO product);

}
