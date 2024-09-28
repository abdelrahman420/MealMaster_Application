package com.example.mealmaster.model.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;

import java.util.List;

public class LocalDataSourceImpl implements LocalDataSource{

        private Context context;
        private FavMealDAO favMealDAO;
        private LiveData<List<MealDTO>> storedMeals;
        private static LocalDataSource localDataSource = null;

        private LocalDataSourceImpl(Context context) {
            this.context = context;
            AppDatabase db = AppDatabase.getInstance(this.context.getApplicationContext());
            favMealDAO = db.getFavMealDAO();
            storedMeals = (LiveData<List<MealDTO>>) favMealDAO.getFavMeals();
        }

        public static LocalDataSource getInstance(Context context) {
            if (localDataSource == null){
                localDataSource = new LocalDataSourceImpl(context);
            }
            return localDataSource;
        }

    @Override
    public LiveData<List<MealDTO>> getStoredData() {

            return storedMeals;
    }

    @Override
    public void delete(MealDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                favMealDAO.deleteMeal(meal);
            }
        }).start();
    }

    @Override
    public void insert(MealDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                favMealDAO.insertMeal(meal);
            }
        }).start();
    }
}

