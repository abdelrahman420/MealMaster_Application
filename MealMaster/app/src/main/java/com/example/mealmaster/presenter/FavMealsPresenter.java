package com.example.mealmaster.presenter;

import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.repository.MealRepository;
import com.example.mealmaster.view.fragments.favourite_meals.FavFragmentView;

public class FavMealsPresenter {
    private MealRepository mealRepository;
    FavFragmentView view;
    public FavMealsPresenter(FavFragmentView view, MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        this.view =view;
    }
    public void deleteMeal(MealDTO meal) {mealRepository._deleteMeal(meal);}

    public void getFavMeals() {view.showMeals(mealRepository._getStoredMeals());}

    public void addToFav(MealDTO meal) {mealRepository._insertMeal(meal);}
}
