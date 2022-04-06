package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
        TextView foodQuantity = (TextView) view.findViewById(R.id.tv_quantity);
        ImageView foodImage = (ImageView) view.findViewById(R.id.iv_foodPic);
        Button increment = (Button) view.findViewById(R.id.btn_increment);
        Button decrement = (Button) view.findViewById(R.id.btn_decrement);
        foodName.setText(currentItem.getItemName());
        foodCost.setText(String.valueOf(currentItem.getItemCost()));
        foodImage.setImageResource(currentItem.getItemImage());
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodItemsList.get(i).incrementQuantity();
                foodQuantity.setText(String.valueOf(currentItem.getItemQuantity()));
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodItemsList.get(i).decrementQuantity();
                foodQuantity.setText(String.valueOf(currentItem.getItemQuantity()));
            }
        });
        return view;
    }
}
