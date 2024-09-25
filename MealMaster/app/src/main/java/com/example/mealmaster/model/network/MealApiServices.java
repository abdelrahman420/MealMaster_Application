package com.example.mealmaster.model.network;

import com.example.mealmaster.model.database.DTOs.IngredientListDTO;
import com.example.mealmaster.model.database.DTOs.MealDTO;
import com.example.mealmaster.model.network.Responses.AreaListResponse;
import com.example.mealmaster.model.network.Responses.CategoryListResponse;
import com.example.mealmaster.model.network.Responses.CategoryResponse;
import com.example.mealmaster.model.network.Responses.FilterMealResponse;
import com.example.mealmaster.model.network.Responses.IngredientListResponse;
import com.example.mealmaster.model.network.Responses.MealResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MealApiServices {
    // Search meal by name
    @GET("search.php")
    Call<MealResponse> searchMealByName(@Query("s") String name);

    // List all meals by first letter
    @GET("search.php")
    Call<MealResponse> listMealsByFirstLetter(@Query("f") char firstLetter);

    // Lookup full meal details by ID
    @GET("lookup.php")
    Call<MealResponse> findMealById(@Query("i") String id);

    // Lookup a single random meal
    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    // List all meal categories
    @GET("categories.php")
    Call<CategoryResponse> listAllCategories();

    // List all Categories, Area, Ingredients
    @GET("list.php?c=list")
    Call<CategoryListResponse> listCategories();

    @GET("list.php?a=list")
    Call<AreaListResponse> listAllAreas();

    @GET("list.php?i=list")
    Call<IngredientListResponse> listAllIngredients();

    // List meals by main ingredient
    @GET("filter.php")
    Call<FilterMealResponse> filterByMainIngredient(@Query("i") String ingredient);

    // Filter by Category
    @GET("filter.php")
    Call<FilterMealResponse> filterByCategory(@Query("c") String category);

    // Filter by Area
    @GET("filter.php")
    Call<FilterMealResponse> filterByArea(@Query("a") String area);



}
