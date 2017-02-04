package project.lazychef.alicm.lazychef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listHeaders;
    private HashMap<String, List<Ingredient>> ingredientMap = null;
    private List<String> selectedIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableLv);
        initData();
        expandableListAdapter = new ExpandableListAdapter(this, listHeaders, ingredientMap);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void initData(){
        listHeaders = new ArrayList<>();
        ingredientMap = new HashMap<>();

        listHeaders.add("Carnes");
        listHeaders.add("Frutas");
        listHeaders.add("Verduras");
        listHeaders.add("Quesos");

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

        ingredientMap.put(listHeaders.get(0), carnes);
        ingredientMap.put(listHeaders.get(1), frutas);
        ingredientMap.put(listHeaders.get(2), verduras);
        ingredientMap.put(listHeaders.get(3), quesos);



    }

    public void continuar(View v){
        if(ingredientMap != null){
            selectedIngredients = new ArrayList<>();
            for(Map.Entry<String, List<Ingredient>> entry : ingredientMap.entrySet()){
                String key =  entry.getKey();
                List<Ingredient> ing = entry.getValue();
                getSelectedIngredients(ing);
                System.out.println(key);
            }
            if(selectedIngredients.isEmpty()){
                System.out.println("no has seleccionado ingredientes");
                Toast.makeText(MainActivity.this, "No has seleccionado ingredientes", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(MainActivity.this, Arrays.toString(selectedIngredients.toArray()) + "Seleccionados", Toast.LENGTH_SHORT).show();
            System.out.println(Arrays.toString(selectedIngredients.toArray()));
        }
    }

    public void getSelectedIngredients(List<Ingredient> selectedOnes){
        for(Ingredient ingredientes : selectedOnes){
            if(ingredientes.isChecked()){
                String ingredientName = ingredientes.getIngredientName();
                selectedIngredients.add(ingredientName);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

       /* int pos = (int) expandableListView.getSelectedPosition();*/

    }
}
