package com.example.android.widgenV1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchList extends RootActivity {

    Toolbar toolbar;
    String searchItem;
//    Resources res = getResources();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_acitivty);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        final ArrayList <String> scientificName = new ArrayList<String>(Arrays.asList(getResources().
//                getStringArray(R.array.scientificName_array)));

//        final ArrayList <String> englishName = new ArrayList<String>(Arrays.asList(getResources().
//                getStringArray(R.array.englishName_array)));
//
//        final ArrayList <String> commonName = new ArrayList<String>(Arrays.asList(getResources().
//                getStringArray(R.array.commonNameData)));

        final String[] sName = getResources().getStringArray(R.array.scientificName_array);
        final String [] cNameArray = getResources().getStringArray(R.array.commonNameData);
        final String [] eNameArray = getResources().getStringArray(R.array.englishName_array);
        final String [][] arrayOfArray = new String[][] {sName,cNameArray,eNameArray};


        ArrayList <String> searchList = new ArrayList<>();
        searchList.addAll(Arrays.asList(getResources().getStringArray(R.array.scientificName_array)));
        System.out.println("This is searchList plus size " + searchList.size() +searchList);
        searchList.addAll(Arrays.asList(getResources().getStringArray(R.array.englishName_array)));
        System.out.println("This is searchList plus size " + searchList.size() +searchList);
        searchList.addAll(Arrays.asList(getResources().getStringArray(R.array.commonNameData)));
        System.out.println("This is searchList plus size " + searchList.size() +searchList);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                searchList);

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search_item);
        autoCompleteTextView.setAdapter(adapter);

        ImageView search_button = (ImageView) findViewById(R.id.search_button);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String source = autoCompleteTextView.getText().toString();
                int index = -1;
                int arrayCounter = 0;
                while (index == -1) {
                    index = Arrays.asList(arrayOfArray[arrayCounter]).indexOf(source);
                    arrayCounter = arrayCounter +1;
                }
                System.out.println("This is the source " + source);
                System.out.println("This is the index " + index);

                String mselectedFromList = sName[index];
                Intent i = new Intent (getApplicationContext(),PlantProfile.class);
                i.putExtra("key2", mselectedFromList);
                startActivity(i);

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
}
