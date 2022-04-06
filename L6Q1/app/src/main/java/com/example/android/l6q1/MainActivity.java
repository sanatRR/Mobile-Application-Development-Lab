package com.example.android.l6q1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new home_page();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opt_about_us: {
                Fragment fragment = new about_us();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                //frame_container is the id of the container for the fragment
                return true;
            }case R.id.opt_admission:{
                Fragment fragment = new admission();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                return true;
            } case R.id.opt_contact_us:{
                Fragment fragment = new contact_us();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                return true;
            } case R.id.opt_courses:{
                Fragment fragment = new courses();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                return true;
            } case R.id.opt_faculty:{
                Fragment fragment = new faculty();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                return true;
            } case R.id.opt_homepage:{
                Fragment fragment = new home_page();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fl_parentFragment, fragment).commit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

