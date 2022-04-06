package com.example.android.l2q3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cancel,ok;
    EditText typeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancel = (Button) findViewById(R.id.btn_cancel);
        ok = (Button) findViewById(R.id.btn_ok);
        typeHere = (EditText) findViewById(R.id.et_typeHere);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = String.valueOf(typeHere.getText());
                if(link.startsWith("http://") || link.startsWith("https://") ){
                    Intent i1 = new Intent(Intent.ACTION_VIEW);
                    i1.setData(Uri.parse(link));
                    startActivity(i1);
                }else
                    Toast.makeText(getApplicationContext(),"Invalid Link",Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeHere.setText("");
            }
        });
    }

}