package com.example.android.l4q3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<AndroidVersions> androidVersionsArrayList;
    Context mContext;
    Toast mToast;

    public CustomAdapter(Context mContext,ArrayList<AndroidVersions> androidVersions){
        this.mContext = mContext;
        this.androidVersionsArrayList = androidVersions;
    }


    @Override
    public int getCount() {
        return androidVersionsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return androidVersionsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = View.inflate(mContext,R.layout.simple_button_list,null);
        AndroidVersions currentVersion = androidVersionsArrayList.get(i);
        Button androidButton = view.findViewById(R.id.btn_button);
        androidButton.setText("Android "+String.valueOf(currentVersion.version));
        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mToast!=null)
                    mToast.cancel();
                mToast = Toast.makeText(mContext,currentVersion.name,Toast.LENGTH_SHORT);
                mToast.show();
                ImageView logo = new ImageView(mContext);
                logo.setImageResource(currentVersion.imageResId);
                mToast = new Toast(mContext);
                mToast.setView(logo);
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.show();
            }
        });
        return view;
    }
}
