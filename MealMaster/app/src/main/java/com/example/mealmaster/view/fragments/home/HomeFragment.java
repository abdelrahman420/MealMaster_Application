package com.example.mealmaster.view.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.HomePresenter;
import com.example.mealmaster.view.adapter.CategoryListAdapter;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;
import com.example.mealmaster.view.fragments.search.OnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentView ,OnMealCLickListener{

    private RecyclerView recyclerView;
    private CategoryListAdapter categoryListAdapter;
    private HomePresenter presenter;
    private TextView txtMeal;
    private ImageView imgTodaysMeal;
    private MealDTO todaysMeal;
    private OnSearchClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())),this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.recyclerview);
        txtMeal = view.findViewById(R.id.txtTodaysMeal);
        imgTodaysMeal = view.findViewById(R.id.imgTodaysMeal);

        categoryListAdapter = new CategoryListAdapter(new ArrayList<>(), getContext(),listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(categoryListAdapter);
        imgTodaysMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (todaysMeal != null) {  // Add a null check here
                    presenter.navigateToMealDetails(todaysMeal);
                } else {
                    Toast.makeText(getContext(), "Meal is not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        presenter.loadCategories();
        presenter.loadMealOfTheDay();
    }

    @Override
    public void displayCategories(List<CategoriesDTO> categories) {
        categoryListAdapter.updateCategories(categories);
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
        todaysMeal = meal.get(0);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMealClick(MealDTO meal) {
        MealDetailsFragment mealDetailsFragment = new MealDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("meal", meal);
        mealDetailsFragment.setArguments(bundle);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, mealDetailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
