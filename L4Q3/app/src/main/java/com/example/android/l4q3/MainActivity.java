package com.example.android.l4q3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<AndroidVersions> androidVersionsArrayList = new ArrayList<AndroidVersions>();
        androidVersionsArrayList.add(new AndroidVersions("Cupcake",1.5,R.mipmap.cupcake));
        androidVersionsArrayList.add(new AndroidVersions("Donut",1.6,R.mipmap.donut));
        androidVersionsArrayList.add(new AndroidVersions("Eclair",2.0,R.mipmap.eclair));
        androidVersionsArrayList.add(new AndroidVersions("Froyo",2.2,R.mipmap.froyo));
        androidVersionsArrayList.add(new AndroidVersions("Gingerbread",2.3,R.mipmap.gingerbread));
        androidVersionsArrayList.add(new AndroidVersions("Honeycomb",3.0,R.mipmap.honeycomb));
        androidVersionsArrayList.add(new AndroidVersions("Ice Cream Sandwich",4.0,R.mipmap.icecreamsandwich));
        androidVersionsArrayList.add(new AndroidVersions("Jelly Bean",4.1,R.mipmap.jellybean));
        androidVersionsArrayList.add(new AndroidVersions("Kitkat",5.0,R.mipmap.jellybean));
        androidVersionsArrayList.add(new AndroidVersions("Lollipop",5.1,R.mipmap.lolipop));
        androidVersionsArrayList.add(new AndroidVersions("Marshmallow",6.0,R.mipmap.marshmallow));
        androidVersionsArrayList.add(new AndroidVersions("Nougat",7.0,R.mipmap.nougat));
        androidVersionsArrayList.add(new AndroidVersions("Oreo",8.0,R.mipmap.oreo));
        androidVersionsArrayList.add(new AndroidVersions("Pie",9.0,R.mipmap.pie));
        ListView lV = (ListView) findViewById(R.id.lv_buttons);
        CustomAdapter cA = new CustomAdapter(this,androidVersionsArrayList);
        lV.setAdapter(cA);
    }




}

