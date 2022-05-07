package com.example.android.moviereviewapplication.data;

import android.provider.BaseColumns;

public final class Contract implements  BaseColumns {

    final public static String TABLE_NAME = "MovieTable";

    //Column definitions
    final public static String MOVIE_ID = "__ID";
    final public static String MOVIE_NAME = "MOVIE_NAME";
    final public static String MOVIE_YEAR = "MOVIE_YEAR";
    final public static String MOVIE_RATING = "MOVIE_RATING";

    //SQL DDL
    final public static String SQL_CREATE_ENTRIES = "CREATE TABLE "+TABLE_NAME + "("+
            MOVIE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+MOVIE_NAME+" TEXT,"+MOVIE_YEAR+" INTEGER,"+MOVIE_RATING+" REAL);";

    final public static String SQL_DELETE_ENTRIES = "DELETE FROM TABLE "+TABLE_NAME;
}
