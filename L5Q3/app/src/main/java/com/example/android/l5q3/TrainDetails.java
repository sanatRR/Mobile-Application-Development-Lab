package com.example.android.l5q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainDetails extends AppCompatActivity {
    TextView sourceTV,destinationTV,dateTV,timeTV,ticketTypeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_details);
        ArrayList<Train> trainsList= new ArrayList<>();
        Intent i1 = getIntent();
        sourceTV = (TextView)findViewById(R.id.tv_source_res);
        destinationTV = (TextView)findViewById(R.id.tv_destination_res);
        dateTV = (TextView)findViewById(R.id.tv_selectedDate_res);
        timeTV = (TextView)findViewById(R.id.tv_selectedTime_res);
        ticketTypeTV = (TextView)findViewById(R.id.tv_ticket_type_res);
        sourceTV.setText(i1.getStringExtra("source"));
        destinationTV.setText(i1.getStringExtra("destination"));
        timeTV.setText(i1.getStringExtra("time"));
        dateTV.setText(i1.getStringExtra("date"));
        ticketTypeTV.setText(i1.getStringExtra("ticketType"));
        trainsList.add(new Train("Rajdhani Express",8));
        trainsList.add(new Train("Garib Rath Express",11));
        trainsList.add(new Train("Duronto Express",11));
        trainsList.add(new Train("August Kranti Rajdhani",11));
        trainsList.add(new Train("Tejas express",8));
        trainsList.add(new Train("Palace on Wheels",11));
        trainsList.add(new Train("Maharaja Express",8));
        trainsList.add(new Train("Deccan Odyssey",11));
        trainsList.add(new Train("Island Express",8));
        trainsList.add(new Train("Golden Chariot",11));
        trainsList.add(new Train("Rajdhani Express 2",8));
        trainsList.add(new Train("Garib Rath Express 2",11));
        trainsList.add(new Train("Duronto Express 2",11));
        trainsList.add(new Train("August Kranti Rajdhani 2",8));
        trainsList.add(new Train("Tejas express 2",11));
        trainsList.add(new Train("Palace on Wheels 2",11));
        trainsList.add(new Train("Maharaja Express 2",8));
        trainsList.add(new Train("Deccan Odyssey 2",11));
        trainsList.add(new Train("Island Express 2",11));
        trainsList.add(new Train("Golden Chariot 2",8));
        CustomAdapter customAdapter = new CustomAdapter(this,trainsList);
        ListView listView = (ListView)findViewById(R.id.lv);
        listView.setAdapter(customAdapter);
    }
}