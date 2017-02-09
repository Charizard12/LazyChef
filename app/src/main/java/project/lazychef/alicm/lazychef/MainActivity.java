package project.lazychef.alicm.lazychef;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private HashMap<String, List<Ingredient>> ingredientMap = null;
    private List<Integer> selectedIngredients;
    private List<ListGrpHeader> listGrpHeader;
    private RecipeParameters recipeParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableLv);
        initData(); //iniciar datos
        //se envia al adaptador el mapa de los ingredientes y la lista de Headers
        expandableListAdapter = new ExpandableListAdapter(this, ingredientMap, listGrpHeader);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void initData(){
        ingredientMap = new HashMap<>();    //Mapa: <Nombre del grupo, lista de objetos
        listGrpHeader = new ArrayList<>();  //lista de los Headers
                                            //Header:: nombre e icono
        listGrpHeader.add(new ListGrpHeader("Carnes", R.drawable.meat_icon));
        listGrpHeader.add(new ListGrpHeader("Frutas", R.drawable.fruit_icon));
        listGrpHeader.add(new ListGrpHeader("Verduras", R.drawable.vegetables_icon));
        listGrpHeader.add(new ListGrpHeader("Quesos", R.drawable.cheese_icon));

        //---------Ingrediente:: icono, nombre y Id-------------------------
        List<Ingredient> carnes = new ArrayList<>();
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "bistek", 0));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "cecina", 1));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "costilla", 2));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "chuleta", 3));

        List<Ingredient> frutas = new ArrayList<>();
        frutas.add(new Ingredient(R.drawable.banana, "platano", 4));
        frutas.add(new Ingredient(R.drawable.strawberry, "fresa", 5));
        frutas.add(new Ingredient(R.drawable.apple, "manzana", 6));
        frutas.add(new Ingredient(R.drawable.papaia, "papaya", 7));

        List<Ingredient> verduras = new ArrayList<>();
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "pepino", 8));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "zanahoria", 9));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "lechuga", 10));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "espinaca", 11));

        List<Ingredient> quesos = new ArrayList<>();
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "oaxaca", 12));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "panela", 13));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "manchego", 14));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "amarillo", 15));
        //---------------Listas de ingredientes----------------------------

        //------------------titulo del header, lista de ingredientes-------
        ingredientMap.put(listGrpHeader.get(0).getTitle(), carnes);
        ingredientMap.put(listGrpHeader.get(1).getTitle(), frutas);
        ingredientMap.put(listGrpHeader.get(2).getTitle(), verduras);
        ingredientMap.put(listGrpHeader.get(3).getTitle(), quesos);
        //------------datos cargados---------------------------------------
    }

    public void continuar(View v){
        if(ingredientMap != null){  //--checamos que el mapa este lleno
            selectedIngredients = new ArrayList<>();  //---------lista de ingredientes seleccionados
            //cada que se pulsa el boton se crea una nueva lista
            //recorremos el mapa
            for(Map.Entry<String, List<Ingredient>> entry : ingredientMap.entrySet()){
                String key =  entry.getKey(); //se obtiene el valor de la llave, el nombre del grupo
                List<Ingredient> ingredientGroup = entry.getValue(); //se obtiene la lista de ingredientes
                getSelectedIngredients(ingredientGroup);    //obtenemos los ingredientes seleccionados.
            }

            //si la lista de ingredientes seleccionados esta vacia
            if(selectedIngredients.isEmpty()){
                Toast.makeText(MainActivity.this, "No has seleccionado ingredientes", Toast.LENGTH_SHORT).show();
            }
            //si tenemos ingredientes seleccionados
            else {
                //---Se creara el dialogo de opciones
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.options_dialog, null);
                //Llamamos a los objetos del dialogo
                final Spinner difficultSpinner = (Spinner) mView.findViewById(R.id.difficultSpinner);
                final Spinner timeSpinner = (Spinner) mView.findViewById(R.id.timeSpinner);
                final Switch hornazo = (Switch)mView.findViewById(R.id.hornazo);
                //Agregamos la vista al constructor
                mBuilder.setView(mView);
                //funcionalidad del boton positivo
                mBuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*Toast.makeText(MainActivity.this,
                                " Dificultad: " + String.valueOf(difficultSpinner.getSelectedItemPosition())
                                        + " Tiempo: " + String.valueOf(timeSpinner.getSelectedItemPosition())
                                        + " Horno: " + String.valueOf(hornazo.isChecked())
                                , Toast.LENGTH_SHORT).show();*/
                        //--guardado de parametros
                        int dificultad = difficultSpinner.getSelectedItemPosition();
                        int preptime = timeSpinner.getSelectedItemPosition();
                        boolean hornear = hornazo.isChecked();
                        recipeParameters = new RecipeParameters(selectedIngredients,dificultad,preptime,hornear);

                        Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
                        intent.putExtra("Parametros", recipeParameters);
                        startActivity(intent);

                    }
                });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        }
    }

    //--obtener los ingredientes seleccionados
    public void getSelectedIngredients(List<Ingredient> ingredientGroup){
        for(Ingredient ing : ingredientGroup){
            if(ing.isChecked()){   //si el ingrediente esta seleccionado
                int ingredientId = ing.getId(); //obtenemos su id
                selectedIngredients.add(ingredientId);  //guardamos el id
            }
        }
    }

}
