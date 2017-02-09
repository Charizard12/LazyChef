package project.lazychef.alicm.lazychef;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alicm on 08/02/2017.
 */

public class RecipeListAdapter extends ArrayAdapter<Recipe> {
    Context context;

    public RecipeListAdapter(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
        this.context = context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.recipe_card, null);
            /*ImageView baked = (ImageView)view.findViewById(R.id.bakeIcon);
            baked.setImageResource(0);*/
        }

        Recipe currentRecipe = getItem(position);
        Recipe first = getItem(0);

        ImageView recipeImage = (ImageView) view.findViewById(R.id.recipeCImage);
        recipeImage.setImageResource(currentRecipe.getImageResource());
        //nombre de la receta
        TextView recipeName = (TextView) view.findViewById(R.id.recipeCNameTv);
        recipeName.setText(currentRecipe.getName());
        //ingredientes necesarios
        TextView scrollabletv = (TextView)view.findViewById(R.id.necesitasTv);
        scrollabletv.setMovementMethod(new ScrollingMovementMethod());
        scrollabletv.setText(Arrays.toString(currentRecipe.getFaltantes().toArray()));
        //icono de dificultad
        ImageView difficultIcon = (ImageView)view.findViewById(R.id.difficultIcon);
        switch (currentRecipe.getDifficult()){
            case 0:
                difficultIcon.setImageResource(R.drawable.difficult_icon_0);
                break;
            case 1:
                difficultIcon.setImageResource(R.drawable.difficult_icon_1);
                break;
            case 2:
                difficultIcon.setImageResource(R.drawable.difficult_icon_2);
                break;
        }
        //icono de horno
        ImageView bakeIcon = (ImageView) view.findViewById(R.id.bakeIcon);
        if(currentRecipe.isBaked()){
            bakeIcon.setImageResource(R.drawable.bake_icon);
        }else
            bakeIcon.setImageResource(0);

        return view;
    }
}
