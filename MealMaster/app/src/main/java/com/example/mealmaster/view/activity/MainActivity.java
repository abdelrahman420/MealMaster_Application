package com.example.mealmaster.view.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.NetworkCall;
import com.example.mealmaster.model.network.RemoteDataSource;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
}