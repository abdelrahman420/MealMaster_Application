package com.example.mealmaster.view.fragments.search.result;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mealmaster.R;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repository.MealRepositoryImpl;
import com.example.mealmaster.presenter.ResultPresenter;
import com.example.mealmaster.view.adapter.ResultAdapter;

import java.util.List;


public class ResultFragment extends Fragment implements ResultView {


    ResultAdapter resultAdapter;
    RecyclerView resultRecyclerView;
    List<MealDTO> meals;
    ResultPresenter resultPresenter;
    FragmentManager fragmentManager;
    public ResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultPresenter = new ResultPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        meals = getArguments().getParcelableArrayList("SearchMeals");
        fragmentManager = getParentFragmentManager();
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultRecyclerView = view.findViewById(R.id.dayRecyclerView);

        resultAdapter = new ResultAdapter(getContext(), meals, fragmentManager);


        resultRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        resultRecyclerView.setAdapter(resultAdapter);

    }

    @Override
    public void showData(List<MealDTO> meals) {
        resultAdapter.updateData(meals);
    }




}