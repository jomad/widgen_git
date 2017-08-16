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

public class LeafBase extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Cuneate", R.drawable.zlb_cuneate));
        characterImageLabels.add(new CharacterImageLabel("Attenuate", R.drawable.zlb_attenuate));
        characterImageLabels.add(new CharacterImageLabel("Rounded", R.drawable.zlb_rounded));
        characterImageLabels.add(new CharacterImageLabel("Oblique", R.drawable.zlb_oblique));
        characterImageLabels.add(new CharacterImageLabel("Cordate", R.drawable.zls_cordate));
        characterImageLabels.add(new CharacterImageLabel("Truncate", R.drawable.zlb_truncate));
        characterImageLabels.add(new CharacterImageLabel("Hastate", R.drawable.zls_hastate));
        characterImageLabels.add(new CharacterImageLabel("Sagittate", R.drawable.zlb_sagittate));
        characterImageLabels.add(new CharacterImageLabel("Auriculate", R.drawable.zlb_auriculate));
        characterImageLabels.add(new CharacterImageLabel("Clasping", R.drawable.zlb_clasping));
        characterImageLabels.add(new CharacterImageLabel("Peltate", R.drawable.zlb_peltate));
        characterImageLabels.add(new CharacterImageLabel("Perfoliate", R.drawable.zlb_perfoliate));

        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(LeafBase.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(LeafBase.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Cuneate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Attenuate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Rounded");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Oblique");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Cordate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Truncate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Hastate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 7:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Sagittate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 8:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Auriculate");

                        editor.commit();
                        startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Clasping");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Peltate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(LeafBase.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafBase", "Perfoliate");
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