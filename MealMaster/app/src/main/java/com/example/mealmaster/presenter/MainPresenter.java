package com.example.mealmaster.presenter;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.mealmaster.R;
import com.example.mealmaster.view.activity.main_screen.MainScreenView;
import com.example.mealmaster.view.fragments.search.MainSearchFragment;
import com.example.mealmaster.view.fragments.weekly_plan.WeeklyPlanFragment;
import com.example.mealmaster.view.fragments.favourite_meals.FavFragment;
import com.example.mealmaster.view.fragments.home.HomeFragment;

public class MainPresenter {

    private MainScreenView view;
    private Context context;

    public MainPresenter(MainScreenView view, Context context) {
        this.view = view;
        this.context = context;
    }
    public void onNavigationItemSelected(int itemId) {
        Fragment selectedFragment = null;
        if (itemId == R.id.fav) {
            selectedFragment = new FavFragment();
        } else if (itemId == R.id.search) {
            selectedFragment = new MainSearchFragment();
        } else if (itemId == R.id.home) {
            selectedFragment = new HomeFragment();
        } else if (itemId == R.id.plan) {
            selectedFragment = new WeeklyPlanFragment();
        } else {
        }
        if (selectedFragment != null) {
            view.replaceFragment(selectedFragment);
        }
    }
}

