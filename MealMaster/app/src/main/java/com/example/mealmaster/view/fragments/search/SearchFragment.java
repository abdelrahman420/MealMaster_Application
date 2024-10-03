package com.example.mealmaster.view.fragments.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.HomePresenter;
import com.example.mealmaster.presenter.SearchPresenter;
import com.example.mealmaster.view.adapter.CategoryListAdapter;
import com.example.mealmaster.view.adapter.CountryListAdapter;
import com.example.mealmaster.view.adapter.IngredientListAdapter;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements SearchFragmentView,OnSearchClickListener {

    private RecyclerView categoriesRecyclerView;
    private RecyclerView countriesRecyclerView;
    private RecyclerView IngredientsRecyclerView;
    private CategoryListAdapter categoryListAdapter;
    private CountryListAdapter countryListAdapter;
    private IngredientListAdapter ingredientListAdapter;
    private SearchPresenter searchPresenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        searchPresenter = new SearchPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoriesRecyclerView = view.findViewById(R.id.recyclerViewCategory);
        countriesRecyclerView = view.findViewById(R.id.recyclerViewCountry);
        IngredientsRecyclerView = view.findViewById(R.id.recyclerViewIngredient);
        categoryListAdapter = new CategoryListAdapter(new ArrayList<>(), getContext(),this);
        countryListAdapter = new CountryListAdapter(new ArrayList<>(), getContext(),this);
        ingredientListAdapter = new IngredientListAdapter(new ArrayList<>(), getContext(),this);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        // Set up grid layout for ingredients
        IngredientsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3)); // 3 columns for the grid
        categoriesRecyclerView.setAdapter(categoryListAdapter);
        countriesRecyclerView.setAdapter(countryListAdapter);
        IngredientsRecyclerView.setAdapter(ingredientListAdapter);

        searchPresenter.loadAllCategories();
        searchPresenter.loadAllCountries();
        searchPresenter.loadAllIngredients();

    }

    @Override
    public void displayAllCategories(List<CategoriesDTO> categories) {
        categoryListAdapter.updateCategories(categories);
    }

    @Override
    public void displayAllCountries(List<AreaListDTO> countries) {
        countryListAdapter.updateCountries(countries);
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


    }

    @Override
    public void onCategoryListener(String category) {
        searchPresenter.getMealByCategory(category);
    }

    @Override
    public void onCountryListener(String country) {
        searchPresenter.getMealByArea(country);
    }

    @Override
    public void onIngredientListener(String ingredient) {
        searchPresenter.getMealByIngredient(ingredient);

    }
}