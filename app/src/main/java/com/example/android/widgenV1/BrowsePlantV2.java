package com.example.android.widgenV1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class BrowsePlantV2 extends AppCompatActivity {


    private String [] eNameArray, scientificName, commonName;
    private String namePlant;
    private ArrayList<String> sNameListArray;
    private ArrayList<String> searchList;
    private String[][] arrayOfArray;
    private AutoCompleteTextView autoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_browse2);

//        build a list of searchable items from arrays of englishName, commonName and scientificName
        Resources res = getResources();
        eNameArray = res.getStringArray(R.array.englishName_array);
        scientificName = res.getStringArray(R.array.scientificName_array);
        commonName = res.getStringArray(R.array.commonNameData);

        searchList.addAll(Arrays.asList(eNameArray));
        searchList.addAll(Arrays.asList(scientificName));
        searchList.addAll(Arrays.asList(commonName));

//        make an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                searchList);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id. search_item);
        autoCompleteTextView.setAdapter(adapter);
//        sNameListArray = new ArrayList<>(Arrays.asList(scientificName));
        ImageView searchButton = (ImageView) findViewById(R.id.search_profile);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = autoCompleteTextView.getText().toString();
//                check the index of source in the 3 arrays in arrayOfArray, since -1 means object
//                is not present in an array, positive index will tell the position
                int index = -1;
                int arrayCounter = 0;
                while (index == -1 && arrayCounter < arrayOfArray.length) {
                    index = Arrays.asList(arrayOfArray[arrayCounter]).indexOf(source);
                    arrayCounter = arrayCounter + 1;
                }

                switch (index) {
                    case -1:
                        Toast.makeText(BrowsePlantV2.this, "Name not found", Toast.LENGTH_LONG).show();
                        break;

                    default:
                        namePlant = scientificName[index];


                }


            }

        });






    }

}
