package com.example.android.moviereviewapplication;

public class Movie {
    String mMovieName;
    int mMovieYear;
    float mMoviePoints;

    public Movie(String mMovieName,int mMovieYear,float mMoviePoints){
        this.mMovieName = mMovieName;
        this.mMovieYear = mMovieYear;
        this.mMoviePoints = mMoviePoints;
    }

    public String getmMovieName(){
        return this.mMovieName;
    }
    public int getMovieYear(){
        return this.mMovieYear;
    }

    public float getmMoviePoints(){
        return this.mMoviePoints;
    }
}
