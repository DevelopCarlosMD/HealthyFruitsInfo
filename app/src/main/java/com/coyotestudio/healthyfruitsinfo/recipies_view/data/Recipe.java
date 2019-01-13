package com.coyotestudio.healthyfruitsinfo.recipies_view.data;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 1/29/18.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */

public class Recipe {

    private int image;
    private String titleReipe;
    private String subTitleRecipe;
    /*private String introInfo;
    private String ingredients;
    private String makeSteps;*/


    public Recipe(int image, String titleReipe, String subTitleRecipe) {
        this.image = image;
        this.titleReipe = titleReipe;
        this.subTitleRecipe = subTitleRecipe;
    }

    public int getImage() {
        return image;
    }

    public String getTitleReipe() {
        return titleReipe;
    }

    public String getSubTitleRecipe() {
        return subTitleRecipe;
    }
}
