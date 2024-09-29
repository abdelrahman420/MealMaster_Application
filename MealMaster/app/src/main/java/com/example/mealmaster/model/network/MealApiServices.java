package com.example.mealmaster.model.network;

import com.example.mealmaster.model.network.Responses.AreaListResponse;
import com.example.mealmaster.model.network.Responses.CategoryResponse;
import com.example.mealmaster.model.network.Responses.FilterMealResponse;
import com.example.mealmaster.model.network.Responses.IngredientListResponse;
import com.example.mealmaster.model.network.Responses.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MealApiServices {
    // Search meal by name
    @GET("api/json/v1/1/search.php")
    Call<MealResponse> searchMealByName(@Query("s") String name);

    // List all meals by first letter
    @GET("api/json/v1/1/search.php")
    Call<MealResponse> listMealsByFirstLetter(@Query("f") char firstLetter);

    // Lookup full meal details by ID
    @GET("api/json/v1/1/lookup.php")
    Call<MealResponse> findMealById(@Query("i") String id);

    // Lookup a single random meal
    @GET("api/json/v1/1/random.php")
    Call<MealResponse> getRandomMeal();

    // List all meal categories
    @GET("api/json/v1/1/categories.php")
    Call<CategoryResponse> listAllCategories();

    @GET("api/json/v1/1/list.php?a=list")
    Call<AreaListResponse> listAllAreas();

    @GET("api/json/v1/1/list.php?i=list")
    Call<IngredientListResponse> listAllIngredients();

    // List meals by main ingredient
    @GET("api/json/v1/1/filter.php")
    Call<FilterMealResponse> filterByMainIngredient(@Query("i") String ingredient);

    // Filter by Category
    @GET("api/json/v1/1/filter.php")
    Call<FilterMealResponse> filterByCategory(@Query("c") String category);

    // Filter by Area
    @GET("api/json/v1/1/filter.php")
    Call<FilterMealResponse> filterByArea(@Query("a") String area);

}
