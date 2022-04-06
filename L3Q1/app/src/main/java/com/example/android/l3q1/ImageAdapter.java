package com.example.android.l3q1;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    Integer imageIds[];
    Context mContext;

    public ImageAdapter(Integer arr[],Context mContext){
        imageIds = arr;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return imageIds[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = new ImageView(mContext);
        }
        view.setBackgroundResource(imageIds[i]);
        ImageView i1=(ImageView)view;
        i1.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        i1.setScaleType(ImageView.ScaleType.CENTER);
        return view;
    }
}
