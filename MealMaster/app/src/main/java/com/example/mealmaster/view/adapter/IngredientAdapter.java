package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.IngredientDTO;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private Context context;
    private List<IngredientDTO> ingredientsList;

    // Constructor for the adapter
    public IngredientAdapter(Context context, List<IngredientDTO> ingredientsList) {
        this.context = context;
        this.ingredientsList = ingredientsList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ingredient, parent, false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        IngredientDTO ingredient = ingredientsList.get(position);

        // Bind the ingredient name and image using Glide
        holder.ingredientName.setText(ingredient.getName());
        Glide.with(context)
                .load(ingredient.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)  // Placeholder while image loads
                .into(holder.ingredientImage);
    }

    @Override
    public int getItemCount() {
        return ingredientsList.size();
    }

    // ViewHolder class for RecyclerView
    public static class IngredientViewHolder extends RecyclerView.ViewHolder {
        TextView ingredientName;
        ImageView ingredientImage;
        TextView ingredientMeasure;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientName = itemView.findViewById(R.id.ingredientName);
            ingredientMeasure = itemView.findViewById(R.id.ingredientMeasure);
            ingredientImage = itemView.findViewById(R.id.ingredientImage);
        }
    }
}

