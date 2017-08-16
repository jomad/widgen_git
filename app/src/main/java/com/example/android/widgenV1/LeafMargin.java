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
 * Created by Don on 10/16/2016.
 */

public class LeafMargin extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Entire", R.drawable.zlm_entire));
        characterImageLabels.add(new CharacterImageLabel("Crenate", R.drawable.zlm_crenate));
        characterImageLabels.add(new CharacterImageLabel("Sinuate", R.drawable.zlm_sinuate));
        characterImageLabels.add(new CharacterImageLabel("Crenulate", R.drawable.zlm_crenulate));
        characterImageLabels.add(new CharacterImageLabel("Dentate", R.drawable.zlm_dentate));
        characterImageLabels.add(new CharacterImageLabel("Denticulate", R.drawable.zlm_denticulate));
        characterImageLabels.add(new CharacterImageLabel("Serrate", R.drawable.zlm_serrate));
        characterImageLabels.add(new CharacterImageLabel("Doubly serrate", R.drawable.zlm_doubly_serrate));
        characterImageLabels.add(new CharacterImageLabel("Serrulate", R.drawable.zlm_serrulate));
        characterImageLabels.add(new CharacterImageLabel("Ciliate", R.drawable.zlm_ciliate));
        characterImageLabels.add(new CharacterImageLabel("Involute", R.drawable.zlm_involute));
        characterImageLabels.add(new CharacterImageLabel("Revolute", R.drawable.zlm_revolute));
        characterImageLabels.add(new CharacterImageLabel("Lobed", R.drawable.zlm_lobed));
        characterImageLabels.add(new CharacterImageLabel("Cleft", R.drawable.zlm_cleft));
        characterImageLabels.add(new CharacterImageLabel("Incised", R.drawable.zlm_incised));
        characterImageLabels.add(new CharacterImageLabel("Pinnatifid", R.drawable.zlm_pinnatifid));
        characterImageLabels.add(new CharacterImageLabel("Lacerate", R.drawable.zlm_lacerate));
        characterImageLabels.add(new CharacterImageLabel("Laciniate", R.drawable.zlm_laciniate));

        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(LeafMargin.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(LeafMargin.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Entire");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Crenate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Sinuate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Crenulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Dentate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Denticulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Serrate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 7:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Doubly serrate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 8:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Serrulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Ciliate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Involute");
                        editor.commit();
                        startActivity(intent);
                        break;


                    case 11:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Revolute");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 12:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Lobed");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 13:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Cleft");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 14:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Incised");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 15:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Pinnatifid");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 16:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Lacerate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(LeafMargin.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafMargin", "Laciniate");
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
        menuInflater.inflate(R.menu.menu_main, menu);
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

            case R.id.action_skilltest:
                actionIntent = new Intent(this, ChallengeType.class);
                startActivity(actionIntent);
                return true;

            case R.id.acton_illustrations:
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

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}