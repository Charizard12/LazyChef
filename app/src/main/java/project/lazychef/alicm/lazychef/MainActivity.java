package project.lazychef.alicm.lazychef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listHeaders;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableLv);
        initData();
        expandableListAdapter = new ExpandableListAdapter(this, listHeaders, listHashMap);
        expandableListView.setAdapter(expandableListAdapter);

    }

    private void initData(){
        listHeaders = new ArrayList<>();
        listHashMap = new HashMap<>();

        listHeaders.add("Carnes");
        listHeaders.add("Frutas");
        listHeaders.add("Verduras");
        listHeaders.add("Quesos");

        List<String> carnes = new ArrayList<>();
        carnes.add("bistek");
        carnes.add("cecina");
        carnes.add("costilla");
        carnes.add("cecina");

        List<String> frutas = new ArrayList<>();
        frutas.add("platano");
        frutas.add("fresa");
        frutas.add("manzana");
        frutas.add("papaya");

        List<String> verduras = new ArrayList<>();
        verduras.add("pepino");
        verduras.add("zanahoria");
        verduras.add("calabaza");
        verduras.add("elote");

        List<String> quesos = new ArrayList<>();
        quesos.add("oaxaca");
        quesos.add("panela");
        quesos.add("manchego");
        quesos.add("amarillo");

        listHashMap.put(listHeaders.get(0), carnes);
        listHashMap.put(listHeaders.get(1), frutas);
        listHashMap.put(listHeaders.get(2), verduras);
        listHashMap.put(listHeaders.get(3), quesos);

    }

}
