package com.example.android.moviereviewapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.android.moviereviewapplication.data.Contract;
import com.example.android.moviereviewapplication.data.DBHelper;

public class MainActivity extends AppCompatActivity {
    EditText movieName,movieYear;
    RatingBar ratingBar;
    Button submit,existing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieName = (EditText)findViewById(R.id.et_movie_name);
        movieYear = (EditText)findViewById(R.id.et_year);
        ratingBar = (RatingBar)findViewById(R.id.rating);
        submit = (Button)findViewById(R.id.btn_submit_review);
        existing = (Button)findViewById(R.id.btn_show_existing);

        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                String movieNameStr = String.valueOf(movieName.getText());
                String movieYearStr = String.valueOf(movieYear.getText());
                if(movieNameStr.length()<1 || movieYearStr.length()<1){
                    Toast.makeText(getApplicationContext(),"Enter complete details!",Toast.LENGTH_SHORT).show();
                    return;
                }
                float ratingVal = ratingBar.getRating();
                Movie newMovie = new Movie(movieNameStr,Integer.parseInt(movieYearStr),ratingVal);
                DBHelper helper = new DBHelper(getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Contract.MOVIE_NAME,movieNameStr);
                try{
                    values.put(Contract.MOVIE_YEAR,Integer.valueOf(movieYearStr));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                    return;
                }
                values.put(Contract.MOVIE_RATING,Float.valueOf(ratingVal));
                db.insert(Contract.TABLE_NAME,null,values);
            }
        });


        existing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MovieList.class));
            }
        });

    }
}