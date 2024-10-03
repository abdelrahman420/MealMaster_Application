package com.example.mealmaster.presenter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;


import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.FilterMealDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsView;

import java.util.Calendar;
import java.util.List;

public class MealDetailsPresenter {

    private MealRepository mealRepository;
    private MealDetailsView view;
    public MealDetailsPresenter(MealDetailsView view,MealRepository mealRepository) {
        this.view = view;
        this.mealRepository = mealRepository;
    }
    public void loadMealDetails(MealDTO meal)
    {
        view.showMealDetails(meal);
    }
    public void addMealToFavorites(MealDTO meal) {
        mealRepository._insertMeal(meal);
    }
    public void addMealToPlan(MealPlanDTO mealPlan) {
        mealRepository._insertInMealPlan(mealPlan);
    }

    public void showDatePickerDialog(Context context) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar startOfWeek = (Calendar) calendar.clone();
        startOfWeek.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

        Calendar endOfWeek = (Calendar) calendar.clone();
        endOfWeek.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                view::onDateSet,
                year, month, day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(endOfWeek.getTimeInMillis());
        datePickerDialog.show();
    }
}
