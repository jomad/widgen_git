package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Don on 10/14/2016.
 */

public class FlowerPosition extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Axillary", R.drawable.fp_axillary));
        characterImageLabels.add(new CharacterImageLabel("Terminal", R.drawable.fp_terminal));

        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(FlowerPosition.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(FlowerPosition.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("flowerPosition", "Axillary");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(FlowerPosition.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("flowerPosition", "Terminal");
                        editor.commit();
                        startActivity(intent);
                        break;


                }
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
                actionIntent = new Intent(this, SearchList.class);
                startActivity(actionIntent);
                return true;

            case R.id. action_skilltest:
                actionIntent = new Intent(this, ChallengeType.class);
                startActivity(actionIntent);
                return true;

            case R.id. acton_illustrations:
                actionIntent = new Intent(this, FrontPage.class);
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
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}

