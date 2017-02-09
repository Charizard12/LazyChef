package project.lazychef.alicm.lazychef;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alicm on 06/02/2017.
 */

public class RecipeParameters implements Parcelable {
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

    protected RecipeParameters(Parcel in) {
        /*difficult = in.readInt();
        cookingTime = in.readInt();
        bake = in.readByte() != 0;*/
        selectedIngredients = new ArrayList<>();
        readFromParcel(in);
    }

    public static final Creator<RecipeParameters> CREATOR = new Creator<RecipeParameters>() {
        @Override
        public RecipeParameters createFromParcel(Parcel in) {
            return new RecipeParameters(in);
        }

        @Override
        public RecipeParameters[] newArray(int size) {
            return new RecipeParameters[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(difficult);
        dest.writeInt(cookingTime);
        dest.writeBooleanArray(new boolean[]{bake});
        dest.writeList(selectedIngredients);
    }

    private void readFromParcel(Parcel in){
        difficult = in.readInt();
        cookingTime = in.readInt();
        boolean[] temp =  new boolean[1];
        in.readBooleanArray(temp);
        bake = temp[0];
        in.readList(selectedIngredients, null);
    }
}
