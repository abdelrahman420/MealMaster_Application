package com.example.mealmaster.model.DTOs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


@Entity(tableName = "meals_plan" , primaryKeys = {"idMeal", "date"})
public class MealPlanDTO implements Parcelable {

    @NonNull
    @SerializedName("idMeal")
    String idMeal;

    @SerializedName("strMeal")
    String strMeal;

    @SerializedName("strDrinkAlternate")
    String strDrinkAlternate;

    @SerializedName("strCategory")
    String strCategory;

    @SerializedName("strArea")
    String strArea;

    @SerializedName("strInstructions")
    String strInstructions;

    @SerializedName("strMealThumb")
    String strMealThumb;

    @SerializedName("strTags")
    String strTags;

    @SerializedName("strYoutube")
    String strYoutube;

    @SerializedName("strIngredient1")
    String strIngredient1;

    @SerializedName("strIngredient2")
    String strIngredient2;

    @SerializedName("strIngredient3")
    String strIngredient3;

    @SerializedName("strIngredient4")
    String strIngredient4;

    @SerializedName("strIngredient5")
    String strIngredient5;

    @SerializedName("strIngredient6")
    String strIngredient6;

    @SerializedName("strIngredient7")
    String strIngredient7;

    @SerializedName("strIngredient8")
    String strIngredient8;

    @SerializedName("strIngredient9")
    String strIngredient9;

    @SerializedName("strIngredient10")
    String strIngredient10;

    @SerializedName("strIngredient11")
    String strIngredient11;

    @SerializedName("strIngredient12")
    String strIngredient12;

    @SerializedName("strIngredient13")
    String strIngredient13;

    @SerializedName("strIngredient14")
    String strIngredient14;

    @SerializedName("strIngredient15")
    String strIngredient15;

    @SerializedName("strIngredient16")
    String strIngredient16;

    @SerializedName("strIngredient17")
    String strIngredient17;

    @SerializedName("strIngredient18")
    String strIngredient18;

    @SerializedName("strIngredient19")
    String strIngredient19;

    @SerializedName("strIngredient20")
    String strIngredient20;

    @SerializedName("strMeasure1")
    String strMeasure1;

    @SerializedName("strMeasure2")
    String strMeasure2;

    @SerializedName("strMeasure3")
    String strMeasure3;

    @SerializedName("strMeasure4")
    String strMeasure4;

    @SerializedName("strMeasure5")
    String strMeasure5;

    @SerializedName("strMeasure6")
    String strMeasure6;

    @SerializedName("strMeasure7")
    String strMeasure7;

    @SerializedName("strMeasure8")
    String strMeasure8;

    @SerializedName("strMeasure9")
    String strMeasure9;

    @SerializedName("strMeasure10")
    String strMeasure10;

    @SerializedName("strMeasure11")
    String strMeasure11;

    @SerializedName("strMeasure12")
    String strMeasure12;

    @SerializedName("strMeasure13")
    String strMeasure13;

    @SerializedName("strMeasure14")
    String strMeasure14;

    @SerializedName("strMeasure15")
    String strMeasure15;

    @SerializedName("strMeasure16")
    String strMeasure16;

    @SerializedName("strMeasure17")
    String strMeasure17;

    @SerializedName("strMeasure18")
    String strMeasure18;

    @SerializedName("strMeasure19")
    String strMeasure19;

    @SerializedName("strMeasure20")
    String strMeasure20;

    @SerializedName("strSource")
    String strSource;

    @SerializedName("strImageSource")
    String strImageSource;

    @SerializedName("strCreativeCommonsConfirmed")
    String strCreativeCommonsConfirmed;

    @SerializedName("dateModified")
    String dateModified;

    @NonNull
    String date;

    public MealDTO convertToMealDTO(MealPlanDTO mealPlan) {
        return new MealDTO(
                mealPlan.idMeal,
                mealPlan.strMeal,
                mealPlan.strDrinkAlternate,
                mealPlan.strCategory,
                mealPlan.strArea,
                mealPlan.strInstructions,
                mealPlan.strMealThumb,
                mealPlan.strTags,
                mealPlan.strYoutube,
                mealPlan.strIngredient1,
                mealPlan.strIngredient2,
                mealPlan.strIngredient3,
                mealPlan.strIngredient4,
                mealPlan.strIngredient5,
                mealPlan.strIngredient6,
                mealPlan.strIngredient7,
                mealPlan.strIngredient8,
                mealPlan.strIngredient9,
                mealPlan.strIngredient10,
                mealPlan.strIngredient11,
                mealPlan.strIngredient12,
                mealPlan.strIngredient13,
                mealPlan.strIngredient14,
                mealPlan.strIngredient15,
                mealPlan.strIngredient16,
                mealPlan.strIngredient17,
                mealPlan.strIngredient18,
                mealPlan.strIngredient19,
                mealPlan.strIngredient20,
                mealPlan.strMeasure1,
                mealPlan.strMeasure2,
                mealPlan.strMeasure3,
                mealPlan.strMeasure4,
                mealPlan.strMeasure5,
                mealPlan.strMeasure6,
                mealPlan.strMeasure7,
                mealPlan.strMeasure8,
                mealPlan.strMeasure9,
                mealPlan.strMeasure10,
                mealPlan.strMeasure11,
                mealPlan.strMeasure12,
                mealPlan.strMeasure13,
                mealPlan.strMeasure14,
                mealPlan.strMeasure15,
                mealPlan.strMeasure16,
                mealPlan.strMeasure17,
                mealPlan.strMeasure18,
                mealPlan.strMeasure19,
                mealPlan.strMeasure20,
                mealPlan.strSource,
                mealPlan.strImageSource,
                mealPlan.strCreativeCommonsConfirmed,
                mealPlan.dateModified
        );
    }

    // Constructor
    public MealPlanDTO(MealDTO meal, String date) {
        this.idMeal = meal.idMeal;
        this.strMeal = meal.strMeal;
        this.strDrinkAlternate = meal.strDrinkAlternate;
        this.strCategory = meal.strCategory;
        this.strArea = meal.strArea;
        this.strInstructions = meal.strInstructions;
        this.strMealThumb = meal.strMealThumb;
        this.strTags = meal.strTags;
        this.strYoutube = meal.strYoutube;
        this.strIngredient1 = meal.strIngredient1;
        this.strIngredient2 = meal.strIngredient2;
        this.strIngredient3 = meal.strIngredient3;
        this.strIngredient4 = meal.strIngredient4;
        this.strIngredient5 = meal.strIngredient5;
        this.strIngredient6 = meal.strIngredient6;
        this.strIngredient7 = meal.strIngredient7;
        this.strIngredient8 = meal.strIngredient8;
        this.strIngredient9 = meal.strIngredient9;
        this.strIngredient10 = meal.strIngredient10;
        this.strIngredient11 = meal.strIngredient11;
        this.strIngredient12 = meal.strIngredient12;
        this.strIngredient13 = meal.strIngredient13;
        this.strIngredient14 = meal.strIngredient14;
        this.strIngredient15 = meal.strIngredient15;
        this.strIngredient16 = meal.strIngredient16;
        this.strIngredient17 = meal.strIngredient17;
        this.strIngredient18 = meal.strIngredient18;
        this.strIngredient19 = meal.strIngredient19;
        this.strIngredient20 = meal.strIngredient20;
        this.strMeasure1 = meal.strMeasure1;
        this.strMeasure2 = meal.strMeasure2;
        this.strMeasure3 = meal.strMeasure3;
        this.strMeasure4 = meal.strMeasure4;
        this.strMeasure5 = meal.strMeasure5;
        this.strMeasure6 = meal.strMeasure6;
        this.strMeasure7 = meal.strMeasure7;
        this.strMeasure8 = meal.strMeasure8;
        this.strMeasure9 = meal.strMeasure9;
        this.strMeasure10 = meal.strMeasure10;
        this.strMeasure11 = meal.strMeasure11;
        this.strMeasure12 = meal.strMeasure12;
        this.strMeasure13 = meal.strMeasure13;
        this.strMeasure14 = meal.strMeasure14;
        this.strMeasure15 = meal.strMeasure15;
        this.strMeasure16 = meal.strMeasure16;
        this.strMeasure17 = meal.strMeasure17;
        this.strMeasure18 = meal.strMeasure18;
        this.strMeasure19 = meal.strMeasure19;
        this.strMeasure20 = meal.strMeasure20;
        this.strSource = meal.strSource;
        this.strImageSource = meal.strImageSource;
        this.strCreativeCommonsConfirmed = meal.strCreativeCommonsConfirmed;
        this.dateModified = meal.dateModified;
        this.date = date;
    }

    public MealPlanDTO(String idMeal, String strMeal, String strDrinkAlternate, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20, String strSource, String strImageSource, String strCreativeCommonsConfirmed, String dateModified,String date) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
        this.strSource = strSource;
        this.strImageSource = strImageSource;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        this.dateModified = dateModified;
        this.date = date;
    }


    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        if (strIngredient1 != null && !strIngredient1.isEmpty()) ingredients.add(strIngredient1);
        if (strIngredient2 != null && !strIngredient2.isEmpty()) ingredients.add(strIngredient2);
        if (strIngredient3 != null && !strIngredient3.isEmpty()) ingredients.add(strIngredient3);
        if (strIngredient4 != null && !strIngredient4.isEmpty()) ingredients.add(strIngredient4);
        if (strIngredient5 != null && !strIngredient5.isEmpty()) ingredients.add(strIngredient5);
        if (strIngredient6 != null && !strIngredient6.isEmpty()) ingredients.add(strIngredient6);
        if (strIngredient7 != null && !strIngredient7.isEmpty()) ingredients.add(strIngredient7);
        if (strIngredient8 != null && !strIngredient8.isEmpty()) ingredients.add(strIngredient8);
        if (strIngredient9 != null && !strIngredient9.isEmpty()) ingredients.add(strIngredient9);
        if (strIngredient10 != null && !strIngredient10.isEmpty()) ingredients.add(strIngredient10);
        if (strIngredient11 != null && !strIngredient11.isEmpty()) ingredients.add(strIngredient11);
        if (strIngredient12 != null && !strIngredient12.isEmpty()) ingredients.add(strIngredient12);
        if (strIngredient13 != null && !strIngredient13.isEmpty()) ingredients.add(strIngredient13);
        if (strIngredient14 != null && !strIngredient14.isEmpty()) ingredients.add(strIngredient14);
        if (strIngredient15 != null && !strIngredient15.isEmpty()) ingredients.add(strIngredient15);
        if (strIngredient16 != null && !strIngredient16.isEmpty()) ingredients.add(strIngredient16);
        if (strIngredient17 != null && !strIngredient17.isEmpty()) ingredients.add(strIngredient17);
        if (strIngredient18 != null && !strIngredient18.isEmpty()) ingredients.add(strIngredient18);
        if (strIngredient19 != null && !strIngredient19.isEmpty()) ingredients.add(strIngredient19);
        if (strIngredient20 != null && !strIngredient20.isEmpty()) ingredients.add(strIngredient20);

        return ingredients;
    }

    public List<String> getMeasures() {
        List<String> measures = new ArrayList<>();
        if (strMeasure1 != null && !strMeasure1.isEmpty()) measures.add(strMeasure1);
        if (strMeasure2 != null && !strMeasure2.isEmpty()) measures.add(strMeasure2);
        if (strMeasure3 != null && !strMeasure3.isEmpty()) measures.add(strMeasure3);
        if (strMeasure4 != null && !strMeasure4.isEmpty()) measures.add(strMeasure4);
        if (strMeasure5 != null && !strMeasure5.isEmpty()) measures.add(strMeasure5);
        if (strMeasure6 != null && !strMeasure6.isEmpty()) measures.add(strMeasure6);
        if (strMeasure7 != null && !strMeasure7.isEmpty()) measures.add(strMeasure7);
        if (strMeasure8 != null && !strMeasure8.isEmpty()) measures.add(strMeasure8);
        if (strMeasure9 != null && !strMeasure9.isEmpty()) measures.add(strMeasure9);
        if (strMeasure10 != null && !strMeasure10.isEmpty()) measures.add(strMeasure10);
        if (strMeasure11 != null && !strMeasure11.isEmpty()) measures.add(strMeasure11);
        if (strMeasure12 != null && !strMeasure12.isEmpty()) measures.add(strMeasure12);
        if (strMeasure13 != null && !strMeasure13.isEmpty()) measures.add(strMeasure13);
        if (strMeasure14 != null && !strMeasure14.isEmpty()) measures.add(strMeasure14);
        if (strMeasure15 != null && !strMeasure15.isEmpty()) measures.add(strMeasure15);
        if (strMeasure16 != null && !strMeasure16.isEmpty()) measures.add(strMeasure16);
        if (strMeasure17 != null && !strMeasure17.isEmpty()) measures.add(strMeasure17);
        if (strMeasure18 != null && !strMeasure18.isEmpty()) measures.add(strMeasure18);
        if (strMeasure19 != null && !strMeasure19.isEmpty()) measures.add(strMeasure19);
        if (strMeasure20 != null && !strMeasure20.isEmpty()) measures.add(strMeasure20);

        return measures;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public void setStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public void setStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public void setStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public void setStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDateModified() {
        return dateModified;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }


    protected MealPlanDTO(Parcel in) {
        idMeal = in.readString();
        strMeal = in.readString();
        strDrinkAlternate = in.readString();
        strCategory = in.readString();
        strArea = in.readString();
        strInstructions = in.readString();
        strMealThumb = in.readString();
        strTags = in.readString();
        strYoutube = in.readString();
        strIngredient1 = in.readString();
        strIngredient2 = in.readString();
        strIngredient3 = in.readString();
        strIngredient4 = in.readString();
        strIngredient5 = in.readString();
        strIngredient6 = in.readString();
        strIngredient7 = in.readString();
        strIngredient8 = in.readString();
        strIngredient9 = in.readString();
        strIngredient10 = in.readString();
        strIngredient11 = in.readString();
        strIngredient12 = in.readString();
        strIngredient13 = in.readString();
        strIngredient14 = in.readString();
        strIngredient15 = in.readString();
        strIngredient16 = in.readString();
        strIngredient17 = in.readString();
        strIngredient18 = in.readString();
        strIngredient19 = in.readString();
        strIngredient20 = in.readString();
        strMeasure1 = in.readString();
        strMeasure2 = in.readString();
        strMeasure3 = in.readString();
        strMeasure4 = in.readString();
        strMeasure5 = in.readString();
        strMeasure6 = in.readString();
        strMeasure7 = in.readString();
        strMeasure8 = in.readString();
        strMeasure9 = in.readString();
        strMeasure10 = in.readString();
        strMeasure11 = in.readString();
        strMeasure12 = in.readString();
        strMeasure13 = in.readString();
        strMeasure14 = in.readString();
        strMeasure15 = in.readString();
        strMeasure16 = in.readString();
        strMeasure17 = in.readString();
        strMeasure18 = in.readString();
        strMeasure19 = in.readString();
        strMeasure20 = in.readString();
        strSource = in.readString();
        ;
        strImageSource = in.readString();
        ;
        strCreativeCommonsConfirmed = in.readString();
        ;
        dateModified = in.readString();
        ;
        date = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MealPlanDTO> CREATOR = new Creator<MealPlanDTO>() {
        @Override
        public MealPlanDTO createFromParcel(Parcel in) {
            return new MealPlanDTO(in);
        }

        @Override
        public MealPlanDTO[] newArray(int size) {
            return new MealPlanDTO[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(idMeal);
        parcel.writeString(strMeal);
        parcel.writeString(strDrinkAlternate);
        parcel.writeString(strCategory);
        parcel.writeString(strArea);
        parcel.writeString(strInstructions);
        parcel.writeString(strMealThumb);
        parcel.writeString(strTags);
        parcel.writeString(strYoutube);
        parcel.writeString(strIngredient1);
        parcel.writeString(strIngredient2);
        parcel.writeString(strIngredient3);
        parcel.writeString(strIngredient4);
        parcel.writeString(strIngredient5);
        parcel.writeString(strIngredient6);
        parcel.writeString(strIngredient7);
        parcel.writeString(strIngredient8);
        parcel.writeString(strIngredient9);
        parcel.writeString(strIngredient10);
        parcel.writeString(strIngredient11);
        parcel.writeString(strIngredient12);
        parcel.writeString(strIngredient13);
        parcel.writeString(strIngredient14);
        parcel.writeString(strIngredient15);
        parcel.writeString(strIngredient16);
        parcel.writeString(strIngredient17);
        parcel.writeString(strIngredient18);
        parcel.writeString(strIngredient19);
        parcel.writeString(strIngredient20);
        parcel.writeString(strMeasure1);
        parcel.writeString(strMeasure2);
        parcel.writeString(strMeasure3);
        parcel.writeString(strMeasure4);
        parcel.writeString(strMeasure5);
        parcel.writeString(strMeasure6);
        parcel.writeString(strMeasure7);
        parcel.writeString(strMeasure8);
        parcel.writeString(strMeasure9);
        parcel.writeString(strMeasure10);
        parcel.writeString(strMeasure11);
        parcel.writeString(strMeasure12);
        parcel.writeString(strMeasure13);
        parcel.writeString(strMeasure14);
        parcel.writeString(strMeasure15);
        parcel.writeString(strMeasure16);
        parcel.writeString(strMeasure17);
        parcel.writeString(strMeasure18);
        parcel.writeString(strMeasure19);
        parcel.writeString(strMeasure20);
        parcel.writeString(strSource);
        parcel.writeString(strImageSource);
        parcel.writeString(strCreativeCommonsConfirmed);
        parcel.writeString(dateModified);
        parcel.writeString(date);
    }
}
