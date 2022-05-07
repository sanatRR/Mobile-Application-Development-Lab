package com.example.android.moviereviewapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {


    ArrayList<Movie> movieList;

    Context mContext;
    public CustomAdapter(Context mContext, ArrayList<Movie> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Movie currentMovie = movieList.get(i);
        if(view==null){
            view = View.inflate(mContext,R.layout.movie_title,null);
        }
        TextView movieName = view.findViewById(R.id.tv_list_movie_name);
        movieName.setText(currentMovie.getmMovieName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(mContext,Existing.class);
                i1.putExtra("MovieName",currentMovie.mMovieName);
                i1.putExtra("MovieYear",currentMovie.mMovieYear);
                i1.putExtra("MovieRating",currentMovie.mMoviePoints);
                mContext.startActivity(i1);
            }
        });
        return view;
    }
}
