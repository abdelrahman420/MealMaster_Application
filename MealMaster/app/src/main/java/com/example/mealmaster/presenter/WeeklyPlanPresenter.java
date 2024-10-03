package com.example.mealmaster.presenter;

import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsView;
import com.example.mealmaster.view.fragments.search.ResultView;

public class WeeklyPlanPresenter {
    private MealRepository mealRepository;
    public WeeklyPlanPresenter( MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
}
