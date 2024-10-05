package com.example.mealmaster.model.Responses;

import com.example.mealmaster.model.DTOs.CategoriesDTO;

import java.util.List;

public class CategoryResponse {

    List<CategoriesDTO> categories;

    public void setCategories(List<CategoriesDTO> categories) {
        this.categories = categories;
    }

    public List<CategoriesDTO> getCategories() {
        return categories;
    }

    public CategoryResponse(List<CategoriesDTO> categories) {
        this.categories = categories;
    }
}
