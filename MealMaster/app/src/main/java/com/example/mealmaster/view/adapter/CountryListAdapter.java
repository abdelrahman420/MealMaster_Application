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
import com.example.mealmaster.model.database.DTOs.AreaListDTO;
import com.example.mealmaster.view.fragments.search.OnCountryListener;
import com.example.mealmaster.view.fragments.search.OnSearchClickListener;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder>{

    private List<AreaListDTO> countries;
    private Context context;
    private OnCountryListener listener;
    public CountryListAdapter(List<AreaListDTO> countries, Context context,OnCountryListener listener) {
        this.countries = countries;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        AreaListDTO country = countries.get(position);

        // Setting the product details


        String countryName =country.getStrArea();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCountryListener(countryName);
            }
        });
        holder.txtCountry.setText(countryName);

        int imageResId = context.getResources().getIdentifier(countryName.toLowerCase(), "drawable", context.getPackageName());

        Glide.with(context)
                .load(imageResId)
                .apply(new RequestOptions().override(150, 150))
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
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

