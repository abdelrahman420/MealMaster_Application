package com.example.mealmaster.model.network;


import android.util.Log;

import androidx.annotation.NonNull;


import com.example.mealmaster.model.Responses.AreaListResponse;
import com.example.mealmaster.model.Responses.CategoryResponse;
import com.example.mealmaster.model.Responses.FilterMealResponse;
import com.example.mealmaster.model.Responses.IngredientListResponse;
import com.example.mealmaster.model.Responses.MealResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSourceImpl implements RemoteDataSource {
    private static final String TAG = "MealsClient";
    private static final String BASE_URL = "https://www.themealdb.com/";
    private static RemoteDataSource client = null;
    MealApiServices mealServices;

    private RemoteDataSourceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mealServices = retrofit.create(MealApiServices.class);
    }
    public static RemoteDataSource getInstance() {
        if (client == null) {
            client = new RemoteDataSourceImpl();
        }
        return client;
    }
    @Override
    public void searchMealsByName(String mealName, NetworkCall networkCallBack) {
        mealServices.searchMealByName(mealName).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Meals Found: " + response.body().getMeals());
                    networkCallBack.OnGetMealSuccess(response.body().getMeals());
                } else {
                    Log.i(TAG, "No Meals Found: ");
                    networkCallBack.onFailureResult("No meals Found");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void searchMealsByFirstLetter(char firstLetter, NetworkCall networkCallBack) {
        mealServices.listMealsByFirstLetter(firstLetter).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Meals Found: " + response.body().getMeals());
                    networkCallBack.OnGetMealSuccess(response.body().getMeals());
                } else {
                    Log.i(TAG, "No Meals Found: ");
                    networkCallBack.onFailureResult("No meals Found");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });

    }

    @Override
    public void lookupMealById(String mealId, NetworkCall networkCallBack) {

        mealServices.findMealById(mealId).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Meal Found: " + response.body().getMeals());
                    networkCallBack.OnGetMealByIDSuccess(response.body().getMeals().get(0));
                } else {
                    Log.i(TAG, "No Meals Found: ");
                    networkCallBack.onFailureResult("No meals Found");
                }
            }
            @Override
            public void onFailure(Call<MealResponse> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });

    }

    @Override
    public void lookupRandomMeal(NetworkCall networkCallBack) {

        mealServices.getRandomMeal().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Meal Found: " + response.body().getMeals());
                    networkCallBack.OnGetMealSuccess(response.body().getMeals());
                } else {
                    Log.i(TAG, "No Meals Found: ");
                    networkCallBack.onFailureResult("No meals Found");
                }
            }
            @Override
            public void onFailure(Call<MealResponse> call, @NonNull Throwable throwable) {
                networkCallBack.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void allCategories(NetworkCall networkCallback) {
        mealServices.listAllCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.body() != null && response.body().getCategories() != null) {
                    Log.i(TAG, "Categories found: " + response.body().getCategories().size());
                    networkCallback.onSuccessAllMealCategories(response.body().getCategories());
                } else {
                    networkCallback.onFailureResult("No categories found.");
                }
            }
            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }


    @Override
    public void listAllAreas(NetworkCall networkCallback) {
        mealServices.listAllAreas().enqueue(new Callback<AreaListResponse>() {
            @Override
            public void onResponse(Call<AreaListResponse> call, Response<AreaListResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Areas Found " + response.body().getMeals().size());
                    networkCallback.onSuccessListArea(response.body().getMeals());
                } else {
                    networkCallback.onFailureResult("No Areas found.");
                }
            }

            @Override
            public void onFailure(Call<AreaListResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void listAllIngredients(NetworkCall networkCallback) {
        mealServices.listAllIngredients().enqueue(new Callback<IngredientListResponse>() {
            @Override
            public void onResponse(Call<IngredientListResponse> call, Response<IngredientListResponse> response) {
                if (response.body() != null && response.body().getIngredientList() != null) {
                    Log.i(TAG, "Ingredients found: " + response.body().getIngredientList().size());
                    networkCallback.onSuccessListIngredients(response.body().getIngredientList());
                } else {
                    networkCallback.onFailureResult("No ingredients found.");
                }
            }
            @Override
            public void onFailure(Call<IngredientListResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });
    }

    @Override
    public void filterMealsByCategory(String category, NetworkCall networkCallback) {
        mealServices.filterByCategory(category).enqueue(new Callback<FilterMealResponse>() {
            @Override
            public void onResponse(Call<FilterMealResponse> call, Response<FilterMealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Filtered meals by category found : " + response.body().getMeals().size());
                    networkCallback.onSuccessFilteredMeals(response.body().getMeals());
                } else {
                    networkCallback.onFailureResult("No meals found.");
                }
            }

            @Override
            public void onFailure(Call<FilterMealResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());

            }
        });

    }

    @Override
    public void filterMealsByArea(String area, NetworkCall networkCallback) {
        mealServices.filterByArea(area).enqueue(new Callback<FilterMealResponse>() {
            @Override
            public void onResponse(Call<FilterMealResponse> call, Response<FilterMealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Filtered meals by Area found : " + response.body().getMeals().size());
                    networkCallback.onSuccessFilteredMeals(response.body().getMeals());
                } else {
                    networkCallback.onFailureResult("No meals found.");
                }
            }
            @Override
            public void onFailure(Call<FilterMealResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());

            }
        });
    }

    @Override
    public void filterMealsByIngredient(String ingredient, NetworkCall networkCallback) {
        mealServices.filterByMainIngredient(ingredient).enqueue(new Callback<FilterMealResponse>() {
            @Override
            public void onResponse(Call<FilterMealResponse> call, Response<FilterMealResponse> response) {
                if (response.body() != null && response.body().getMeals() != null) {
                    Log.i(TAG, "Filtered meals by ingredient found :  " + response.body().getMeals().size());
                    networkCallback.onSuccessFilteredMeals(response.body().getMeals());
                } else {
                    networkCallback.onFailureResult("No meals found.");
                }
            }
            @Override
            public void onFailure(Call<FilterMealResponse> call, Throwable throwable) {
                networkCallback.onFailureResult(throwable.getMessage());
            }
        });

    }
}


