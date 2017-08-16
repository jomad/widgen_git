package com.example.android.widgenV1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.android.widgenV1.R.array.familyName_array;
import static com.example.android.widgenV1.R.array.imageUrl;
import static com.example.android.widgenV1.R.array.scientificName_array;
import static com.example.android.widgenV1.R.id.percentScore;
import static com.example.android.widgenV1.R.id.scientificName;

public class AllUrlImages extends RootActivity {

    Toolbar toolbar;
    private ArrayList<String> finalList;
    private int[] arrayForPicture;
    private ArrayList<Integer> percentScore;
    //    int i;
    private String[] finalListToArray;
    private String[] scientificNameArray;
    private String[] percentScoreToArray;
    private String[] imageUrlArray;
    private String[] imageUrlFinal;
    private Intent intent = getIntent();
    private String [] familyNameResArray;
    private String [] familyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_url_images);


        //        set the background_material color to white
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        Resources getRes = getResources();
        imageUrlArray = getRes.getStringArray(imageUrl);
        familyNameResArray = getRes.getStringArray(familyName_array);
        scientificNameArray = getRes.getStringArray(scientificName_array);

        initViews();


    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.all_url_recyclerView_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AllUrlImagesPlantForListing> plantsForList = prepareData();
        AllUrlImagesAdapter adapter = new AllUrlImagesAdapter(getApplicationContext(),
                plantsForList);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {
        ArrayList <AllUrlImagesPlantForListing> plantsForList = new ArrayList<>();
        for (int i = 0; i < Array.getLength(scientificNameArray); i++) {
            AllUrlImagesPlantForListing plant = new AllUrlImagesPlantForListing();
            plant.setScientificName(scientificNameArray[i]);
//            plant.setPercentScore(percentScoreToArray[i]);
            plant.setFamilyName(familyNameResArray[i]);
            plant.setImageUrl(imageUrlArray[i]);
            plantsForList.add(plant);
        }
//        System.out.println("plantsForListSize " + plantsForList.size());
//        System.out.println("finalListToArray " + Arrays.toString(finalListToArray) + " - " + finalListToArray.length);
//        System.out.println("percentScoreToArray " + Arrays.toString(percentScoreToArray)+ " - " + percentScoreToArray.length );
//        System.out.println("imageUrlArray " + Arrays.toString(imageUrlArray) + " - " + imageUrlArray.length);
        return plantsForList;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
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



    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}
