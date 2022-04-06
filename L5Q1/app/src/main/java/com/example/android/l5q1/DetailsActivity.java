package com.example.android.l5q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {
    Button confirm,edit;
    TextView vehicleType,rcNumber,vehicleNumber;
    static int serialNum;
    static HashMap<String,Integer> parkingSlots;
    static{
        serialNum = 0;
        parkingSlots = new HashMap<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i1 =getIntent();
        vehicleType = (TextView)findViewById(R.id.tv_vehicletype);
        vehicleNumber = (TextView)findViewById(R.id.tv_vehicleNumber);
        rcNumber = (TextView)findViewById(R.id.tv_rcNumber);
        vehicleType.setText(i1.getStringExtra("vehicleType"));
        vehicleNumber.setText(i1.getStringExtra("vehicleNumber"));
        rcNumber.setText(i1.getStringExtra("rcNumber"));
        confirm = (Button)findViewById(R.id.btn_confirm);
        edit = (Button)findViewById(R.id.btn_edit);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vehicleNumber = i1.getStringExtra("vehicleType");
                vehicleNumber.trim();
                String rcNumber = i1.getStringExtra("rcNumber");
                rcNumber.trim();
                String key = vehicleNumber+" "+rcNumber;
                if(parkingSlots.containsKey(key)){
                    Toast.makeText(getApplicationContext(),"SerialNum"+parkingSlots.get(key)+" parking allotted",Toast.LENGTH_LONG).show();
                }else{
                    parkingSlots.put(key,++serialNum);
                    Toast.makeText(getApplicationContext(),"SerialNum"+parkingSlots.get(key)+" parking allotted",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}