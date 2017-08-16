package com.example.android.widgenV1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ZoomedSearchImage extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageZoomed;
    String imageUrl, plantNameForDisplay;
    TextView plantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomed_image_search_name);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageZoomed = (ImageView) findViewById(R.id.image_zoomed);

        Intent i = getIntent();
        imageUrl = i.getStringExtra("imageUrl");
        int resID = i.getIntExtra("resID", 0);
        plantNameForDisplay = i.getStringExtra("plantNameForDisplay");
        plantName = (TextView) findViewById(R.id.textView_plant_name);
        plantName.setText(plantNameForDisplay);

        if (resID == 0) {
            loadImageFromUrl(imageUrl);
        } else {
            imageZoomed.setImageResource(resID);
        }
        System.out.println("This is resID" + resID);
        System.out.println("This is imageUrl " + imageUrl);
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.default_image)
                .into(imageZoomed, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }


    public void back_plant_profile(View view) {
        finish();
    }

}
