package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.view.fragments.favourite_meals.OnFavClickListener;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private static final String TAG = "AllMealsAdapter";
    private Context context;
    private List<MealDTO> mealsList;
    private OnFavClickListener listener;
    private FragmentManager fragmentManager;

    public FavAdapter(Context context, List<MealDTO> mealsList, OnFavClickListener listener , FragmentManager fragmentManager ) {
        this.context = context;
        this.mealsList = mealsList;
        this.listener = listener;
        this.fragmentManager = fragmentManager;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_fav, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentPosition = holder.getAdapterPosition();
        MealDTO meal = mealsList.get(currentPosition);

        Glide.with(context)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgFav);
        holder.txtFav.setText(meal.getStrMeal());

        holder.btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnFavMealRmv(meal);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealDetailsFragment mealDetailsFragment = new MealDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("meal", meal);
                mealDetailsFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, mealDetailsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public void updateData(List<MealDTO> mealsList) {
        this.mealsList.clear();  // Clear the old data
        this.mealsList.addAll(mealsList);  // Add the new data
        notifyDataSetChanged();  // Notify the adapter to refresh the view
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFav;
        private TextView txtFav;
        private FloatingActionButton btnRmv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFav = itemView.findViewById(R.id.imgFavMeal);
            txtFav = itemView.findViewById(R.id.txtFavMealName);
            btnRmv = itemView.findViewById(R.id.btnFavRmv);
        }
    }
}

