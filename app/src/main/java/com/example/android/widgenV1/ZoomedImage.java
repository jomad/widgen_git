package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

public class ZoomedImage extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageZoomed;
    ArrayList<String> finalList;
    String plantForProfile;
    TextView plantName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomed_image);

        SharedPreferences myPref = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        String namePlant = myPref.getString("plantForProfile", "");
        Intent i = getIntent();
        plantForProfile = i.getStringExtra("plantForProfile");
        plantName = (TextView) findViewById(R.id. textView_plant_name);
        plantName.setText(plantForProfile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageZoomed = (ImageView) findViewById(R.id. image_zoomed);

//        Intent i = getIntent();
        finalList = i.getStringArrayListExtra("key");
        System.out.print("ZoomedImage finalList " + finalList);
        String imageUrl = i.getStringExtra("imageUrl");
        int resID = i.getIntExtra("resID",0);

        if (resID == 0) {
            loadImageFromUrl(imageUrl);
        } else {
            imageZoomed.setImageResource(resID);
        }
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
        Intent i =new Intent(ZoomedImage.this, PlantProfile.class);
        i.putStringArrayListExtra("key", finalList);

        startActivity(i);
    }
}
