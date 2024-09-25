package com.example.mealmaster.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.presenter.HomePresenter;
import com.example.mealmaster.view.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentView {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private HomePresenter presenter;
    private TextView txtMeal;
    private ImageView imgTodaysMeal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.recyclerview);
        txtMeal = view.findViewById(R.id.txtMeal);
        imgTodaysMeal = view.findViewById(R.id.imgTodaysMeal);

        categoryAdapter = new CategoryAdapter(new ArrayList<>(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(categoryAdapter);

        presenter.loadCategories();
        presenter.loadMealOfTheDay();
    }

    @Override
    public void displayCategories(List<CategoriesDTO> categories) {
        categoryAdapter.updateCategories(categories);
    }

    @Override
    public void displayTodaysMeal(List<MealDTO> meal) {
        if (meal != null && !meal.isEmpty()) {
            txtMeal.setText(meal.get(0).getStrMeal());

            Glide.with(this)
                    .load(meal.get(0).getStrMealThumb())
                    .placeholder(R.drawable.ic_launcher_background) // Placeholder image
                    .into(imgTodaysMeal);
        } else {

            txtMeal.setText("Meal of the Day not available");
            imgTodaysMeal.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
