package com.example.mealmaster.model.database;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;

import java.util.Collections;
import java.util.List;

public class LocalDataSourceImpl implements LocalDataSource{

        private Context context;
        private FavMealDAO favMealDAO;
        private MealPlanDAO mealPlanDAO;
        private LiveData<List<MealDTO>> storedFavMeals;
        private static LocalDataSource localDataSource = null;

        private LocalDataSourceImpl(Context context) {
            this.context = context;
            AppDatabase db = AppDatabase.getInstance(this.context.getApplicationContext());
            favMealDAO = db.getFavMealDAO();
            mealPlanDAO = db.getMealPlanDAO();
            storedFavMeals = favMealDAO.getFavMeals();
        }
        public static LocalDataSource getInstance(Context context) {
            if (localDataSource == null){
                localDataSource = new LocalDataSourceImpl(context);
            }
            return localDataSource;
        }

    @Override
    public LiveData<List<MealDTO>> getStoredData() {

            return storedFavMeals;
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

    @Override
    public void insertInMealPlan(MealPlanDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MealPlanDTO existingMealPlan = mealPlanDAO.getMealByDate(meal.getIdMeal(), meal.getDate());
                if(existingMealPlan == null)
                    mealPlanDAO.insertMeal(meal);
                else
                    Toast.makeText(context, meal.getStrMeal()+"is already added to this day", Toast.LENGTH_SHORT).show();
            }
        }).start();
    }

    @Override
    public void deleteFromMealPlan(MealPlanDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                mealPlanDAO.deleteMeal(meal);
            }
        }).start();
    }

    @Override
    public LiveData<List<MealPlanDTO>> getMealsByDate(String date) {
        return mealPlanDAO.getMealsByDate(date);
    }
}

