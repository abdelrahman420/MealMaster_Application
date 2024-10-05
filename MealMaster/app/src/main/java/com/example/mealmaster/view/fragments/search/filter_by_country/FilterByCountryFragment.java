package com.example.mealmaster.view.fragments.search.filter_by_country;

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
import com.example.mealmaster.model.DTOs.AreaListDTO;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repository.MealRepositoryImpl;
import com.example.mealmaster.presenter.FilterCountryPresenter;
import com.example.mealmaster.view.adapter.CountryListAdapter;
import com.example.mealmaster.view.fragments.search.result.ResultFragment;

import java.util.ArrayList;
import java.util.List;


public class FilterByCountryFragment extends Fragment implements OnCountryListener, FilterByCountryView {

    private CountryListAdapter countryListAdapter;
    private RecyclerView countriesRecyclerView;
    FilterCountryPresenter filterCountryPresenter;
    public FilterByCountryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filterCountryPresenter = new FilterCountryPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filter_by_country, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countriesRecyclerView = view.findViewById(R.id.recyclerViewCountry);
        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        countryListAdapter = new CountryListAdapter(new ArrayList<>(), getContext(), this);
        countriesRecyclerView.setAdapter(countryListAdapter);
        filterCountryPresenter.loadAllCountries();
    }

    @Override
    public void displayAllCountries(List<AreaListDTO> countries) {
        countryListAdapter.updateCountries(countries);
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
    public void onCountryListener(String country) {
        filterCountryPresenter.getMealByArea(country);
    }
}