package com.example.mealmaster.model.Responses;
import com.example.mealmaster.model.DTOs.IngredientListDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientListResponse {

    @SerializedName("meals")
    List<IngredientListDTO> IngredientList;


    public void setIngredientList(List<IngredientListDTO> IngredientList) {
        this.IngredientList = IngredientList;
    }
    public List<IngredientListDTO> getIngredientList() {
        return IngredientList;
    }
}
