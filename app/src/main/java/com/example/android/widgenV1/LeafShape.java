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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

/**
 * Created by Don on 10/15/2016.
 */

public class LeafShape extends AppCompatActivity {
    Toolbar toolbar;
//    String mselectedFromList;
//    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Elliptic", R.drawable.zls_elliptic));
        characterImageLabels.add(new CharacterImageLabel("Falca", R.drawable.zls_falca));
        characterImageLabels.add(new CharacterImageLabel("Acicular", R.drawable.zls_acicular));
        characterImageLabels.add(new CharacterImageLabel("Linear", R.drawable.zls_linear));
        characterImageLabels.add(new CharacterImageLabel("Lanceolate", R.drawable.zls_lanceolate));
        characterImageLabels.add(new CharacterImageLabel("Oblanceolate", R.drawable.zls_oblanceolate));
        characterImageLabels.add(new CharacterImageLabel("Ovate", R.drawable.zls_ovate));
        characterImageLabels.add(new CharacterImageLabel("Obovate", R.drawable.zls_obovate));
        characterImageLabels.add(new CharacterImageLabel("Cordate", R.drawable.zls_cordate));
        characterImageLabels.add(new CharacterImageLabel("Obcordate", R.drawable.zls_obcordate));
        characterImageLabels.add(new CharacterImageLabel("Deltoid", R.drawable.zls_deltoid));
        characterImageLabels.add(new CharacterImageLabel("Hastate", R.drawable.zls_hastate));
        characterImageLabels.add(new CharacterImageLabel("Oblong", R.drawable.zls_oblong));
        characterImageLabels.add(new CharacterImageLabel("Oval", R.drawable.zls_oval));
        characterImageLabels.add(new CharacterImageLabel("Orbicular", R.drawable.zls_orbicular));
        characterImageLabels.add(new CharacterImageLabel("Reniform", R.drawable.zls_reniform));
        characterImageLabels.add(new CharacterImageLabel("Sagittate", R.drawable.zls_sagittate));
        characterImageLabels.add(new CharacterImageLabel("Spatulate", R.drawable.zls_spatulate));
        characterImageLabels.add(new CharacterImageLabel("Lyrate", R.drawable.zls_lyrate));
        characterImageLabels.add(new CharacterImageLabel("Runcinate", R.drawable.zls_runcinate));


        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(LeafShape.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(LeafShape.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Elliptic");
                        editor.apply();
//                        onBackPressed();
                        startActivity(intent);

                        break;

                    case 1:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Falca");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Acicular");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Linear");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Lanceolate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Oblanceolate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Ovate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 7:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Obovate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 8:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Cordate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Obcordate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Deltoid");
                        editor.commit();
                        startActivity(intent);
                        break;



                    case 11:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Hastate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 12:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Oblong");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 13:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Oval");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 14:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Orbicular");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 15:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Reniform");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 16:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Sagittate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 17:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Spatulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 18:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Lyrate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(LeafShape.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("leafShape", "Runcinate");
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