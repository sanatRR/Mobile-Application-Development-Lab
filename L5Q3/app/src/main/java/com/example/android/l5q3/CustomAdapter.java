package com.example.android.l5q3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Train> trainArrayList;

    public CustomAdapter(Context mContext,ArrayList<Train> trainArrayList){
        this.mContext = mContext;
        this.trainArrayList = trainArrayList;
    }

    @Override
    public int getCount() {
        return trainArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return trainArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Train currentTrain = trainArrayList.get(i);
        if(view==null){
            view = View.inflate(mContext,R.layout.simple_row,null);
            TextView trainName = (TextView)view.findViewById(R.id.tv_train_name);
            trainName.setText(currentTrain.name);
        }
        return view;
    }
}
