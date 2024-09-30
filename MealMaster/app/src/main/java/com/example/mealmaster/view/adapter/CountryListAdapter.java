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
import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.model.database.DTOs.CategoriesDTO;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder>{

    private List<AreaListDTO> countries;
    private Context context;
    public CountryListAdapter(List<AreaListDTO> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }


    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_country, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        AreaListDTO country = countries.get(position);

        // Setting the product details
        holder.txtCountry.setText(country.getStrArea());

        // Format the area name to match drawable file names
        String areaName = country.getStrArea().toLowerCase().replace(" ", "_").replaceAll("[^a-zA-Z0-9_]", "");

        // Get the image resource ID using the formatted area name
        int imageResId = context.getResources().getIdentifier(areaName, "drawable", context.getPackageName());

        Glide.with(context)
                .load(imageResId)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgCountry);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtCountry;
        public ImageView imgCountry;
        public ViewHolder(View itemView) {
            super(itemView);
            txtCountry = itemView.findViewById(R.id.countryName);
            imgCountry = itemView.findViewById(R.id.countryImage);
        }
    }
    public void updateCountries(List<AreaListDTO> newCountries) {
        this.countries.clear();
        this.countries.addAll(newCountries);
        notifyDataSetChanged();
    }
}

