package com.example.android.l3q1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        Integer logos[] = {R.mipmap.aapl,R.mipmap.adbe,R.mipmap.crm,R.mipmap.goog,R.mipmap.intu,R.mipmap.msft,R.mipmap.orcl,R.mipmap.sap,R.mipmap.team,R.mipmap.vmw,R.mipmap.akam,R.mipmap.ctxs};
        ImageAdapter i1 = new ImageAdapter(logos,this);
        GridView g1= (GridView)findViewById(R.id.gv_logos);
        g1.setAdapter(i1);
    }
}