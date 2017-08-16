package com.example.android.widgenV1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SkillTest extends RootActivity {

    Toolbar toolbar;
    AutoCompleteTextView answerSheet;
    Random random = new Random();
    int mSearchIndex, mAnswerPosition, mCorrectAnswer, mNumOfTries, mCorrectAnswerIndex, maxRand,
        minRand;
    ImageView testImage;
    ArrayList <String> testListArray, arrayListName, drawableNameArray;
    String [] name, imageUrl;
    String mCorrectName;
    int resID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_test);

        Resources res = getResources();

        Intent i = getIntent();
        testListArray = i.getStringArrayListExtra("listTest");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//      add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//      testImage is the picture for exercise
        testImage = (ImageView) findViewById(R.id.image_test);
//        make instance of list of scientific name
        name = getResources().getStringArray(R.array.scientificName_array);
//        convert name array to arrayList to utilize easy indexing of elements
        arrayListName = new ArrayList<String>(Arrays.asList(name));
//        imageButton (arrow right) to generate pictures for idenfiticaiton
        ImageView generatePlant = (ImageView) findViewById(R.id.next_plant);
//        make an instance of array of drawable resources
        drawableNameArray = new ArrayList<>(Arrays.asList(getResources().
                getStringArray(R.array.drawable_resource)));

        imageUrl = res.getStringArray(R.array.imageUrl);

//        final String[] drawableNameArray = getResources().getStringArray(R.array.drawable_resource);
//        initialise an adapter for displaying list of name as answer in autocompleteTextView, aka answerSheet
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                name);
//        attach adapterView to answersheet
        answerSheet = (AutoCompleteTextView) findViewById(R.id.guess_editText);
        answerSheet.setAdapter(adapter);

//        generation of random number to be used in selecting pictures to be set in testImage
        maxRand = (testListArray.size()-1);
        minRand = 0;
//        generate testImage on click
        generatePlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        generate random number, an index, within scientific name list
                mSearchIndex = random.nextInt(maxRand - minRand + 1) + minRand;
                System.out.println("This is index " + mSearchIndex);
                System.out.println("This is arrayList size " + maxRand);
                System.out.println("This is the testListArray " + testListArray);

//              get the indexed plant name
                String mDrawableName = testListArray.get(mSearchIndex);
                System.out.println("THis is member of list " + mDrawableName);
//              get resource id that will be queried in the drawable resource and set as test image
                resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

                if (resID == 0) {
                    loadImageFromUrl(imageUrl[mSearchIndex]);
                } else {
                    testImage.setImageResource(resID);
                }
//                set testImage using generated resource ID from drawableNameArray
//                testImage.setImageResource(resID);
                System.out.println("This is the resId " + resID);
//                clear the answerSheet for next testImage
                answerSheet.setText(null);
                mCorrectAnswerIndex = drawableNameArray.indexOf(testListArray.get(mSearchIndex));
                mCorrectName = arrayListName.get(mCorrectAnswerIndex);
            }
    });
//      find the position of answer in autocompleteTextView for comparison with answerkey
        answerSheet.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                String selection = (String) parent.getItemAtPosition(position);
                mAnswerPosition = -1;

                for (int i = 0; i < name.length; i++) {
                    if (name[i].equals(selection)) {
                        mAnswerPosition = i;
                        break;
                    }
                }
                System.out.println("Position " + mAnswerPosition); //check it now in Logcat
            }
        });

        ImageView check = (ImageView) findViewById(R.id.check_answer);
        final TextView score = (TextView) findViewById(R.id.score_actual);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                mCorrectAnswerIndex = drawableNameArray.indexOf(testListArray.get(mSearchIndex));
//                mCorrectName = arrayListName.get(mCorrectAnswerIndex);
                System.out.println("This is correct answer " + mCorrectName);
                System.out.println("This is guess " + name[mAnswerPosition]);

                Boolean bool = name[mAnswerPosition].equals(mCorrectName);
                if (bool) {
                    Toast.makeText(SkillTest.this, "Correct!", Toast.LENGTH_SHORT).show();
                    mCorrectAnswer = mCorrectAnswer+1;

                }else {
                    Toast.makeText(SkillTest.this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
                }

                mNumOfTries = mNumOfTries +1;
                score.setText(mCorrectAnswer + "/" + mNumOfTries);
                answerSheet.setText(null);
            }
        });
        System.out.println("This is correct name " + arrayListName.get(mCorrectAnswerIndex));
        ImageView answerButton = (ImageView) findViewById(R.id.answer_button);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(SkillTest.this, "This is " + mCorrectName, Toast.LENGTH_SHORT).show();
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
    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.default_image)
                .into(testImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

}


