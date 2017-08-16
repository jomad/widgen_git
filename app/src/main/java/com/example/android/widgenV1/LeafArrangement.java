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
 * Created by Don on 10/15/2016.
 */

public class LeafArrangement extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Alternate", R.drawable.zlar_alternate));
        characterImageLabels.add(new CharacterImageLabel("Opposite", R.drawable.zlar_opposite));
        characterImageLabels.add(new CharacterImageLabel("Whorled", R.drawable.zlar_whorled));
        characterImageLabels.add(new CharacterImageLabel("Rosulate", R.drawable.zlar_rosulate));
        characterImageLabels.add(new CharacterImageLabel("Basal", R.drawable.zlar_basal));
        characterImageLabels.add(new CharacterImageLabel("Equitant", R.drawable.zlar_equitant));
        characterImageLabels.add(new CharacterImageLabel("Fascicled", R.drawable.zlar_fascicled));
        characterImageLabels.add(new CharacterImageLabel("Imbricate", R.drawable.zlar_imbricate));

        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(LeafArrangement.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Alternate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Opposite");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Whorled");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Rosulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Basal");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Equitant");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Fascicled");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(LeafArrangement.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafArrangement", "Imbricate");
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