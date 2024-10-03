package com.example.mealmaster.presenter;

import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.favourite_meals.FavFragmentView;
import com.example.mealmaster.view.fragments.search.ResultView;

public class ResultPresenter {
    ResultView resultView;
    MealRepository mealRepository;
    public ResultPresenter( ResultView resultView, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.resultView =resultView;
    }
}

