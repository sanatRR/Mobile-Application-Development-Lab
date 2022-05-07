package com.example.android.l10q1;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    ChangeStatusReceiver receiver;

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            URL url = new URL("http://speedtest.ftp.otenet.gr/files/test100k.db"); //Download dummy file
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard, "filename.ext");

            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();

            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                fileOutput.write(buffer, 0, bufferLength);
            }
            fileOutput.close();

        } catch (Exception e) {
            Log.d("Download Service",e.getMessage());
        }
        Intent i1 = new Intent(DownloadService.this,MainActivity.class);
        i1.setAction("com.example.android.l10q1.DOWNLOAD_COMPLETE");
        sendBroadcast(i1);
        return START_STICKY;
    }

}

