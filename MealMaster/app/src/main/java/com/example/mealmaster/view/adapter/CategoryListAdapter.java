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
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{

        private List<CategoriesDTO> categories;
        private Context context;
        public CategoryListAdapter(List<CategoriesDTO> categories, Context context) {
            this.categories = categories;
            this.context = context;
        }


        @Override
        public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
            CategoriesDTO category = categories.get(position);

            // Setting the product details
            holder.txtCategory.setText(category.getStrCategory());
            holder.txtDescription.setText(category.getStrCategoryDescription());

            // Loading the image using Glide
            Glide.with(context)
                    .load(category.getStrCategoryThumb())  // URL of the image
                    .placeholder(R.drawable.ic_launcher_background)  // Placeholder while loading
                    .into(holder.imageView);  // Target ImageView to load into
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txtCategory;
            public TextView txtDescription;
            public ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                txtCategory = itemView.findViewById(R.id.txtCategory);
                txtDescription = itemView.findViewById(R.id.txtCategoryDescription);
                imageView = itemView.findViewById(R.id.imgCategory);
            }
        }
        public void updateCategories(List<CategoriesDTO> newCategories) {
            this.categories.clear();
            this.categories.addAll(newCategories);
            notifyDataSetChanged();
        }
}
