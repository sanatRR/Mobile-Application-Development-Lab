package com.example.android.l3q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        String list[] = {"Toyota","Volkswagen","Ford","Honda","General Motors","BMW","SAIC","FAW Group","Hyundai","Nissan","KIA","Volvo","Suzuki"};
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.simple_list_view,list);
        ListView listView = (ListView) findViewById(R.id.lv_companyNames);
        listView.setAdapter(adapter);
        
    }
}