package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;
import static com.example.android.widgenV1.R.array.familyName_array;
import static com.example.android.widgenV1.R.array.imageUrl;

public class PlantListRecyclerView extends RootActivity {
    Toolbar toolbar;
    private ArrayList<String> finalList;
    private int[] arrayForPicture;
    private ArrayList<Integer> percentScore;
    //    int i;
    private String[] finalListToArray;
    private String[] scientificName;
    private String[] percentScoreToArray;
    private String[] imageUrlArray;
    private String[] imageUrlFinal;
    private Intent intent = getIntent();
    private String [] familyNameResArray;
    private String [] familyName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list_with_image_recycler_view);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        set the background_material color to white
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

//              System.out.println("finalList before recyclerView");


        Intent intent = getIntent();
        finalList = intent.getStringArrayListExtra("list");
//        System.out.println("finalList recyclerView " + finalList);
//        convert ArrayList <string> to String []
        finalListToArray = new String[finalList.size()];

        //        finalListToArray is the String [] of scientific name to be display
        finalListToArray = finalList.toArray(finalListToArray);
        System.out.println("finalListToArray " + Arrays.toString(finalListToArray));

        arrayForPicture = intent.getIntArrayExtra("arrayForPic");
        System.out.println("arrayForPicture recyclerView - " + Arrays.toString(arrayForPicture));
        Resources getRes = getResources();
        imageUrlArray = getRes.getStringArray(imageUrl);
        familyNameResArray = getRes.getStringArray(familyName_array);
        System.out.println("ImageURLArray " + Arrays.toString(imageUrlArray));

//        imageUrlFinal is the String [] for list of URLS to display
        imageUrlFinal = new String[finalList.size()];
        for (int i = 0; i < finalList.size(); i++) {
            imageUrlFinal[i] = imageUrlArray[arrayForPicture[i]];
            System.out.println("arrayForPicture - " + arrayForPicture[i]);
            System.out.println("imageUrlFinal " + i + " " + imageUrlFinal[i]);
        }
        System.out.println("This is imagUrlFinal " + Arrays.toString(imageUrlFinal));

//        get the familyName from res array
        familyName = new String[finalList.size()];
        for (int i = 0; i < finalList.size(); i++) {
            familyName [i] = familyNameResArray[arrayForPicture[i]];
        }
//        Percent match score of each plant against criteria
        percentScore = intent.getIntegerArrayListExtra("percentScore");
//        percentScoreToArray is the String [] of percent scores to be displayed
        percentScoreToArray = new String[finalList.size()];
        percentScoreToArray = percentScore.toArray(percentScoreToArray);

        System.out.println("This is percentScoreToArray " + Arrays.toString(percentScoreToArray));

        initViews();


    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

//        System.out.println("Inside initViews");



        ArrayList <Plant> plantsForList = prepareData();
        PlantListRecyclerViewAdapter adapter = new PlantListRecyclerViewAdapter(getApplicationContext(),
                plantsForList);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {
        ArrayList <Plant> plantsForList = new ArrayList<>();
        for (int i = 0; i < finalList.size(); i++) {
            Plant plant = new Plant();
            plant.setScientificName(finalListToArray[i]);
            plant.setPercentScore(percentScoreToArray[i]);
            plant.setFamilyName(familyName[i]);
            plant.setImageUrl(imageUrlFinal[i]);
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

    public void back_weed_id(View view) {
        Intent i = new Intent(PlantListRecyclerView.this, MainActivity2.class);
        startActivity(i);
//        finish();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
