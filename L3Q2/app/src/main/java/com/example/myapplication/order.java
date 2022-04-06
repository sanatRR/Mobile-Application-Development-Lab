package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class order extends AppCompatActivity {
    TableLayout tableLayout;
    TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ArrayList<FoodItem> orderDetails = (ArrayList<FoodItem>) getIntent().getSerializableExtra("foodItems");
        tableLayout = (TableLayout)findViewById(R.id.tbl_items);
        tableRow = (TableRow) View.inflate(this,R.layout.simple_table_row,null);
        tableLayout.addView(tableRow);
        float totalCost = 0;
        for(FoodItem ivar:orderDetails){
            if(ivar.getItemQuantity()>0){
                tableRow = (TableRow) View.inflate(this,R.layout.simple_table_row,null);
                TextView itemName = (TextView) tableRow.findViewById(R.id.tv_itemname);
                TextView itemQuantity = (TextView) tableRow.findViewById(R.id.tv_quantity);
                TextView itemPrice = (TextView) tableRow.findViewById(R.id.tv_itemcost);
                TextView totalPrice = (TextView) tableRow.findViewById(R.id.tv_itemtotalprice);
                itemName.setText(ivar.getItemName());
                itemQuantity.setText(String.valueOf(ivar.getItemQuantity()));
                itemPrice.setText(String.valueOf(ivar.getItemCost()));
                totalPrice.setText(String.valueOf(ivar.getItemCost()*ivar.getItemQuantity()));
                totalCost += ivar.getItemCost()*ivar.getItemQuantity();
                tableLayout.addView(tableRow);
            }
        }
        TextView totalCostTV = (TextView)findViewById(R.id.tv_totalCost);
        totalCostTV.setText("Net Total:"+ String.valueOf(totalCost));
    }
}