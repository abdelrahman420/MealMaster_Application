package com.example.mealmaster.view.fragments.search.search_by_name;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mealmaster.R;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repository.MealRepositoryImpl;
import com.example.mealmaster.presenter.SearchByNamePresenter;
import com.example.mealmaster.view.adapter.ResultAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SearchByNameFragment extends Fragment implements SearchByNameView{

    private SearchByNamePresenter searchByNamePresenter;
    private ResultAdapter mealAdapter;
    private RecyclerView searchResultsRecyclerView;
    private EditText searchBar;
    private Timer searchTimer;
    FragmentManager fragmentManager;
    public SearchByNameFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchByNamePresenter = new SearchByNamePresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
        fragmentManager =getActivity().getSupportFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search_by_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchResultsRecyclerView = view.findViewById(R.id.recyclerViewSearchResults);
        searchBar = view.findViewById(R.id.searchBar);
        mealAdapter = new ResultAdapter( getContext(),new ArrayList<>(),fragmentManager);
        searchResultsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3)); // Layout manager for search results
        searchResultsRecyclerView.setAdapter(mealAdapter);
        setupSearchBar();
    }

    @Override
    public void displaySearchByName(List<MealDTO> meals) {
            mealAdapter.updateData(meals);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void setupSearchBar() {
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (searchTimer != null) {
                    searchTimer.cancel();
                }
                searchTimer = new Timer();
                searchTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String query = s.toString().trim();
                        if (!query.isEmpty()) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    searchByNamePresenter.searchMealsByName(query);
                                }
                            });
                        }
                    }
                }, 300);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}