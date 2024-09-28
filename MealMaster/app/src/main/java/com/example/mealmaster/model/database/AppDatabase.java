package com.example.mealmaster.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mealmaster.model.database.DTOs.MealDTO;


@Database(entities = {MealDTO.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance = null;
    public abstract FavMealDAO getFavMealDAO();
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "productsdb")
                    .build();

        }
        return instance;
    }

}

