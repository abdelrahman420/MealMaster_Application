package com.example.mealmaster.view.fragments.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mealmaster.R;
import com.example.mealmaster.view.fragments.search.filter_by_category.FilterByCategoryFragment;
import com.example.mealmaster.view.fragments.search.filter_by_country.FilterByCountryFragment;
import com.example.mealmaster.view.fragments.search.filter_by_ingredient.FilterByIngredientFragment;
import com.example.mealmaster.view.fragments.search.search_by_name.SearchByNameFragment;


public class MainSearchFragment extends Fragment {

    private Button btnSearchByName;
    private Button btnFilterByCategory;
    private Button btnFilterByCountry;
    private Button btnFilterByIngredient;

    public MainSearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSearchByName = view.findViewById(R.id.buttonSearchByName);
        btnFilterByCategory = view.findViewById(R.id.buttonFilterByCategory);
        btnFilterByCountry = view.findViewById(R.id.buttonFilterByCountry);
        btnFilterByIngredient = view.findViewById(R.id.buttonFilterByIngredient);
        btnSearchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFragment(new SearchByNameFragment());
            }
        });
        btnFilterByCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFragment(new FilterByCategoryFragment());
            }
        });
        btnFilterByCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFragment(new FilterByCountryFragment());
            }
        });
        btnFilterByIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFragment(new FilterByIngredientFragment());
            }
        });
    }
    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}