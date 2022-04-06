package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class order extends AppCompatActivity {
    TableLayout tableLayout;
    TableRow tableRow;
    Button submit;
    float totalCost = 0;
    static ArrayList<FoodItem> orderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        if(!FoodItem.isConfirmed)
            orderDetails = (ArrayList<FoodItem>) getIntent().getSerializableExtra("foodItems");
        tableLayout = (TableLayout)findViewById(R.id.tbl_items);
        tableRow = (TableRow) View.inflate(this,R.layout.simple_table_row,null);
        submit = (Button) findViewById(R.id.btn_submit);
        tableLayout.addView(tableRow);
        for(FoodItem ivar:orderDetails){
            if(ivar.isItemSelected()){
                tableRow = (TableRow) View.inflate(this,R.layout.simple_table_row,null);
                TextView itemName = (TextView) tableRow.findViewById(R.id.tv_itemname);
                TextView itemPrice = (TextView) tableRow.findViewById(R.id.tv_itemcost);
                itemName.setText(ivar.getItemName());
                itemPrice.setText(String.valueOf(ivar.getItemCost()));
                totalCost += ivar.getItemCost();
                tableLayout.addView(tableRow);
            }
        }
        TextView totalCostTV = (TextView)findViewById(R.id.tv_totalCost);
        totalCostTV.setText("Net Total:"+ String.valueOf(totalCost));
        if(FoodItem.isConfirmed){
            submit.setText("Order Confirmed!");
            submit.setEnabled(false);
        }else{
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!FoodItem.isConfirmed){
                        FoodItem.isConfirmed = true;
                        Toast.makeText(getApplicationContext(),"Confirmed, Total Cost:"+totalCost,Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}