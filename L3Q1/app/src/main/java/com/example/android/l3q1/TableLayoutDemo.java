package com.example.android.l3q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TableLayoutDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout_demo);
        TableLayout tableLayout = findViewById(R.id.tbl_details);
        ArrayList<Orgs> orgsArrayList = new ArrayList<>();
        orgsArrayList.add(new Orgs("Saudi Armaco",330.3,7.5));
        orgsArrayList.add(new Orgs("PetroChina",13.0,95.8));
        orgsArrayList.add(new Orgs("Exxon Mobil",23.0,325.4));
        orgsArrayList.add(new Orgs("TotalEnergies SE",16.0,146.4));
        orgsArrayList.add(new Orgs("British Oil",7.6,101.6));
        for(Orgs ivar:orgsArrayList){
            TableRow tableRow = (TableRow) View.inflate(this,R.layout.simple_row,null);
            TextView orgName = tableRow.findViewById(R.id.tv_orgName);
            orgName.setText(ivar.name);
            TextView netInc = tableRow.findViewById(R.id.tv_netIncome);
            netInc.setText(String.valueOf(ivar.netIncome));
            TextView marketCap = tableRow.findViewById(R.id.tv_marketCap);
            marketCap.setText(String.valueOf(ivar.marketCap));
            tableLayout.addView(tableRow);
        }
    }
}

class Orgs{
    String name;
    Double netIncome;
    Double marketCap;
    Orgs(String name,Double netIncome,Double marketCap){
        this.name = name;
        this.netIncome = netIncome;
        this.marketCap = marketCap;
    }
}