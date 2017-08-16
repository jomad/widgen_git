package com.example.android.widgenV1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

public class FamilyNameSelector extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_name_selector);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final AutoCompleteTextView familySelectorAutocomplete = (AutoCompleteTextView) findViewById
                (R.id.autocomplete_family_selector);

        System.out.println("This is the selectedItem " + "Joden");

        familySelectorAutocomplete.setHint("Enter family name");

        ArrayAdapter <String> familySelectorAdapter = new ArrayAdapter<String>(this,R.layout.search_layout,
                getResources().getStringArray(R.array.family_array));
        familySelectorAutocomplete.setAdapter(familySelectorAdapter);

        System.out.println("This is the selectedItem " + "Joden");

        familySelectorAutocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Intent intent = new Intent(FamilyNameSelector.this, MainActivity2.class);
                String selectedItem = familySelectorAutocomplete.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

                editor.putString("familyName", selectedItem);
                editor.apply();
//                System.out.println("This is the selectedItem " + selectedItem);
                startActivity(intent);
            }
        });

        final ListView familyListView = (ListView) findViewById(R.id.family_listview);
        ArrayAdapter <String> lvArrayAdapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                getResources().getStringArray(R.array.family_array));
        familyListView.setAdapter(lvArrayAdapter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FamilyNameSelector.this, MainActivity2.class);
//                position = familyListView.getSelectedItemPosition();
                String selectedItem = familyListView.getItemAtPosition(position).toString();
                System.out.println("This is selected item " + selectedItem);
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("familyName", selectedItem);
                editor.apply();
                startActivity(intent);
            }
        });
    }

    public void back_mainActivity2(View view) {
        finish();
    }
}
