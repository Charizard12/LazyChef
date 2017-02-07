package project.lazychef.alicm.lazychef;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alicm on 26/01/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<ListGrpHeader> listGrpHeaders;
    private HashMap<String, List<Ingredient>> listHashMap;
    private boolean[][] booleans;
    //adaptador
    public ExpandableListAdapter (Context context, HashMap<String, List<Ingredient>> listHashMap, List<ListGrpHeader> listGrpHeaders){
        this.context = context;
        this.listHashMap = listHashMap;
        this.listGrpHeaders = listGrpHeaders;
        booleans = new boolean[listGrpHeaders.size()][1000];
    }

    @Override   //se crearan las agrupaciones.
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        ListGrpHeader header = (ListGrpHeader) getGroup(groupPosition);
        if(view == null){   //si la view es nula entonces infla
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listgroup_header,null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.listgroupHeaderTv);
        lblListHeader.setTypeface(null, Typeface.BOLD); //negritas
        lblListHeader.setText(header.getTitle());
        ImageView imageView = (ImageView)view.findViewById(R.id.listgroupHeaderIcon);
        imageView.setImageResource(header.getImageResource());
        return view;
    }

    @Override //se agregan los ingredientes
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.ingredient_item,null);
        }
        final Ingredient currentIngredient = (Ingredient) getChild(groupPosition, childPosition);
        TextView ingtv = (TextView)view.findViewById(R.id.ingredientItemTv);
        ingtv.setText(currentIngredient.getIngredientName());

        ImageView imgvw = (ImageView)view.findViewById(R.id.ingredientImg);
        imgvw.setImageResource(currentIngredient.getImageResource());

        final CheckBox ingcb = (CheckBox)view.findViewById(R.id.ingredientCB);
        ingcb.setChecked(booleans[groupPosition][childPosition]);   //ayuda para que no ponga checados los que no son
        ingcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIngredient.isChecked()){
                    currentIngredient.setChecked(false);
                    booleans[groupPosition][childPosition] = false;
                    ingcb.setChecked(false);
                }
                else {
                    currentIngredient.setChecked(true);
                    booleans[groupPosition][childPosition] = true;
                    ingcb.setChecked(true);
                }
            }
        });
        return view;
    }

    @Override
    public int getGroupCount() {
        return listGrpHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listGrpHeaders.get(groupPosition).getTitle()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGrpHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listGrpHeaders.get(groupPosition).getTitle()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}

    /*private static class IngredientHolder{
        public TextView ingredientName;
        public CheckBox ingredientCheckBox;
    }*/

/*
    @Override //se agregan los ingredientes
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        IngredientHolder holder = null;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.ingredient_item,null);
            /*holder = new IngredientHolder();
            holder.ingredientName = (TextView) view.findViewById(R.id.ingredientItemTv);
            holder.ingredientCheckBox = (CheckBox) view.findViewById(R.id.ingredientCB);
            holder.ingredientCheckBox.setOnCheckedChangeListener((MainActivity) context);
            view.setTag(holder);*/
        /*}
        else{*/
            //holder = (IngredientHolder) view.getTag();
       // }
        //final Ingredient currentIngredient = (Ingredient) getChild(groupPosition, childPosition);
        /*holder.ingredientName.setText(currentIngredient.getIngredientName());
        holder.ingredientCheckBox.setChecked(currentIngredient.isChecked());
        holder.ingredientCheckBox.setTag(currentIngredient);
        view.setTag(holder);*/

      /*  TextView ingtv = (TextView)view.findViewById(R.id.ingredientItemTv);
        ingtv.setText(currentIngredient.getIngredientName());

        ImageView imgvw = (ImageView)view.findViewById(R.id.ingredientImg);
        imgvw.setImageResource(currentIngredient.getImageResource());

        final CheckBox ingcb = (CheckBox)view.findViewById(R.id.ingredientCB);
        ingcb.setChecked(booleans[groupPosition][childPosition]);
        //ingcb.setChecked(currentIngredient.isChecked());
        /*ingcb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, currentIngredient.getIngredientName()
                        + " child ID: " + getChildId(groupPosition,childPosition)
                        + " parent ID: " + getGroupId(groupPosition), Toast.LENGTH_SHORT).show();
            }
        });*/
        /*ingcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIngredient.isChecked()){
                    currentIngredient.setChecked(false);
                    booleans[groupPosition][childPosition] = false;
                    ingcb.setChecked(false);
                }
                else {
                    currentIngredient.setChecked(true);
                    booleans[groupPosition][childPosition] = true;
                    ingcb.setChecked(true);
                }
            }
        });
        return view;
    }
*/



