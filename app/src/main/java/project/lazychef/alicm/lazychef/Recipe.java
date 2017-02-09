package project.lazychef.alicm.lazychef;

import java.util.List;

/**
 * Created by alicm on 08/02/2017.
 */

public class Recipe {
    int recipeId;
    String name;
    List<Integer> ingredientsId;
    List<String> faltantes;
    int difficult;
    int cookTime;
    boolean baked;
    int imageResource;

    public Recipe(String name, List<String> faltantes, int difficult, int cookTime, boolean baked, int imageResource) {
        this.name = name;
        this.faltantes = faltantes;
        this.difficult = difficult;
        this.cookTime = cookTime;
        this.baked = baked;
        this.imageResource = imageResource;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(List<Integer> ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    public List<String> getFaltantes() {
        return faltantes;
    }

    public void setFaltantes(List<String> faltantes) {
        this.faltantes = faltantes;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public boolean isBaked() {
        return baked;
    }

    public void setBaked(boolean baked) {
        this.baked = baked;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
