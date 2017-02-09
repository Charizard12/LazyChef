package project.lazychef.alicm.lazychef;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    private ListView recipeListView;
    private RecipeListAdapter recipeListAdapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        //----------Recibimos los parametros para la preparacion de la receta
        RecipeParameters recipeParameters = getIntent().getParcelableExtra("Parametros");
        Log.i("parametro", String.valueOf(recipeParameters.difficult));

        List<String> faltantes = new ArrayList<>();
        faltantes.add("Harina");
        faltantes.add("Huevo");
        faltantes.add("Leche");

        int imageResource = 0;
        imageResource = R.drawable.bananacakes;
        //de momento le paso los parametros de busqueda, la idea es que se saquen los datos de la BD
        Recipe bestRecipe = new Recipe("Hot Cakes", faltantes, recipeParameters.difficult,
                25, recipeParameters.bake, imageResource);
        bestResult(bestRecipe);

        recipeListView = (ListView) findViewById(R.id.recipeListView);
        someData();
        recipeListAdapter = new RecipeListAdapter(this,recipeList);
        recipeListView.setAdapter(recipeListAdapter);


    }

    private void bestResult(Recipe bestRecipe){
        //rellenaremos la tarjeta con el mejor resultado dentro del layout best_result
        LinearLayout parent = (LinearLayout) findViewById(R.id.best_result);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardview = inflater.inflate(R.layout.recipe_card, null);
        //creamos una nueva vista de la tarjeta de receta

        //Carga de la imagen principal
        ImageView recipeImage = (ImageView) cardview.findViewById(R.id.recipeCImage);
        recipeImage.setImageResource(bestRecipe.getImageResource());
        //nombre de la receta
        TextView recipeName = (TextView) cardview.findViewById(R.id.recipeCNameTv);
        recipeName.setText(bestRecipe.getName());
        //ingredientes necesarios
        TextView scrollabletv = (TextView)cardview.findViewById(R.id.necesitasTv);
        scrollabletv.setMovementMethod(new ScrollingMovementMethod());
        scrollabletv.setText(Arrays.toString(bestRecipe.getFaltantes().toArray()));

        TextView timetv = (TextView) cardview.findViewById(R.id.timeTextView);
        timetv.setText(bestRecipe.getCookTime() + " min");
        //icono de dificultad
        ImageView difficultIcon = (ImageView)cardview.findViewById(R.id.difficultIcon);
        switch (bestRecipe.getDifficult()){
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
        ImageView bakeIcon = (ImageView) cardview.findViewById(R.id.bakeIcon);
        if(bestRecipe.isBaked()){
            bakeIcon.setImageResource(R.drawable.bake_icon);
        }
        else
            bakeIcon = null;

        //se carga la vista recien echa
        parent.addView(cardview);
    }

    private void someData(){
        recipeList = new ArrayList<>();

        List<String> faltantes = new ArrayList<>();
        faltantes.add("Pan");
        faltantes.add("Lechuga");
                        //--Receta: nombre, lista de faltantes, dificultad, tiempo, horno, imagen
        recipeList.add(new Recipe("Sandwich", faltantes, 0, 10, false, R.drawable.sandwich));

        List<String> faltantes2 = new ArrayList<>();
        faltantes2.add("Milanesa");
        faltantes2.add("Tortilla");
        faltantes2.add("Salsa");
        recipeList.add(new Recipe("Burrito", faltantes2, 1, 25, false, R.drawable.burritos));

        List<String> faltantes3 = new ArrayList<>();
        faltantes3.add("Huevo");
        faltantes3.add("Champiñones");
        recipeList.add(new Recipe("Omelette", faltantes3, 2, 30, false, R.drawable.omelette));

        List<String> faltantes4 = new ArrayList<>();
        faltantes4.add("Papa");
        faltantes4.add("Cebolla");
        faltantes4.add("Manchego");
        faltantes4.add("Albahaca");
        faltantes4.add("Perejil");
        faltantes4.add("Jamón");
        faltantes4.add("Pimiento");
        faltantes4.add("Atún");
        faltantes4.add("Pimiento");
        faltantes4.add("Aceite de Oliva");
        faltantes4.add("Pimienta");
        faltantes4.add("Oregano");
        faltantes4.add("Papel Aluminio");

        recipeList.add(new Recipe("Papa al horno", faltantes4, 2, 100, true, R.drawable.baked_potato));

        List<String> faltantes5 = new ArrayList<>();
        faltantes5.add("Atun");
        faltantes5.add("Brocoli");
        faltantes5.add("Zanahoria");
        recipeList.add(new Recipe("Ensalada de atún", faltantes5, 0, 15, false, R.drawable.atun));

        List<String> faltantes6 = new ArrayList<>();
        faltantes6.add("Ajo");
        faltantes6.add("Mozarella");
        recipeList.add(new Recipe("Pan de ajo con queso", faltantes6, 0, 60, true, R.drawable.pan_ajo));

    }
}
