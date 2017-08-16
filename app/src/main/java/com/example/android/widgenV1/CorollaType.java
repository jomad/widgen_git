package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class CorollaType extends AppCompatActivity {

    String mselectedFromList;
    Toolbar toolbar;
    ImageView infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corolla_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<CharacterImageLabel> characterImageLabels = new ArrayList<CharacterImageLabel>();

        characterImageLabels.add(new CharacterImageLabel("Rotate", R.drawable.zft_rotate));
        characterImageLabels.add(new CharacterImageLabel("Cruciform", R.drawable.zft_cruciform));
        characterImageLabels.add(new CharacterImageLabel("Salverform", R.drawable.zft_salverform));
        characterImageLabels.add(new CharacterImageLabel("Tubular", R.drawable.zft_tubular));
        characterImageLabels.add(new CharacterImageLabel("Ligulate", R.drawable.zft_ligulate));
        characterImageLabels.add(new CharacterImageLabel("Funnelform", R.drawable.zft_funnelform));
        characterImageLabels.add(new CharacterImageLabel("Coronate", R.drawable.zft_coronate));
        characterImageLabels.add(new CharacterImageLabel("Campanulate", R.drawable.zft_campanulate));
        characterImageLabels.add(new CharacterImageLabel("Bilabiate", R.drawable.zft_bilabiate));
        characterImageLabels.add(new CharacterImageLabel("Papilionaceaous", R.drawable.zft_papilionaceaous));
        characterImageLabels.add(new CharacterImageLabel("Carinate", R.drawable.zft_carinate));
        characterImageLabels.add(new CharacterImageLabel("Palate", R.drawable.zft_palate));
        characterImageLabels.add(new CharacterImageLabel("Spurred", R.drawable.zft_spurred));
        characterImageLabels.add(new CharacterImageLabel("Gibbous", R.drawable.zft_gibbous));
        characterImageLabels.add(new CharacterImageLabel("Urceolate", R.drawable.zft_urceolate));
        characterImageLabels.add(new CharacterImageLabel("Saccate", R.drawable.zft_saccate));
        characterImageLabels.add(new CharacterImageLabel("Galeate", R.drawable.zft_galeate));
        characterImageLabels.add(new CharacterImageLabel("Hood and horn", R.drawable.zft_hood_and_horn));

        CharacterImageAdapter imageAdapter = new CharacterImageAdapter(CorollaType.this, characterImageLabels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView gridView = (GridView) findViewById(R.id.gridview_bread);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(CorollaType.this, MainActivity2.class);
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Rotate");
                        editor.commit();
                        parent.setSelection(15);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Cruciform");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Salverform");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Tubular");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Ligulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Funnelform");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 6:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Coronate");

                        editor.commit();
                        startActivity(intent);
                        break;

                    case 7:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Campanulate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 8:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Bilabiate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 9:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Papilionaceous");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 10:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Carinate");
                        editor.commit();
                        startActivity(intent);
                        break;



                    case 11:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Palate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 12:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Spurred");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 13:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Gibbous");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 14:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Urceolate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 15:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Saccate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    case 16:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Galeate");
                        editor.commit();
                        startActivity(intent);
                        break;

                    default:
                        intent = new Intent(CorollaType.this, MainActivity2.class);
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("corolla", "Hood and horn");
                        editor.commit();
                        startActivity(intent);
                        break;
                }
            }
        });


//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
////                Toast.makeText(CorollaType.this, "" + position,
////                        Toast.LENGTH_SHORT).show();
//
//                switch (position) {
//                    case 0:
//                        Intent intentCorolla = new Intent(CorollaType.this, MainActivity.class);
//                        intentCorolla.putExtra("key2", "Cruciform");
//                        CorollaType.this.startActivity(intentCorolla);
//                        break;
//
//
//                    default:
//                        Intent ii = new Intent(CorollaType.this,MainActivity.class);
//                        CorollaType.this.startActivity(ii);
//                        break;
//                }
//            }
//        });
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
