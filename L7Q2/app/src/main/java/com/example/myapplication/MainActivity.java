package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView popUpMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popUpMenuButton = (ImageView) findViewById(R.id.btn_pop_up_menu);
        popUpMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this,popUpMenuButton);
                popup.getMenuInflater().inflate(R.menu.simple_menu,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String title = menuItem.getTitle().toString();
                        Toast t1 = new Toast(getApplicationContext());
                        ImageView i1 = new ImageView(getApplicationContext());
                        if(title.equals("Car")){
                            Log.d("Toast made","Car");
                            i1.setImageResource(R.mipmap.car);
                        }
                        if(title.equals("Plane")){
                            Log.d("Toast made","Plane");
                            i1.setImageResource(R.mipmap.plane);
                        }
                        t1.setView(i1);
                        t1.setDuration(Toast.LENGTH_LONG);
                        t1.show();
                        return false;
                    }
                });
                popup.show();
            }
        });

    }
}