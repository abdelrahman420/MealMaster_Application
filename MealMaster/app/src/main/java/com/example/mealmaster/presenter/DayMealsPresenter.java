package com.example.mealmaster.presenter;

import com.example.mealmaster.model.DTOs.MealPlanDTO;
import com.example.mealmaster.model.repository.MealRepository;
import com.example.mealmaster.view.fragments.weekly_plan.DayMealsView;

public class DayMealsPresenter {
    private MealRepository mealRepository;
    DayMealsView view;
    public DayMealsPresenter(DayMealsView view, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.view =view;
    }
    public void deleteMeal(MealPlanDTO meal) {mealRepository._deleteFromMealPlan(meal);}

    public void getDayMeals(String day) {
        view.showDayMeals(mealRepository._getMealsByDate(day));
    }

    public void addToDay(MealPlanDTO meal) {mealRepository._insertInMealPlan(meal);}
}
