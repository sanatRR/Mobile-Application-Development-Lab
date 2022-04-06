package com.example.android.l5q3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Spinner sourceSpinner,destinationSpinner;
    String source,destination,timeStr,dateStr;
    int selYear,selMonth,selDay,selHour=11,selMin;
    TextView timeTV,dateTV;
    ToggleButton ticketTypeButton;
    String ticketType;
    Button submit,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sourceSpinner = (Spinner)findViewById(R.id.spin_source);
        destinationSpinner = (Spinner)findViewById(R.id.spin_destination);
        dateTV = (TextView)findViewById(R.id.tv_selectedDate);
        timeTV = (TextView)findViewById(R.id.tv_selectedTime);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.location, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ticketTypeButton = (ToggleButton)findViewById(R.id.btn_ticket_type);
        submit = (Button)findViewById(R.id.btn_submit);
        sourceSpinner.setAdapter(arrayAdapter);
        destinationSpinner.setAdapter(arrayAdapter);
        ticketType = (String) ticketTypeButton.getText();
        clear = (Button)findViewById(R.id.btn_clear);
        clear();
        dateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
            }
        });
        timeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker();

            }
        });
        ticketTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketType = (String) ticketTypeButton.getText();
                ticketTypeButton.setText(ticketType);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("time",selHour+ticketType);
                if(selHour<11 && ticketType.equals("Tatkal")) {
                    Toast.makeText(getApplicationContext(), "TATKAL only after 11:00", Toast.LENGTH_SHORT).show();
                }else if(source.equals(destination)){
                    Toast.makeText(getApplicationContext(), "Source and Destination cannot be same", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i1 = new Intent(getApplicationContext(),TrainDetails.class);
                    i1.putExtra("source",source);
                    i1.putExtra("destination",destination);
                    i1.putExtra("date",dateStr);
                    i1.putExtra("time",timeStr);
                    i1.putExtra("ticketType",ticketType);
                    startActivity(i1);
                }
            }
        });
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                   source = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    //pass
            }
        });
        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    destination = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    //pass
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        TextView date = (TextView)findViewById(R.id.tv_selectedDate);
        selYear = year;
        selMonth = month;
        selDay = day;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,day);
        dateStr = DateFormat.getDateInstance().format(c.getTime());
        date.setText(dateStr);
    }

    public void timePicker(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                selHour = hour;
                selMin = minute;
                timeStr = String.format(Locale.getDefault(),"%d:%d",hour,minute);
                timeTV.setText(String.format(Locale.getDefault(),"%d:%d",hour,minute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,selHour,selMin,true);
        timePickerDialog.show();
    }

    public void clear(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        dateStr = formatter.format(date);
        dateTV.setText(dateStr);
        LocalTime time = LocalTime.now();
        timeStr = String.valueOf(time);
        timeTV.setText(timeStr);
    }
}