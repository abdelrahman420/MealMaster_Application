package com.example.mealmaster.model.network.Responses;

import com.example.mealmaster.model.database.DTOs.CategoryListDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

   
public class CategoryListResponse {

   @SerializedName("meals")
   List<CategoryListDTO> CategoryList;


    public void setCategoryList(List<CategoryListDTO> CategorList) {
        this.CategoryList = CategoryList;
    }
    public List<CategoryListDTO> getCategoryList() {
        return CategoryList;
    }
    
}