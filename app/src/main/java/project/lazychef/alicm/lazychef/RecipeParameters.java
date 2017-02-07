package project.lazychef.alicm.lazychef;

import java.util.List;

/**
 * Created by alicm on 06/02/2017.
 */

public class RecipeParameters {
    List<Integer> selectedIngredients;
    int difficult;
    int cookingTime;
    boolean bake;

    public RecipeParameters(List<Integer> selectedIngredients, int difficult, int cookingTime, boolean bake) {
        this.selectedIngredients = selectedIngredients;
        this.difficult = difficult;
        this.cookingTime = cookingTime;
        this.bake = bake;
    }

    public List<Integer> getSelectedIngredients() {
        return selectedIngredients;
    }

    public void setSelectedIngredients(List<Integer> selectedIngredients) {
        this.selectedIngredients = selectedIngredients;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isBake() {
        return bake;
    }

    public void setBake(boolean bake) {
        this.bake = bake;
    }
}
