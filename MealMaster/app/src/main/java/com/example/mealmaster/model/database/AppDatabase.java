package com.example.mealmaster.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;


@Database(entities = {MealDTO.class, MealPlanDTO.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance = null;
    public abstract FavMealDAO getFavMealDAO();
    public abstract MealPlanDAO getMealPlanDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "meals_database")
                    .fallbackToDestructiveMigration().build();

        }
        return instance;
    }
}

