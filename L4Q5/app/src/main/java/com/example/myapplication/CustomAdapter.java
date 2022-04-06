package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<FoodItem> foodItemsList;
    Context mContext;

    public CustomAdapter(ArrayList<FoodItem> foodItemsList,Context context){
        this.foodItemsList = foodItemsList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return foodItemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodItemsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FoodItem currentItem = foodItemsList.get(i);
        if(view==null){
            view = View.inflate(mContext,R.layout.simple_food_list,null);
        }
        TextView foodName = (TextView) view.findViewById(R.id.tv_foodName);
        TextView foodCost = (TextView) view.findViewById(R.id.tv_cost);
        ImageView foodImage = (ImageView) view.findViewById(R.id.iv_foodPic);
        foodName.setText(currentItem.getItemName());
        foodCost.setText(String.valueOf(currentItem.getItemCost()));
        foodImage.setImageResource(currentItem.getItemImage());
        CheckBox selected = view.findViewById(R.id.cb_selected);
        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected.isChecked()){
                    currentItem.selectItem();
                }else {
                    currentItem.unSelectItem();
                }
            }
        });

        return view;
    }
}
