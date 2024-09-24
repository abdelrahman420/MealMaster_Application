package com.example.mealmaster.view.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mealmaster.R;
import com.example.mealmaster.model.database.LocalDataSource;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.database.MealDAO;
import com.example.mealmaster.model.database.MealDTO;
import com.example.mealmaster.model.database.MealDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
}