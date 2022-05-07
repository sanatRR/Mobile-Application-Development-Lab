package com.example.android.moviereviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.widget.ListView;

import com.example.android.moviereviewapplication.data.Contract;
import com.example.android.moviereviewapplication.data.DBHelper;

import java.util.ArrayList;

public class MovieList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        DBHelper obj = new DBHelper(this);
        SQLiteDatabase db = obj.getReadableDatabase();
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        Cursor c = db.query(Contract.TABLE_NAME,null,null,null,null,null,null);
        while(c.moveToNext()){
            int index;
            String MovieName;
            int MovieYear;
            float MovieRating;
            index = c.getColumnIndex(Contract.MOVIE_NAME);
            MovieName = c.getString(index);
            index = c.getColumnIndex(Contract.MOVIE_YEAR);
            MovieYear = c.getInt(index);
            index = c.getColumnIndex(Contract.MOVIE_RATING);
            MovieRating = c.getColumnIndex(Contract.MOVIE_RATING);
            movieArrayList.add(new Movie(MovieName,MovieYear,MovieRating));
        }
        ListView lV = findViewById(R.id.lv);
        CustomAdapter cA = new CustomAdapter(this,movieArrayList);
        lV.setAdapter(cA);
    }
}