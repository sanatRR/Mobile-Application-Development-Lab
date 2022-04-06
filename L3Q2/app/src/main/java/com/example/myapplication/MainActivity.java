package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    FloatingActionButton fabOrder;
    static String orderText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<FoodItem> foodList = new ArrayList<>();
        foodList.add(new FoodItem("Bread",R.mipmap.bread,100));
        foodList.add(new FoodItem("Meat",R.mipmap.meat,10));
        foodList.add(new FoodItem("pasta",R.mipmap.pasta,200));
        foodList.add(new FoodItem("Oil",R.mipmap.oil,300));
        foodList.add(new FoodItem("Cereal",R.mipmap.cereal,400));
        foodList.add(new FoodItem("Soup",R.mipmap.soup,500));
        foodList.add(new FoodItem("ice cream",R.mipmap.icecream,600));
        foodList.add(new FoodItem("pizza",R.mipmap.pizza,700));
        foodList.add(new FoodItem("honey",R.mipmap.honey,800));
        CustomAdapter c1 = new CustomAdapter(foodList,this);
        mListView = (ListView) findViewById(R.id.lv_groceryItems);
        fabOrder = (FloatingActionButton) findViewById(R.id.btn_placeOrder);
        fabOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),order.class).putExtra("foodItems",foodList));
            }
        });
        mListView.setAdapter(c1);

    }
}