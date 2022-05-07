package com.example.android.l9q1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.FileNameMap;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;

    private Uri filePath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());  // Set file access Policy
        mButton = (Button)findViewById(R.id.btn_shareButton);
        mTextView = (TextView) findViewById(R.id.tv_filePath);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonShareFile();
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.setType("*/*");
                    startActivityForResult(i,9999);
                }
            }
        });
    }

    public void buttonShareFile(){
        if(filePath==null){
            Toast.makeText(this,"File Doesn't exit",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("image/*");
        intentShare.putExtra(intentShare.EXTRA_STREAM, Uri.parse(String.valueOf(filePath)));
        startActivity(Intent.createChooser(intentShare,"Share file"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        filePath =data.getData();
        Log.d("file is  ", String.valueOf(filePath));
        String arr[] = String.valueOf(filePath).split("images%2F");
        mTextView.setText(arr[arr.length-1]);
    }
}