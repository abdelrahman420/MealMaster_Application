package com.example.mealmaster.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mealmaster.model.DTOs.MealPlanDTO;

import java.util.List;


@Dao
public interface MealPlanDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(MealPlanDTO meal);

    @Delete
    void deleteMeal(MealPlanDTO meal);

    @Query("SELECT * FROM meals_plan WHERE idMeal = :idMeal AND date = :date")
    MealPlanDTO getMealByDate(String idMeal,String date);

    @Query("SELECT * FROM meals_plan WHERE date = :date")
    LiveData<List<MealPlanDTO>> getMealsByDate(String date);
}
