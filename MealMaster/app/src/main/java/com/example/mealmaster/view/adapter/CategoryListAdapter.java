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
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;
import com.example.mealmaster.view.fragments.search.filter_by_category.OnCategoryListener;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{

        private List<CategoriesDTO> categories;
        private Context context;
        private OnCategoryListener listener;
        public CategoryListAdapter(List<CategoriesDTO> categories, Context context, OnCategoryListener listener) {
            this.categories = categories;
            this.context = context;
            this.listener = listener;
        }

        @Override
        public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
            CategoriesDTO category = categories.get(position);
            String categoryName = category.getStrCategory();
            // Setting the product details
            holder.txtCategory.setText(category.getStrCategory());
            holder.txtDescription.setText(category.getStrCategoryDescription());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCategoryListener(categoryName);
                }
            });


            // Loading the image using Glide
            Glide.with(context)
                    .load(category.getStrCategoryThumb())
                    .apply(new RequestOptions().override(150, 150))
                    .placeholder(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageView);
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
