package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mealmaster.R;
import com.example.mealmaster.model.DTOs.MealDTO;
import com.example.mealmaster.model.DTOs.MealPlanDTO;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;
import com.example.mealmaster.view.fragments.weekly_plan.OnRmvClickListeer;

import java.util.List;

public class WeeklyPlanAdapter extends RecyclerView.Adapter<WeeklyPlanAdapter.ViewHolder> {
    private Context context;
    private List<MealPlanDTO> mealsList;
    private FragmentManager fragmentManager;
    private OnRmvClickListeer onRmvClickListeer;

    public WeeklyPlanAdapter(Context context, List<MealPlanDTO> mealsList,FragmentManager fragmentManager,OnRmvClickListeer onRmvClickListeer) {
        this.context = context;
        this.mealsList = mealsList;
        this.fragmentManager = fragmentManager;
        this.onRmvClickListeer = onRmvClickListeer;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentPosition = holder.getAdapterPosition();
        MealPlanDTO meal = mealsList.get(currentPosition);

        Glide.with(context)
                .load(meal.getStrMealThumb())
                .apply(new RequestOptions().override(200, 200)
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(holder.imgResult);
        holder.txtResult.setText(meal.getStrMeal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MealDetailsFragment mealDetailsFragment = new MealDetailsFragment();
                Bundle bundle = new Bundle();
                MealDTO mealDTO = meal.convertToMealDTO(meal);
                bundle.putParcelable("meal", mealDTO);
                mealDetailsFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, mealDetailsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRmvClickListeer.OnDayMealRmv(meal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public void updateData(List<MealPlanDTO> mealsList) {
        this.mealsList.clear();  // Clear the old data
        this.mealsList.addAll(mealsList);  // Add the new data
        notifyDataSetChanged();  // Notify the adapter to refresh the view
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgResult;
        private TextView txtResult;
        private ImageButton btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgResult = itemView.findViewById(R.id.imgPlanMeal);
            txtResult = itemView.findViewById(R.id.txtPlanMeal);
            btnDelete = itemView.findViewById(R.id.btnDeleteMeal);
        }
    }

}

