package com.example.android.widgenV1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ChallengeType extends AppCompatActivity {

    Toolbar toolbar;
    String [] testList;
    ArrayList <String> testListArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_type);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        testList = getResources().getStringArray(R.array.drawable_resource);
        testListArray = new ArrayList<>(Arrays.asList(testList));




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
                Toast.makeText(this, "You are in Skills Test section", Toast.LENGTH_SHORT).show();
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

    public void challenge_one(View view) {
        Intent i = new Intent(ChallengeType.this, SkillTest.class);
        i.putStringArrayListExtra("listTest", testListArray);
        startActivity(i);

    }

    public void challenge_two(View view) {
        Intent x = new Intent(ChallengeType.this, CustomChallenge.class);
        startActivity(x);

    }

    public void back_previous(View view) {
        finish();
    }
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}




