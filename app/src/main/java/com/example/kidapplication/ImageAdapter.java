package com.example.kidapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    public Context mContext;

    public ImageAdapter(Context mContext){

        this.mContext=mContext;
    }

    int imageArray[]=new int[]{
        R.drawable.bird,R.drawable.cat,R.drawable.dog,
            R.drawable.donkey,R.drawable.goose,R.drawable.gorilla,
            R.drawable.horse,R.drawable.lion,R.drawable.gaur,R.drawable.elephant
    };

    // size of image array
    @Override
    public int getCount() {
        return imageArray.length;
    }
    //position of image aray
    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //to view the images
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(   400,550));
        imageView.setPadding(1, 1, 1, 1);
        return imageView;
    }
}
