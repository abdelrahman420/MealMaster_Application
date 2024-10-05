package com.example.mealmaster.presenter;

import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.view.fragments.search.result.ResultView;

public class ResultPresenter {
    ResultView resultView;
    MealRepository mealRepository;
    public ResultPresenter( ResultView resultView, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.resultView =resultView;
    }
}

