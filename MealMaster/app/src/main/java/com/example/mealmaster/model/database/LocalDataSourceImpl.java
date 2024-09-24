package com.example.mealmaster.model.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalDataSourceImpl implements LocalDataSource{

        private Context context;
        private MealDAO mealDAO;
        private LiveData<List<MealDTO>> storedMeals;
        private static LocalDataSource localDataSource = null;

        private LocalDataSourceImpl(Context context) {
            this.context = context;
            MealDatabase db = MealDatabase.getDatabase(this.context.getApplicationContext());
            mealDAO = db.mealsDao();
            storedMeals = (LiveData<List<MealDTO>>) mealDAO.getAllMeals();
        }

        public static LocalDataSource getInstance(Context context) {
            if (localDataSource == null){
                localDataSource = new LocalDataSourceImpl(context);
            }
            return localDataSource;
        }

        @Override
        public LiveData<List<MealDTO>> getStoreData() {
            return storedMeals;
        }

    @Override
    public void delete(MealDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mealDAO.deleteMeal(meal);
            }
        }).start();
    }

    @Override
    public void insert(MealDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mealDAO.insertMeal(meal);
            }
        }).start();
    }


}
