package com.example.mealmaster.view.fragments.search.filter_by_category;

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
import android.widget.Toast;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.FilterCategoryPresenter;
import com.example.mealmaster.view.adapter.CategoryListAdapter;
import com.example.mealmaster.view.fragments.search.ResultFragment;

import java.util.ArrayList;
import java.util.List;


public class FilterByCategoryFragment extends Fragment implements FilterByCategoryView,OnCategoryListener {

    private CategoryListAdapter categoryListAdapter;
    private RecyclerView categoriesRecyclerView;
    FilterCategoryPresenter filterCategoryPresenter;
    public FilterByCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filterCategoryPresenter = new FilterCategoryPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_category, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoriesRecyclerView = view.findViewById(R.id.recyclerViewCategory);
        categoriesRecyclerView.setAdapter(categoryListAdapter);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        categoryListAdapter = new CategoryListAdapter(new ArrayList<>(), getContext(), this);
        categoriesRecyclerView.setAdapter(categoryListAdapter);
        filterCategoryPresenter.loadAllCategories();
    }

    @Override
    public void displayAllCategories(List<CategoriesDTO> categories) {
        categoryListAdapter.updateCategories(categories);
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
    public void onCategoryListener(String category) {
        filterCategoryPresenter.getMealByCategory(category);
    }
}