package com.example.mealmaster.view.activity.main_screen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mealmaster.R;
import com.example.mealmaster.databinding.ActivityMainBinding;
import com.example.mealmaster.presenter.MainPresenter;
import com.example.mealmaster.view.fragments.Home.HomeFragment;

public class MainActivity extends AppCompatActivity implements MainScreenView{

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new MainPresenter(this, this);
        replaceFragment(new HomeFragment());


        binding.navView.setOnItemSelectedListener(item ->
        {
            presenter.onNavigationItemSelected(item.getItemId());
            return true;
        });
    }

    public void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

}