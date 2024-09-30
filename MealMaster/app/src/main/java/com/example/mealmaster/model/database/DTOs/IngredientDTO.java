package com.example.mealmaster.model.database.DTOs;

public class IngredientDTO {

    private String name;
    private String measure;


    public IngredientDTO(String name, String measure) {
        this.name = name;
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }
}



