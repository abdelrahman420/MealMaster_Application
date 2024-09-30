package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;

import java.util.List;

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder>{

    private List<IngredientListDTO> ingredients;
    private Context context;
    public IngredientListAdapter(List<IngredientListDTO> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }


    @Override
    public IngredientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_ingredient, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        IngredientListDTO ingredient = ingredients.get(position);

        holder.txtIngredient.setText(ingredient.getStrIngredient());

        Glide.with(context)
                .load("https://www.themealdb.com/images/ingredients/"+holder.txtIngredient.getText()+".png")
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgIngredient);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtIngredient;
        public ImageView imgIngredient;
        public ViewHolder(View itemView) {
            super(itemView);
            txtIngredient = itemView.findViewById(R.id.textIngredientName);
            imgIngredient = itemView.findViewById(R.id.imageIngredient);
        }
    }
    public void updateIngredients(List<IngredientListDTO> newIngredients) {
        this.ingredients.clear();
        this.ingredients.addAll(newIngredients);
        notifyDataSetChanged();
    }
}
