package project.lazychef.alicm.lazychef;

/**
 * Created by alicm on 28/01/2017.
 */

public class Ingredient {

    int id;
    int imageResource;
    String ingredientName;
    boolean checked = false;

    public Ingredient(int imageResource, String ingredientName, int id) {
        this.imageResource = imageResource;
        this.ingredientName = ingredientName;
        this.id = id;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
