package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;
import static com.example.android.widgenV1.R.id.scientificName;

public class PlantList extends AppCompatActivity {
    Toolbar toolbar;
    private static final String TIG = "PlantList";
    String mselectedFromList;
    ArrayList<String> finalList;
    int[] arrayForPicture;
    ArrayList <Integer> percentScore;
    String[] imageList;
    int [] resIdArray;
    String [] imageUrlArray;
    int i;
    String [] finalListToArray;
    String [] scientificName;
    String [] percentScoreToArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list_with_image);
        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        set the background_material color to white
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        Intent intent = getIntent();
        finalList = new ArrayList<String>();
        finalList = intent.getStringArrayListExtra("list");
//        finalList.add("joden");
        System.out.println("FinalList arrayList - " + finalList);

//        convert ArrayList <string> to String []
        finalListToArray = new String[finalList.size()];
        finalListToArray = finalList.toArray(finalListToArray);
        arrayForPicture = intent.getIntArrayExtra("arrayForPic");
        percentScore = intent.getIntegerArrayListExtra("percentScore");
        percentScoreToArray = new String[finalList.size()];
        percentScoreToArray = percentScore.toArray(percentScoreToArray);


        Resources res = getResources();
        imageList = res.getStringArray(R.array.drawable_resource);
        String [] drawableResource;
        drawableResource = new String[finalList.size()];
        System.out.println("percentScore of items - " + percentScoreToArray);

        for (int i = 0; i < finalList.size(); i++) {
            drawableResource [i] = imageList[arrayForPicture[i]];
        }
        resIdArray = new int[finalList.size()];
//        Make an array with resource id's as element to be use to display the images in listview
        for (int i = 0; i < finalList.size(); i++) {
            resIdArray [i] = getResources().getIdentifier(drawableResource[i] , "drawable", getPackageName());
//            if (resIdArray [i]== 0) {
//                resIdArray [i] = getResources().getIdentifier("zft_rotate","drawable",getPackageName());
//            }
        }
        // Get a handle to the list view
        final ListView lv = (ListView) findViewById(R.id.plant_list_with_image);
        Resources getRes = getResources();
        imageUrlArray = getRes.getStringArray(R.array.imageUrl);
        scientificName = getRes.getStringArray(R.array.scientificName_array);

        CustomListAdapter adapter2 = new CustomListAdapter(this,finalListToArray, percentScoreToArray,resIdArray,
                    scientificName,imageUrlArray);

        lv.setAdapter(adapter2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                mselectedFromList = (String) (lv.getItemAtPosition(myItemInt));
                Intent i = new Intent(PlantList.this, PlantProfile.class);
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("plantForProfile", mselectedFromList);
                editor.apply();
                i.putStringArrayListExtra("key", finalList);
                startActivity(i);
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
    public void back_weed_id(View view) {
        Intent i = new Intent(PlantList.this, MainActivity2.class);
        startActivity(i);
//        finish();
    }
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
