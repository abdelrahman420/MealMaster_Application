package com.example.mealmaster.model.database.DTOs;

import com.google.gson.annotations.SerializedName;

   
public class CategoryListDTO {

   @SerializedName("strCategory")
   String strCategory;


    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    public String getStrCategory() {
        return strCategory;
    }
    
}