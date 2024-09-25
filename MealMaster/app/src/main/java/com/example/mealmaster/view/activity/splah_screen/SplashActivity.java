package com.example.mealmaster.view.activity.splah_screen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mealmaster.R;
import com.example.mealmaster.presenter.SplashScreenPresenter;
import com.example.mealmaster.view.activity.main_screen.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashScreenView {

    private static final String TAG = "SplashActivity";
    private SplashScreenPresenter presenter;

    private TextView txtSplash;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        // Initialize the presenter
        presenter = new SplashScreenPresenter(this);

        // Initialize the UI component
        txtSplash = findViewById(R.id.txtSplash);
        txtSplash.setText("Meal Master");
        presenter.startSplashDelay();
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

    }
    @Override
    public void displaySplashText(String text) {
        txtSplash.setText(text);
    }
}