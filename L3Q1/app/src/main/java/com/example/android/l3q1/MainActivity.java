package com.example.android.l3q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView listViewTV,gridViewTV,tabLayoutTV,tableLayoutTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTV = (TextView)findViewById(R.id.tv_listView);
        gridViewTV = (TextView)findViewById(R.id.tv_gridView);
        tabLayoutTV = (TextView)findViewById(R.id.tv_tabLayout);
        tableLayoutTV = (TextView)findViewById(R.id.tv_tableLayout);
        listViewTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ListViewDemo.class));
            }
        });

        gridViewTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GridViewDemo.class));
            }
        });

        tabLayoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TabLayoutDemo.class));
            }
        });

        tableLayoutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TableLayoutDemo.class));
            }
        });

    }
}