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
import com.example.mealmaster.model.database.DTOs.MealPlanDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepository;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.view.adapter.WeeklyPlanAdapter;

import java.util.ArrayList;
import java.util.List;


public class DayMealsFragment extends Fragment {

    private TextView txtDay;
    private String selectedDay;
    private RecyclerView recyclerView;
    private WeeklyPlanAdapter adapter;
    private MealRepository repository;
    public DayMealsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        selectedDay = getArguments().getString("selected_day");
        repository = MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext()));
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
        txtDay.setText("Meals for "+selectedDay);
        LiveData<List<MealPlanDTO>> mealsList = repository._getMealsByDate(selectedDay);
        recyclerView = view.findViewById(R.id.dayRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new WeeklyPlanAdapter(getContext(), new ArrayList<>(), getActivity().getSupportFragmentManager(),repository);
        recyclerView.setAdapter(adapter);
        showMeals(mealsList);

    }

    public void showMeals(LiveData<List<MealPlanDTO>> meals) {
        Observer<List<MealPlanDTO>> observer = new Observer<List<MealPlanDTO>>() {
            @Override
            public void onChanged(List<MealPlanDTO> meals) {
                adapter.updateData(meals);
                adapter.notifyDataSetChanged();
            }
        };

        meals.observe(getViewLifecycleOwner(), observer);
    }

}