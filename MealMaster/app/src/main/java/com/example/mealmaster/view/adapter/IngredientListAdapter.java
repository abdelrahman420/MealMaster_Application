package com.example.mealmaster.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mealmaster.R;
import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.view.fragments.search.filter_by_ingredient.OnIngredientListener;

import java.util.List;

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder>{

    private List<IngredientListDTO> ingredients;
    private Context context;
    private OnIngredientListener listener;
    public IngredientListAdapter(List<IngredientListDTO> ingredients, Context context,OnIngredientListener listener) {
        this.ingredients = ingredients;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public IngredientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_ingredient, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        IngredientListDTO ingredient = ingredients.get(position);
        String ingredientName = ingredient.getStrIngredient();
        holder.txtIngredient.setText(ingredient.getStrIngredient());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onIngredientListener(ingredient.getStrIngredient());
            }
        });
        Glide.with(context)
                .load("https://www.themealdb.com/images/ingredients/"+holder.txtIngredient.getText()+".png")
                .apply(new RequestOptions().override(150, 150))
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
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
