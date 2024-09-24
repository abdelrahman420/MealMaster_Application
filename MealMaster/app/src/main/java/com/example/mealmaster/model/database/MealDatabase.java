package com.example.mealmaster.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MealDTO.class}, version = 1)
public abstract class MealDatabase extends RoomDatabase {
    public abstract MealDAO mealsDao();

    private static MealDatabase INSTANCE;

    public static MealDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MealDatabase.class, "meals_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

