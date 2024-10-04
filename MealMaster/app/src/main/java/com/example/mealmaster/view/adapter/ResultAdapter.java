package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.view.fragments.meal_details.MealDetailsFragment;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private Context context;
    private List<MealDTO> mealsList;
    private FragmentManager fragmentManager;

    public ResultAdapter(Context context, List<MealDTO> mealsList, FragmentManager fragmentManager) {
        this.context = context;
        this.mealsList = mealsList;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentPosition = holder.getAdapterPosition();
        MealDTO meal = mealsList.get(currentPosition);

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
                Log.d("ResultAdapter", "Item clicked: " + meal.getStrMeal());
                MealDetailsFragment mealDetailsFragment = new MealDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("meal", meal);
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
        private ImageView imgResult;
        private TextView txtResult;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgResult = itemView.findViewById(R.id.imgPlanMeal);
            txtResult = itemView.findViewById(R.id.txtPlanMeal);
        }
    }
}


