package com.example.mealmaster.view.fragments.meal_details;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mealmaster.R;
import com.example.mealmaster.model.DTOs.IngredientDTO;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.DTOs.MealPlanDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repository.MealRepositoryImpl;
import com.example.mealmaster.presenter.MealDetailsPresenter;
import com.example.mealmaster.view.adapter.IngredientAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MealDetailsFragment extends Fragment implements MealDetailsView, DatePickerDialog.OnDateSetListener {
    private ImageView mealImage;
    private ImageView areaImage;
    private TextView mealName;
    private TextView mealCategory;
    private TextView mealArea;
    private TextView mealInstructions;
    private YouTubePlayerView youTubeVideo;
    private MealDTO meal;
    private MealDetailsPresenter presenter;
    private RecyclerView ingredientRecyclerView;
    private IngredientAdapter ingredientAdapter;
    private List<IngredientDTO> ingredientList = new ArrayList<>();
    List<String> ingredientNames;
    List<String> ingredientMeasures;
    private Button btnAdd;
    private Button btnPlan;

    public MealDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meal = getArguments().getParcelable("meal");
        presenter = new MealDetailsPresenter(this, MealRepositoryImpl.getInstance(RemoteDataSourceImpl.getInstance(), LocalDataSourceImpl.getInstance(getContext())));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meal_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealImage = view.findViewById(R.id.imgMeal);
        mealName = view.findViewById(R.id.txtMealName);
        mealCategory = view.findViewById(R.id.txtMealCategory);
        mealArea = view.findViewById(R.id.txtCountry);
        mealInstructions = view.findViewById(R.id.steps);
        youTubeVideo = view.findViewById(R.id.video);
        ingredientRecyclerView = view.findViewById(R.id.IngRecyclerView);
        btnAdd = view.findViewById(R.id.btnAddToFav);
        btnPlan = view.findViewById(R.id.btnAddToPlan);
        areaImage = view.findViewById(R.id.imgCountry);
        ingredientRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ingredientNames = meal.getIngredients();
        ingredientMeasures = meal.getMeasures();
        for (int i = 0; i < ingredientNames.size(); i++) {
            ingredientList.add(new IngredientDTO(ingredientNames.get(i), ingredientMeasures.get(i)));
        }
        presenter.loadMealDetails(meal);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnAddToFav(meal);
            }
        });
        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    @Override
    public void showMealDetails(MealDTO meal) {
        mealName.setText(meal.getStrMeal());
        mealCategory.setText(meal.getStrCategory());
        mealArea.setText(meal.getStrArea());
        mealInstructions.setText(meal.getStrInstructions());
        ingredientAdapter = new IngredientAdapter(getContext(), ingredientList);
        ingredientRecyclerView.setAdapter(ingredientAdapter);
        youTubeVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String[] videoId = meal.getStrYoutube().split("=");
                if (videoId.length > 1)
                    youTubePlayer.cueVideo(videoId[1], 0);
            }
        });
        Glide.with(this)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mealImage);
        String areaName = meal.getStrArea().toLowerCase().replace(" ", "_").replaceAll("[^a-zA-Z0-9_]", ""); // Format area name
        int imageResId = getContext().getResources().getIdentifier(areaName, "drawable", getContext().getPackageName());
        Glide.with(this)
                .load(imageResId)
                .apply(new RequestOptions().override(150, 150))
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(areaImage);


    }

    @Override
    public void OnAddToFav(MealDTO meal) {
        presenter.addMealToFavorites(meal);
    }

    @Override
    public void showDatePickerDialog() {
        presenter.showDatePickerDialog(getContext());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar selectedDateCalendar = Calendar.getInstance();
        selectedDateCalendar.set(year, month, dayOfMonth);
        String dayName = getDayName(selectedDateCalendar.get(Calendar.DAY_OF_WEEK));
        MealPlanDTO mealPlan = new MealPlanDTO(meal, dayName);
        presenter.addMealToPlan(mealPlan);
    }
    private String getDayName(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "";
        }
    }
}
