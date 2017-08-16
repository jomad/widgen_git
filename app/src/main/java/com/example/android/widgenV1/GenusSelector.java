package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

public class GenusSelector extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_name_selector);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final AutoCompleteTextView genusSelectorAutocomplete = (AutoCompleteTextView) findViewById
                (R.id.autocomplete_family_selector);

        genusSelectorAutocomplete.setHint("Enter genus");

        ArrayAdapter <String> genusSelectorAdapter = new ArrayAdapter<String>(this,R.layout.search_layout,
                getResources().getStringArray(R.array.genus_array));
        genusSelectorAutocomplete.setAdapter(genusSelectorAdapter);

        genusSelectorAutocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Intent intent = new Intent(GenusSelector.this, MainActivity2.class);
                String selectedItem = genusSelectorAutocomplete.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                editor.putString("genus", selectedItem);
                editor.apply();
//                System.out.println("This is the selectedItem " + selectedItem);
                startActivity(intent);
            }
        });

//        display genus on listview using adapter
        final ListView genusListView = (ListView) findViewById(R.id.family_listview);
        ArrayAdapter <String> lvArrayAdapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                getResources().getStringArray(R.array.genus_array));
        genusListView.setAdapter(lvArrayAdapter);

//        set selected item in genus listview as text in genus edittext in mainAc2
        genusListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GenusSelector.this, MainActivity2.class);
                String selectedItem = genusListView.getItemAtPosition(position).toString();
                System.out.println("This is selected item " + selectedItem);
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("genus", selectedItem);
                editor.apply();
                startActivity(intent);
            }
        });


    }
    public void back_mainActivity2(View view) {
        finish();
    }
}
