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
import android.widget.Toast;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.presenter.CategoriesPresenter;
import com.example.mealmaster.view.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeFragmentView {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private CategoriesPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CategoriesPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview); // Assuming you have set the RecyclerView ID

        categoryAdapter = new CategoryAdapter(new ArrayList<>(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(categoryAdapter);
        presenter.loadCategories();
    }

    public void displayCategories(List<CategoriesDTO> categories) {
        categoryAdapter.updateCategories(categories); // Update the adapter with the new list
    }

    @Override
    public void showError(String message) {
        // Show an error message to the user, you can use a Toast, Snackbar, or any other UI element
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}