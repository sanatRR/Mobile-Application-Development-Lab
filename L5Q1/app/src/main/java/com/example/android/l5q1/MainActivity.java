package com.example.android.l5q1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    String vehicleType,vehicleNumber,RCNumber;
    EditText vehicleNumberField,rcNumberField;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vehicleNumberField = ((EditText)findViewById(R.id.et_vehiclenumber));
        rcNumberField = (EditText)findViewById(R.id.et_rcnumber);
        Spinner spinner = (Spinner)findViewById(R.id.spinner_vehicletype);
        submit = (Button)findViewById(R.id.btn_submit);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.vehicle_type, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vehicleType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //pass
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vehicleNumber = vehicleNumberField.getText().toString();
                RCNumber = rcNumberField.getText().toString();
                if(vehicleNumber.length()<1 || RCNumber.length()<1){
                    Toast.makeText(getApplicationContext(),"Enter Details!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent confirmWindow = new Intent(getApplicationContext(),DetailsActivity.class);
                confirmWindow.putExtra("vehicleType",vehicleType);
                confirmWindow.putExtra("vehicleNumber",vehicleNumber);
                confirmWindow.putExtra("rcNumber",RCNumber);
                startActivity(confirmWindow);
            }
        });


    }
}