package com.example.mealmaster.view.fragments.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.FilterCountryPresenter;
import com.example.mealmaster.presenter.FilterIngredientPresenter;
import com.example.mealmaster.view.adapter.CountryListAdapter;
import com.example.mealmaster.view.adapter.IngredientListAdapter;

import java.util.ArrayList;
import java.util.List;


public class FilterByIngredientFragment extends Fragment implements FilterByIngredientView ,OnIngredientListener {


    private IngredientListAdapter ingredientListAdapter;
    private RecyclerView IngredientsRecyclerView;
    FilterIngredientPresenter filterIngredientPresenter;

    public FilterByIngredientFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filterIngredientPresenter = new FilterIngredientPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_by_ingredient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        IngredientsRecyclerView = view.findViewById(R.id.recyclerViewIngredient);
        ingredientListAdapter = new IngredientListAdapter(new ArrayList<>(), getContext(), this);
        IngredientsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        IngredientsRecyclerView.setAdapter(ingredientListAdapter);
        filterIngredientPresenter.loadAllIngredients();


    }

    @Override
    public void displayAllIngredients(List<IngredientListDTO> ingredients) {
        ingredientListAdapter.updateIngredients(ingredients);
    }

    @Override
    public void displaySearchResults(List<MealDTO> meals) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("SearchMeals", new ArrayList<>(meals));
        resultFragment.setArguments(bundle);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, resultFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onIngredientListener(String ingredient) {
        filterIngredientPresenter.getMealByIngredient(ingredient);
    }
}