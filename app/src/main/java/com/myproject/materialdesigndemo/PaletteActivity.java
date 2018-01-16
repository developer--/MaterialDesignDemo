package com.myproject.materialdesigndemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

public class PaletteActivity extends AppCompatActivity {


    int def = 0x000000;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        toolbar = findViewById(R.id.p_toolbar_id);

        Bitmap myBtmp = BitmapFactory.decodeResource(getResources(),R.drawable.sun);
        if (myBtmp != null){
            Palette.from(myBtmp).generate(paletteListener);
        }
    }

    Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onGenerated(Palette palette) {
            Palette.Swatch swatch = palette.getVibrantSwatch();
            int rgbColor = swatch.getRgb();
            int titleColor = swatch.getTitleTextColor();
            int bodyColor = swatch.getBodyTextColor();
            toolbar.setBackgroundColor(rgbColor);
            toolbar.setTitleTextColor(titleColor);
        }
    };

}
