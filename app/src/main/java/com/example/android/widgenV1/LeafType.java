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

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

/**
 * Created by Don on 10/14/2016.
 */

public class LeafType extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Simple", R.drawable.zlt_simple));
        characterImageLabels.add(new CharacterImageLabel("Palmately compound", R.drawable.zlt_palmately_compound));
        characterImageLabels.add(new CharacterImageLabel("Pinnately trifoliate", R.drawable.zlt_pinnately_trifoliate));
        characterImageLabels.add(new CharacterImageLabel("Biternate", R.drawable.zlt_biternate));
        characterImageLabels.add(new CharacterImageLabel("Even-pinnate", R.drawable.zlt_even_pinnate));
        characterImageLabels.add(new CharacterImageLabel("Odd-pinnate", R.drawable.zlt_odd_pinnate));
        characterImageLabels.add(new CharacterImageLabel("Bipinnate", R.drawable.zlt_bipinnate));
        characterImageLabels.add(new CharacterImageLabel("Tripinnate", R.drawable.zlt_tripinnate));


        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(LeafType.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(LeafType.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Simple");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Palmately compound");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Pinnately trifoliate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Biternate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Even-pinnate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Odd-pinnate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Bipinnate");
                        editor.commit();
                        startActivity(intent);
                        break;
                    default:
                        intent = new Intent(LeafType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafType", "Tripinnate");
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


