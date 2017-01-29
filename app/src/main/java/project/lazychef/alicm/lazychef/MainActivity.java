package project.lazychef.alicm.lazychef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listHeaders;
    private HashMap<String, List<Ingredient>> ingredientMap;

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
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "bistek"));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "cecina"));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "costilla"));
        carnes.add(new Ingredient(R.mipmap.ic_launcher, "chuleta"));

        List<Ingredient> frutas = new ArrayList<>();
        frutas.add(new Ingredient(R.mipmap.ic_launcher, "platano"));
        frutas.add(new Ingredient(R.mipmap.ic_launcher, "fresa"));
        frutas.add(new Ingredient(R.mipmap.ic_launcher, "manzana"));
        frutas.add(new Ingredient(R.mipmap.ic_launcher, "papaya"));

        List<Ingredient> verduras = new ArrayList<>();
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "pepino"));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "zanahoria"));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "lechuga"));
        verduras.add(new Ingredient(R.mipmap.ic_launcher, "espinaca"));

        List<Ingredient> quesos = new ArrayList<>();
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "oaxaca"));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "panela"));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "manchego"));
        quesos.add(new Ingredient(R.mipmap.ic_launcher, "amarillo"));

        ingredientMap.put(listHeaders.get(0), carnes);
        ingredientMap.put(listHeaders.get(1), frutas);
        ingredientMap.put(listHeaders.get(2), verduras);
        ingredientMap.put(listHeaders.get(3), quesos);



    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

       /* int pos = (int) expandableListView.getSelectedPosition();*/

    }
}
