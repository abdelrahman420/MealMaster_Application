package com.example.mealmaster.model.database.DTOs;

public class IngredientDTO {

    private String name;
    private String measure;
    private String imageUrl;


    public IngredientDTO(String name, String measure, String imageUrl) {
        this.name = name;
        this.measure = measure;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}



