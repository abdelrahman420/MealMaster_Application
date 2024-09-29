package com.example.mealmaster.view.fragments.MealDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.IngredientDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.database.LocalDataSourceImpl;
import com.example.mealmaster.model.network.RemoteDataSourceImpl;
import com.example.mealmaster.model.repsitory.MealRepositoryImpl;
import com.example.mealmaster.presenter.MealDetailsPresenter;
import com.example.mealmaster.view.adapter.IngredientAdapter;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsFragment extends Fragment implements MealDetailsView {

    private ImageView mealImage;
    private ImageView areaImage;
    private TextView mealName ;
    private TextView mealCategory;
    private TextView mealArea ;
    private TextView mealInstructions ;
    private YouTubePlayerView youTubeVideo;
    private MealDTO meal;
    private MealDetailsPresenter presenter;
    private RecyclerView ingredientRecyclerView;
    private IngredientAdapter ingredientAdapter;
    private List<IngredientDTO> ingredientList = new ArrayList<>();
    public MealDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        mealImage=view.findViewById(R.id.imgMeal);
        mealName = view.findViewById(R.id.txtMealName);
        mealCategory = view.findViewById(R.id.txtMealCategory);
        mealArea = view.findViewById(R.id.txtCountry);
        mealInstructions = view.findViewById(R.id.steps);
        youTubeVideo = view.findViewById(R.id.video);
        ingredientRecyclerView = view.findViewById(R.id.IngRecyclerView);
        ingredientRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set up adapter
        ingredientAdapter = new IngredientAdapter(getContext(), ingredientList);
        ingredientRecyclerView.setAdapter(ingredientAdapter);


        presenter.loadMealDetails(getArguments());
    }

    @Override
    public void showMealDetails(MealDTO meal) {
        mealName.setText(meal.getStrMeal());
        mealCategory.setText(meal.getStrCategory());
        mealArea.setText(meal.getStrArea());
        mealInstructions.setText(meal.getStrInstructions());
        youTubeVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String[] videoId = meal.getStrYoutube().split("=");
                if(videoId.length > 1)
                    youTubePlayer.cueVideo(videoId[1], 0);
            }
        });
        Glide.with(this)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background) // Placeholder image
                .into(mealImage);
    }

}