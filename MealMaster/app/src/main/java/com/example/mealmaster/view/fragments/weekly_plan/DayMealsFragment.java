package com.example.mealmaster.view.fragments.weekly_plan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mealmaster.R;
import com.example.mealmaster.model.DTOs.MealPlanDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repository.MealRepositoryImpl;
import com.example.mealmaster.presenter.DayMealsPresenter;
import com.example.mealmaster.view.adapter.WeeklyPlanAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class DayMealsFragment extends Fragment implements DayMealsView, OnRmvClickListeer {

    private TextView txtDay;
    private String selectedDay;
    private RecyclerView recyclerView;
    private WeeklyPlanAdapter adapter;
    private DayMealsPresenter dayMealsPresenter;

    public DayMealsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        selectedDay = getArguments().getString("selected_day");
        dayMealsPresenter = new DayMealsPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtDay = view.findViewById(R.id.txtDay);
        txtDay.setText("Meals for " + selectedDay);
        recyclerView = view.findViewById(R.id.dayRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new WeeklyPlanAdapter(getContext(), new ArrayList<>(), getActivity().getSupportFragmentManager(), this);
        recyclerView.setAdapter(adapter);
        dayMealsPresenter.getDayMeals(selectedDay);

    }

    @Override
    public void showDayMeals(LiveData<List<MealPlanDTO>> meals) {
        Observer<List<MealPlanDTO>> observer = new Observer<List<MealPlanDTO>>() {
            @Override
            public void onChanged(List<MealPlanDTO> meals) {
                adapter.updateData(meals);
                adapter.notifyDataSetChanged();
            }
        };
        meals.observe(getViewLifecycleOwner(), observer);
    }

    @Override
    public void OnDayMealRmv(MealPlanDTO meal) {
        dayMealsPresenter.deleteMeal(meal);
        adapter.notifyDataSetChanged();

        Snackbar snackbar = Snackbar.make(getView(), meal.getStrMeal() + " Removed", Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayMealsPresenter.addToDay(meal);
                adapter.notifyDataSetChanged();
            }
        });
        snackbar.show();
    }
}