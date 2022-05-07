package com.example.android.moviereviewapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class DBHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "movie.db";
    static int DATABASE_VERSION;
    static {
        DATABASE_VERSION = 1;
    }

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Contract.SQL_CREATE_ENTRIES);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        DATABASE_VERSION++;
        sqLiteDatabase.execSQL(Contract.SQL_CREATE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
