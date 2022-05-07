package com.example.android.l10q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ChangeStatusReceiver receiver;
    Button mButton;

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new ChangeStatusReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.android.l10q1.DOWNLOAD_COMPLETE");
        mButton = findViewById(R.id.btn_download);
        this.registerReceiver(receiver,intentFilter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this,DownloadService.class));
                Toast.makeText(getApplicationContext(),"File Downloaded",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(receiver);
    }
}