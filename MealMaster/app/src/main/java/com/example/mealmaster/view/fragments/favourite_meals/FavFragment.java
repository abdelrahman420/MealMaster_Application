package com.example.mealmaster.view.fragments.favourite_meals;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.FavMealsPresenter;
import com.example.mealmaster.presenter.HomePresenter;
import com.example.mealmaster.view.adapter.FavAdapter;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class FavFragment extends Fragment implements FavFragmentView,OnFavClickListener{

    FavAdapter favAdapter;
    RecyclerView favRecyclerView;
    FavMealsPresenter favMealsPresenter;
    public FavFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        favMealsPresenter = new FavMealsPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favRecyclerView = view.findViewById(R.id.favRecyclerView);
        favAdapter = new FavAdapter(getContext(),new ArrayList<>(), this,getParentFragmentManager());

        favRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        favRecyclerView.setAdapter(favAdapter);

        favMealsPresenter.getFavMeals();
    }

    @Override
    public void showMeals(LiveData<List<MealDTO>> meals) {
        Observer<List<MealDTO>> observer = new Observer<List<MealDTO>>() {
            @Override
            public void onChanged(List<MealDTO> meals) {
                favAdapter.updateData(meals);
                favAdapter.notifyDataSetChanged();
            }
        };

        meals.observe(this, observer);
    }

    @Override
    public void OnFavMealRmv(MealDTO meal) {
        favMealsPresenter.deleteMeal(meal);
        favAdapter.notifyDataSetChanged();

        Snackbar snackbar = Snackbar.make(getView(), meal.getStrMeal() + " Deleted", Snackbar.LENGTH_LONG);

        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favMealsPresenter.addToFav(meal);
                favAdapter.notifyDataSetChanged();
            }
        });
        snackbar.show();
    }

}