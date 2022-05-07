package com.example.android.moviereviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Existing extends AppCompatActivity {
    TextView movieNameTv,movieYearTv;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing);
        Intent i1 = getIntent();
        String MovieName = i1.getStringExtra("MovieName");
        int MovieYear = i1.getIntExtra("MovieYear",2008);
        float MovieRating = i1.getFloatExtra("MovieRating",5);
        movieNameTv = findViewById(R.id.tv_movie_name_Res);
        movieYearTv = findViewById(R.id.tv_yearRes);
        ratingBar = findViewById(R.id.ratingRes);
        movieNameTv.setText(MovieName);
        movieYearTv.setText(String.valueOf(MovieYear));
        ratingBar.setRating(MovieRating);
    }
}