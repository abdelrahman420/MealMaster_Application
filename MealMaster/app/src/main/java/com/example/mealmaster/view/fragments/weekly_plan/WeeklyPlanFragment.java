package com.example.mealmaster.view.fragments.weekly_plan;

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


public class WeeklyPlanFragment extends Fragment {

    private Button btnSaturday;
    private Button btnSunday;
    private Button btnMonday;
    private Button btnTuesday;
    private Button btnWednesday;
    private Button btnThursday;
    private Button btnFriday;

    public WeeklyPlanFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_weekly_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSaturday = view.findViewById(R.id.btnSaturday);
        btnSunday = view.findViewById(R.id.btnSunday);
        btnMonday = view.findViewById(R.id.btnMonday);
        btnTuesday = view.findViewById(R.id.btnTuesday);
        btnWednesday = view.findViewById(R.id.btnWednesday);
        btnThursday = view.findViewById(R.id.btnThursday);
        btnFriday = view.findViewById(R.id.btnFriday);
        btnSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Saturday");
            }
        });
        btnSunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Sunday");
            }
        });
        btnMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Monday");

            }
        });
        btnTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Tuesday");

            }
        });
        btnWednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Wednesday");

            }
        });
        btnThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Thursday");
            }
        });
        btnFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDayMeals("Friday");
            }
        });

    }

    private void navigateToDayMeals(String day) {
        DayMealsFragment dayMealsFragment = new DayMealsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("selected_day", day);
        dayMealsFragment.setArguments(bundle);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, dayMealsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}