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

import java.util.ArrayList;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

/**
 * Created by Don on 10/16/2016.
 */

public class InflorescenceType extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Solitary", R.drawable.zft_rotate));
        characterImageLabels.add(new CharacterImageLabel("Glomerule", R.drawable.zit_glomerule));
        characterImageLabels.add(new CharacterImageLabel("Raceme", R.drawable.zit_raceme));
        characterImageLabels.add(new CharacterImageLabel("Panicle", R.drawable.zit_panicle));
        characterImageLabels.add(new CharacterImageLabel("Spike", R.drawable.zit_spike));
        characterImageLabels.add(new CharacterImageLabel("Catkin", R.drawable.zit_catkin));
        characterImageLabels.add(new CharacterImageLabel("Head", R.drawable.zit_head));
        characterImageLabels.add(new CharacterImageLabel("Umbels", R.drawable.zit_umbels));
        characterImageLabels.add(new CharacterImageLabel("Corymbs", R.drawable.zit_corymbs));
        characterImageLabels.add(new CharacterImageLabel("Cymes", R.drawable.zit_cymes));
        characterImageLabels.add(new CharacterImageLabel("Thyrse", R.drawable.zit_thyrse));
        characterImageLabels.add(new CharacterImageLabel("Verticil", R.drawable.zit_verticil));
        characterImageLabels.add(new CharacterImageLabel("Spadix and spathe", R.drawable.zit_spadix_spathe));



        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(getApplicationContext(), characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Solitary");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Glomerule");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Raceme");

                        editor.commit();
                        startActivity(intent);
                        break;


                    case 3:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Panicle");
                        editor.commit();
                        startActivity(intent);
                        break;


                    case 4:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Spike");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Catkin");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Head");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 7:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Umbel");
                        editor.commit();
                        startActivity(intent);
                        break;



                    case 8:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Corymb");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Cyme");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Thyrse");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 11:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Verticil");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(InflorescenceType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("inflorescence", "Spadix");
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