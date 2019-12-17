package com.example.szidonialaszlo.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;


//contains operations with images

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.szidonialaszlo.ITEM_INDEX", -1);

        if (index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img,pic);
        }

    }

    //get image
    private int getImage(int index){
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            default: return -1;
            
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(),pic,options);
        img.setImageBitmap(scaledImg);

    }
}
