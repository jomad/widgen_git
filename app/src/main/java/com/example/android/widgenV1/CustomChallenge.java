package com.example.android.widgenV1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static android.media.CamcorderProfile.get;

public class CustomChallenge extends AppCompatActivity {

    String[] mWeedImages = {"passiflora_foetida", "ammannia_baccifera", "euphorbia_prostrata", "salvinia_molesta", "portulaca_oleracea",
            "crotalaria_mucronata", "aeschynomene_indica", "pseudoelephantopus_spicatus", "ruellia_tuberosa", "ludwigia_perennis",
            "peperomia_pellucida", "heliotropium_indicum", "pistia_stratiotes", "malvastrum_coromandelianum",
            "mimosa_invisa", "phyllanthus_amarus", "oxalis_corniculata", "ipomoea_aquatica", "ludwigia_adscendens",
            "cleome_rutidosperma", "euphorbia_heterophylla", "blechum_pyramidatum", "melochia_concatenata",
            "alternanthera_sessilis", "hyptis_brevipes", "borreria_laevis", "sphenoclea_zeylanica",
            "celosia_argentea", "sida_rhombifolia", "hedyotis_corymbosa", "arachis_pintoi", "commelina_diffusa",
            "ipomoea_triloba", "scoparia_dulcis", "euphorbia_hirta", "ludwigia_octovalvis", "commelina_benghalensis",
            "galinsoga_parviflora", "sida_acuta", "paspalidium_flavidum", "fimbristylis_miliacea"};

    ArrayList <String> mWeedWithImages = new ArrayList<String>();
    ArrayList <String> mNameList = new ArrayList<>();

    Toolbar toolbar;
    /*List grocery located in the resource file is copied into mgroceryList.... m global ata*/
    String[] mName;

    /**
     * Items entered by the user is stored in this ArrayList variable
     */
    ArrayList list = new ArrayList();

    /**
     * Declaring an ArrayAdapter to set items to ListView
     */
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_challenge);

        toolbar = (Toolbar) findViewById(R.id. toolbar);
        setSupportActionBar(toolbar);

        ImageView addToList = (ImageView) findViewById(R.id.add_tolist);

        //        make instance of list of scientific name
        mName = getResources().getStringArray(R.array.scientificName_array);

        mNameList = new ArrayList<>(Arrays.asList(mName));

//        mWeedWithImages = Arrays.asList(mWeedImages);
        mWeedWithImages = new ArrayList<>(Arrays.asList(mWeedImages));

        AutoCompleteTextView weedEntry = (AutoCompleteTextView) findViewById(R.id.enter_weed);

        ArrayAdapter<String> adapterEntry = new ArrayAdapter<String>(this, R.layout.search_layout,
                mName);
//        attach adapterView to weed entry

        weedEntry.setAdapter(adapterEntry);
        final ListView lv = (ListView) findViewById(R.id.list_weed);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /*edit is word typed in the enter item view*/
                AutoCompleteTextView edit = (AutoCompleteTextView) findViewById(R.id.enter_weed);
                /*convert edit to string input*/
                String input = edit.getText().toString();

                if (input.isEmpty()) {
                    edit.setText("");
                    Toast.makeText(getBaseContext(), "Enter weed name", Toast.LENGTH_LONG).show();
                    Log.i("CustomChallenge", "This input is null");

                } else if (!mNameList.contains(input)){
                    edit.setText("");
                    Toast.makeText(getBaseContext(), "Name already in the list.", Toast.LENGTH_LONG).show();

                } else if (!input.isEmpty()) {

                    Log.i("MainActivity", "The input is " + input);
                    list.add(input);
                    edit.setText("");
                    adapter.notifyDataSetChanged();
                    Log.i("MainActivity", "The input is " + list);
                }
            }
        });


        ImageView removeFromList = (ImageView) findViewById(R.id.delete_from_list);

        removeFromList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Getting the checked items from the listview */
                SparseBooleanArray checkedItemPositions = lv.getCheckedItemPositions();
                int itemCount = lv.getCount();

                for (int i = itemCount - 1; i >= 0; i--) {
                    if (checkedItemPositions.get(i)) {
                        adapter.remove(list.get(i));
                    }
                }
                checkedItemPositions.clear();
                adapter.notifyDataSetChanged();
                System.out.println("This is the weed list " + list);
            }
        });

        lv.setAdapter(adapter);

        ImageView proceed = (ImageView) findViewById(R.id.proceed);

//        convert name array into arrayList for easier extraction of index
        final ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(mName));
        final ArrayList<String> drawableList = new ArrayList<>(Arrays.asList(getResources().
                getStringArray(R.array.drawable_resource)));

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                convert the list of weeds in list arrayList into indexes
                ArrayList<Integer> testWeedIndex = new ArrayList<Integer>();
                int weedIndex;
                int index = 0;
                int listSize = list.size();
                while (index < listSize) {
                    weedIndex = nameList.indexOf(list.get(index));
                    System.out.println("Joden Adiova " + weedIndex);
                    testWeedIndex.add(weedIndex);
                    System.out.println("Joden Adiova 1" + testWeedIndex);
                    index = index + 1;
                }
                System.out.println("Joden Adiova 0" + testWeedIndex);
                System.out.println("Joden Adiova 1");
                ArrayList<String> testListArray = new ArrayList<String>();
                System.out.println("Joden Adiova 2");
                String drawableItem;
                System.out.println("Joden Adiova 3");
                int indexCounter = 0;
                while (indexCounter < testWeedIndex.size()) {
                    drawableItem = drawableList.get(testWeedIndex.get(indexCounter));
                    testListArray.add(drawableItem);
                    indexCounter = indexCounter + 1;
                    System.out.println("Joden Adiova 4");
                }
                System.out.println("This is the drawable list " + testListArray);

                Intent i = new Intent(CustomChallenge.this, SkillTestCustom.class);
                i.putStringArrayListExtra("listTest", testListArray);
                startActivity(i);
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

    public void load_weed_with_images(View view) {
        Intent i = new Intent(CustomChallenge.this, SkillTestCustom.class);
        i.putStringArrayListExtra("listTest", mWeedWithImages);
        startActivity(i);
    }
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
