package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

public class PlantProfile extends RootActivity {

    Toolbar toolbar;
    String url;
    int defaultImage;
    ImageView imageView;
    String [] imageUrl;
    int resID;
    int index;
    String[] drawableName;
    ArrayList<String> finalList;

    String [] eNameArray;
    int [] resIdArray;
    private String plantForProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_profile);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        get the fianlList array of possible identity to preserve data when activity changes
        Intent i = getIntent();
//        finalList = i.getStringArrayListExtra("key");
        plantForProfile = i.getStringExtra("plantForProfile");

        System.out.println("PlantProfile finalList " + plantForProfile);

        Resources res = getResources();

        drawableName = res.getStringArray(R.array.drawable_resource);
        eNameArray = getResources().getStringArray(R.array.englishName_array);
        final String[] scientificName = res.getStringArray(R.array.scientificName_array);
        final String[] family = res.getStringArray(R.array.familyName_array);
        final String[] commonName = res.getStringArray(R.array.commonNameData);
        String[] genus = res.getStringArray(R.array.genusData_array);
        final String[] lifeHabit = res.getStringArray(R.array.lifeHabitData_array);
        final String[] growthHabit = res.getStringArray(R.array.growthHabitData_array);
        String[] leafType = res.getStringArray(R.array.leafTypeData_array);
        final String[] leafArrangement = res.getStringArray(R.array.leafArrangementData_array);
        String[] leafPosition = res.getStringArray(R.array.leafPositionData_array);
        String[] leafAttachment = res.getStringArray(R.array.leafAttachmentData_array);
        final String[] margin = res.getStringArray(R.array.marginData_array);
        final String[] venation = res.getStringArray(R.array.venationData_array);
        String[] surface = res.getStringArray(R.array.surfaceData_array);
        final String[] shape = res.getStringArray(R.array.shapeData_array);
        final String[] base = res.getStringArray(R.array.baseData_array);
        final String[] apex = res.getStringArray(R.array.apexData_array);
        final String[] corolla = res.getStringArray(R.array.corollaData_array);
        String[] symmetry = res.getStringArray(R.array.symmetryData_array);
        final String[] inflorescence = res.getStringArray(R.array.inflorescenceData_array);
        final String[] color = res.getStringArray(R.array.colorData_array);
        String[] flowerPosition = res.getStringArray(R.array.flowerPositionData_array);
        String[] flowerAttachment = res.getStringArray(R.array.flowerAttachmentData_array);
        imageUrl = res.getStringArray(R.array.imageUrl);

        final ArrayList <String> sNameListArray = new ArrayList<>(Arrays.asList(scientificName));

        final String [][] arrayOfArray = new String[][] {scientificName,commonName,eNameArray};
        ArrayList<String> searchList = new ArrayList<>();

        searchList.addAll(Arrays.asList(scientificName));
        searchList.addAll(Arrays.asList(commonName));
        searchList.addAll(Arrays.asList(eNameArray));


        final TextView plantName = (TextView) findViewById(R.id.plant_id);

        imageView = (ImageView)findViewById(R.id.plant_ImageView);

//        SharedPreferences myPref = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
//        String namePlant = myPref.getString("plantForProfile", "");

//        Intent i = getIntent();
//        String namePlant = i.getStringExtra("key2");
        plantName.setText(plantForProfile);

        final TextView familyX = (TextView) findViewById(R.id.editText_family);
        final TextView commonX = (TextView) findViewById(R.id.editText_common);
        final TextView lifeHabitX = (TextView) findViewById(R.id.editText_lifeHabit);
        final TextView growthHabitX = (TextView) findViewById(R.id.editText_growthHabit);
        final TextView leafArrangmentX = (TextView) findViewById(R.id.editText_leafArrangement);
        final TextView leafShapeX = (TextView) findViewById(R.id.editText_leafShape);
        final TextView leafMarginX = (TextView) findViewById(R.id.editText_leafMargin);
        final TextView leafBaseX = (TextView) findViewById(R.id.editText_leafBase);
        final TextView leafAPexX = (TextView) findViewById(R.id.editText_leafApex);
        final TextView venationX = (TextView) findViewById(R.id.editText_venation);
        final TextView inflorescenceX = (TextView) findViewById(R.id.editText_inflorescence);
        final TextView corollaX = (TextView) findViewById(R.id.editText_corolla);
        final TextView colorX = (TextView) findViewById(R.id.editText_color);

        index = Arrays.asList(scientificName).indexOf(plantForProfile);
//        System.out.println(Arrays.asList(scientificName).indexOf("Cyathula prostrata"));
        System.out.println("This is the the index of plant " + plantForProfile + " " + index);

//        get resource ID of drawable name to be set on imageview
        String mDrawableName = drawableName[index];
        resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

//        set image on imageView using resource id
        if (resID == 0) {
            loadImageFromUrl(imageUrl[index]);
        } else {
            imageView.setImageResource(resID);
        }

        familyX.setText(family[index]);
        commonX.setText(commonName[index]);
        leafArrangmentX.setText(leafArrangement[index]);
        lifeHabitX.setText(lifeHabit[index]);
        growthHabitX.setText(growthHabit[index]);
        leafShapeX.setText(shape[index]);
        leafMarginX.setText(margin[index]);
        leafBaseX.setText(base[index]);
        leafAPexX.setText(apex[index]);
        venationX.setText(venation[index]);
        inflorescenceX.setText(inflorescence[index]);
        corollaX.setText(corolla[index]);
        colorX.setText(color[index]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                searchList);

        // Hook up clicks on the thumbnail views.

        final View thumb1View = findViewById(R.id.plant_ImageView);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                index = Arrays.asList(scientificName).indexOf(plantName.getText().toString());
                String mDrawableName = drawableName[index];
                resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                zoomImageFromThumb(thumb1View, resID);*/

                Intent i = new Intent(PlantProfile.this, ZoomedImage.class);
                i.putExtra("imageUrl", imageUrl[index]);
                i.putExtra("resID", resID);
                i.putStringArrayListExtra("key", finalList);
                i.putExtra("plantForProfile", plantForProfile);
                startActivity(i);
            }
        });

    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.default_image)
                .fit().centerCrop()
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent actionIntent;

        switch (item.getItemId()) {

            case R.id.acton_browseList:
                actionIntent = new Intent(this, BrowsePlant.class);
                startActivity(actionIntent);
                return true;

            case R.id.action_skilltest:
                actionIntent = new Intent(this, ChallengeType.class);
                startActivity(actionIntent);
                return true;

            case R.id.acton_illustrations:
                actionIntent = new Intent(this, MainActivity2.class);
                startActivity(actionIntent);
                return true;

            case R.id.action_homepage:
                actionIntent = new Intent(this, FrontPage.class);
                startActivity(actionIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void back_plant_list(View view) {
        Intent intent = new Intent(PlantProfile.this, PlantList.class);
        intent.putStringArrayListExtra("key", finalList);
//        intent.putExtra("resIdArrayKey", resIdArray);
        startActivity(intent);
//        finish();
    }
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
