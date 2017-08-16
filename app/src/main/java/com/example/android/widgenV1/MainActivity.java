package com.example.android.widgenV1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.color.black;
import static com.example.android.widgenV1.R.id.spinner_position;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    private static final String TAG = "MainActivity";
    String familyTest, genusTest, lifeHabitTest, growthHabitTest, leafTypeTest, arrangementTest,
            leafPositionTest, leafAttachmentTest, marginTest, venationTest, surfaceTest,
            shapeTest, baseTest, apexTest, corollaTest, symmetryTest, inflorescenceTest,
            colorTest, flowerPositionTest, flowerAttachmentTest, nullTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //        set the background_material color to white
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);


//        plantName.setText(namePlant);


        Resources res = getResources();

        final String[] scientificName = res.getStringArray(R.array.scientificName_array);

        String[] family = res.getStringArray(R.array.familyName_array);
        String[] genus = res.getStringArray(R.array.genusData_array);
        String[] lifeHabit = res.getStringArray(R.array.lifeHabitData_array);
        String[] growthHabit = res.getStringArray(R.array.growthHabitData_array);
        String[] leafType = res.getStringArray(R.array.leafTypeData_array);
        String[] leafArrangement = res.getStringArray(R.array.leafArrangementData_array);
        String[] leafPosition = res.getStringArray(R.array.leafPositionData_array);
        String[] leafAttachment = res.getStringArray(R.array.leafAttachmentData_array);
        String[] margin = res.getStringArray(R.array.marginData_array);
        String[] venation = res.getStringArray(R.array.venationData_array);
        String[] surface = res.getStringArray(R.array.surfaceData_array);
        String[] shape = res.getStringArray(R.array.shapeData_array);
        String[] base = res.getStringArray(R.array.baseData_array);
        String[] apex = res.getStringArray(R.array.apexData_array);
        String[] corolla = res.getStringArray(R.array.corollaData_array);
        String[] symmetry = res.getStringArray(R.array.symmetryData_array);
        String[] inflorescence = res.getStringArray(R.array.inflorescenceData_array);
        String[] color = res.getStringArray(R.array.colorData_array);
        String[] flowerPosition = res.getStringArray(R.array.flowerPositionData_array);
        String[] flowerAttachment = res.getStringArray(R.array.flowerAttachmentData_array);

        final String[][] charactersDataArray = new String[][]{family, genus, lifeHabit, growthHabit, leafType,
                leafArrangement, leafPosition, leafAttachment, margin, venation, surface, shape, base, apex,
                corolla, symmetry, inflorescence, color, flowerPosition, flowerAttachment};

        final Spinner spinner_familyTest = (Spinner) findViewById(R.id.spinner_family);
//      Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//      Use a customize spinner layout (spinner_layout).
                R.array.family_array, R.layout.spinner_layout);
//      Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_layout);
//      Apply the adapter to the spinner
        spinner_familyTest.setAdapter(adapter);

        final Spinner spinner_genus = (Spinner) findViewById(R.id.spinner_genus);
        ArrayAdapter<CharSequence> adapter_genus = ArrayAdapter.createFromResource(this,
                R.array.genus_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_genus.setAdapter(adapter_genus);

        final Spinner spinner_lifeHabit = (Spinner) findViewById(R.id.spinner_lifeHabit);
        ArrayAdapter<CharSequence> adapter_lifeHabit = ArrayAdapter.createFromResource(this,
                R.array.lifeHabit_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_lifeHabit.setAdapter(adapter_lifeHabit);

        final Spinner spinner_growthHabit = (Spinner) findViewById(R.id.spinner_growthHabit);
        ArrayAdapter<CharSequence> adapter_growthHabit = ArrayAdapter.createFromResource(this,
                R.array.growthHabit_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_growthHabit.setAdapter(adapter_growthHabit);

        final Spinner spinner_leafType = (Spinner) findViewById(R.id.spinner_leafType);
        ArrayAdapter<CharSequence> adapter_leafType = ArrayAdapter.createFromResource(this,
                R.array.leatType_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_leafType.setAdapter(adapter_leafType);

        final Spinner spinner_arrangement = (Spinner) findViewById(R.id.spinner_arrangement);
        ArrayAdapter<CharSequence> adapter_arrangement = ArrayAdapter.createFromResource(this,
                R.array.arrangement_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_arrangement.setAdapter(adapter_arrangement);

        final Spinner spinner_leafPosition = (Spinner) findViewById(R.id.spinner_leafPosition);
        ArrayAdapter<CharSequence> adapter_leafPosition = ArrayAdapter.createFromResource(this,
                R.array.leafPosition_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_leafPosition.setAdapter(adapter_leafPosition);

        final Spinner spinner_attachment = (Spinner) findViewById(R.id.spinner_attachment);
        ArrayAdapter<CharSequence> adapter_attachment = ArrayAdapter.createFromResource(this,
                R.array.attachment_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_attachment.setAdapter(adapter_attachment);

        final Spinner spinner_margin = (Spinner) findViewById(R.id.spinner_margin);
        ArrayAdapter<CharSequence> adapter_margin = ArrayAdapter.createFromResource(this,
                R.array.margin_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_margin.setAdapter(adapter_margin);

        final Spinner spinner_venation = (Spinner) findViewById(R.id.spinner_venation);
        ArrayAdapter<CharSequence> adapter_venation = ArrayAdapter.createFromResource(this,
                R.array.venation_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_venation.setAdapter(adapter_venation);

        final Spinner spinner_surface = (Spinner) findViewById(R.id.spinner_surface);
        ArrayAdapter<CharSequence> adapter_surface = ArrayAdapter.createFromResource(this,
                R.array.surface_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_surface.setAdapter(adapter_surface);

        final Spinner spinner_shape = (Spinner) findViewById(R.id.spinner_shape);
        adapter_surface = ArrayAdapter.createFromResource(this,
                R.array.shape_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_shape.setAdapter(adapter_surface);

        final Spinner spinner_base = (Spinner) findViewById(R.id.spinner_base);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.base_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_base.setAdapter(adapter);

        final Spinner spinner_apex = (Spinner) findViewById(R.id.spinner_apex);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.apex_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_apex.setAdapter(adapter);

        final Spinner spinner_corolla = (Spinner) findViewById(R.id.spinner_corolla);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.corolla_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_corolla.setAdapter(adapter);

        final Spinner spinner_symmetry = (Spinner) findViewById(R.id.spinner_symmetry);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.symmetry_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_symmetry.setAdapter(adapter);

        final Spinner spinner_inflorescence = (Spinner) findViewById(R.id.spinner_inflorescence);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.inflorescence_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_inflorescence.setAdapter(adapter);

        final Spinner spinner_color = (Spinner) findViewById(R.id.spinner_color);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.color_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_color.setAdapter(adapter);

        final Spinner spinner_flowerPosition = (Spinner) findViewById(spinner_position);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.position_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_flowerPosition.setAdapter(adapter);

        final Spinner spinner_flowerAttachment = (Spinner) findViewById(R.id.spinner_flowerAttachment);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.flowerAttachment_array, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner_flowerAttachment.setAdapter(adapter);


//      Set the content of corollaSpinner to the clicked image in corollaType.class
//        Intent intentCorolla = getIntent();
//        String corollaType = intentCorolla.getStringExtra("key2");

//        if (!corollaType.equals(null)) {
//        if (corollaType != null)  {
//            int spinnerPosition = adapter.getPosition(corollaType);
//            spinner_corolla.setSelection(spinnerPosition);
//            System.out.println("corollaType when true " + corollaType);
//        }
//            System.out.println("corollaType when false " + corollaType);
////          spinner_corolla.setSelection(0);
//
////        spinnerObject.setSelection(INDEX_OF_CATEGORY2)


        ImageView computeBtn = (ImageView) findViewById(R.id.button);
        final EditText percentMatchText = (EditText) findViewById(R.id.editTextPercentMatch);
        percentMatchText.getBackground().setColorFilter(getResources().getColor(black), PorterDuff.Mode.SRC_IN);

        percentMatchText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});


//        final double percentMatchInt = Double.parseDouble(percentMatchText.getText().toString());

        if (computeBtn != null) {

            computeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    if (!percentMatchInt = 0)

                    familyTest = spinner_familyTest.getSelectedItem().toString();
                    genusTest = spinner_genus.getSelectedItem().toString();
                    lifeHabitTest = spinner_lifeHabit.getSelectedItem().toString();
                    growthHabitTest = spinner_growthHabit.getSelectedItem().toString();
                    leafTypeTest = spinner_leafType.getSelectedItem().toString();
                    arrangementTest = spinner_arrangement.getSelectedItem().toString();
                    leafPositionTest = spinner_leafPosition.getSelectedItem().toString();
                    leafAttachmentTest = spinner_attachment.getSelectedItem().toString();
                    marginTest = spinner_margin.getSelectedItem().toString();
                    venationTest = spinner_venation.getSelectedItem().toString();
                    surfaceTest = spinner_surface.getSelectedItem().toString();
                    shapeTest = spinner_shape.getSelectedItem().toString();
                    baseTest = spinner_base.getSelectedItem().toString();
                    apexTest = spinner_apex.getSelectedItem().toString();
                    corollaTest = spinner_corolla.getSelectedItem().toString();
                    symmetryTest = spinner_symmetry.getSelectedItem().toString();
                    inflorescenceTest = spinner_inflorescence.getSelectedItem().toString();
                    colorTest = spinner_color.getSelectedItem().toString();
                    flowerPositionTest = spinner_flowerPosition.getSelectedItem().toString();
                    flowerAttachmentTest = spinner_flowerAttachment.getSelectedItem().toString();

                    String[] testCharacters = new String[]{familyTest, genusTest, lifeHabitTest, growthHabitTest,
                            leafTypeTest, arrangementTest, leafPositionTest, leafAttachmentTest, marginTest, venationTest, surfaceTest,
                            shapeTest, baseTest, apexTest, corollaTest, symmetryTest, inflorescenceTest, colorTest,
                            flowerPositionTest, flowerAttachmentTest};

//                    test to compute for numCriteria
                    int numCriteria = 0;
                    int counter = 0;
                    int counter2 = 0;
                    nullTest = "";

//                  test to compute for numCriteria
                    while (counter < testCharacters.length) {
                        if (!testCharacters[counter].equals(nullTest)) {
                            numCriteria = numCriteria + 1;
                            counter2 = counter2 + 1;
                        }
                        counter = counter + 1;
                    }

                    Log.i(TAG, "This is the number of test characters " + numCriteria);

                    switch (numCriteria) {

                        case 0:
                            Context context = getApplicationContext();
                            CharSequence text = "Please select at least 1 property for query.";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            break;

                        default:

//                  series of while tests to tally scores of each plant against tested characters
                            int numTestCharacters = 0;
                            int characCounter = 0;
                            int speciesCounter = 0;
                            int[] score = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                            int[] newScore = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                            while (numTestCharacters < testCharacters.length) {

                                while (speciesCounter < scientificName.length) {
                                    if (testCharacters[characCounter].equals(charactersDataArray[characCounter][speciesCounter])) {
                                        score[speciesCounter] = score[speciesCounter] + 1;
                                    }
                                    speciesCounter = speciesCounter + 1;
                                }
                                numTestCharacters = numTestCharacters + 1;
                                characCounter = characCounter + 1;
                                speciesCounter = 0;
                            }
//                    Convert int [] to Integer [] because int [] cant be processed since its primitive
                            Integer[] scoreIntArray = new Integer[score.length];
                            int i = 0;
                            for (int value : score) {
                                scoreIntArray[i++] = Integer.valueOf(value);
                            }

                    /*Sort the score by their indexes using comparator (requires Integer [] the result is
                    an array sorted in ascending order*/
                            IndexSorter comparator = new IndexSorter(scoreIntArray);
                            Integer[] indexes = comparator.createIndexArray();

                            Arrays.sort(indexes, comparator);

                            //      Rearrange the scores in indexes[] in descencding order
                            int[] sortedIndexes = new int[scientificName.length];
                            int index = 0;
                            int sorter = scientificName.length - 1;
                            while (sorter > -1) {
                                sortedIndexes[index] = indexes[sorter];
                                index = index + 1;
                                sorter = sorter - 1;
                            }

                            // arrays of scores of plants in descending order
                            int[] descScore = new int[scientificName.length];

                            int position = 0;

                            while (position < scientificName.length) {
                                descScore[position] = score[sortedIndexes[position]];
                                position = position + 1;
                            }

                            // List of probable answers matching desired score computed as desiredScore = %Match vs numCriteria
                            int finalCounter = 0;
                            ArrayList<String> finalList = new ArrayList<String>();

                            String string = percentMatchText.getText().toString();
                            System.out.println("This is string " + string);

                            double desiredScore;
                    /*percentMatch is the user's desired match in percent to avoid listing
                    too much informaiton*/
                            double percentMatchInt;

                            switch (string) {

                                case (""):
                                    percentMatchInt = 1;


                                    context = getApplicationContext();
                                    text = "Enter a value for PERCENT MATCH." + "\nDefault is 1";
                                    duration = Toast.LENGTH_LONG;

                                    toast = Toast.makeText(context, text, duration);
                                    ViewGroup group = (ViewGroup) toast.getView();
                                    TextView messageTextView = (TextView) group.getChildAt(0);
                                    messageTextView.setTextSize(16);
                                    messageTextView.setGravity(Gravity.CENTER);
                                    toast.show();


                                    break;

                                default:

                                    percentMatchInt = Double.parseDouble(percentMatchText.getText().toString());
                                    break;

                            }

                            double percentMatch = percentMatchInt / 100;
                            //        int roundedPercentMatch = (int) percentMatch;
                            desiredScore = (percentMatch * numCriteria);


                            while (descScore[finalCounter] >= desiredScore) {
                                finalList.add(scientificName[sortedIndexes[finalCounter]]);
                                finalCounter = finalCounter + 1;
                            }


                            System.out.println("Total number of points numCriteria " + numCriteria);
                            System.out.println("Desired score " + desiredScore);
                            System.out.println("Number of possible answer " + finalList.size());
                            System.out.println("This is final list based on percent match " + finalList);
                            System.out.println("This is the percentmatchInt " + percentMatchInt);

                            score = newScore;

                            int possibleId = finalList.size();
//                            display toast when no plants match the criteria
                            switch (possibleId) {

                                case 0:
                                    context = getApplicationContext();
                                    text = "No species found to match the property." + "\nTry other " +
                                            "properties";
                                    duration = Toast.LENGTH_LONG;

                                    toast = Toast.makeText(context, text, duration);
                                    ViewGroup group = (ViewGroup) toast.getView();
                                    TextView messageTextView = (TextView) group.getChildAt(0);
                                    messageTextView.setTextSize(16);
                                    messageTextView.setGravity(Gravity.CENTER);
                                    toast.show();

                                    break;
                                default:

                                    //                    ArrayList<String> finalPlantList = new ArrayList<String>();
                                    Intent intent = new Intent(MainActivity.this, PlantList.class);
                                    intent.putStringArrayListExtra("key", finalList);

                                    startActivity(intent);
                                    break;

                            }

                    }


                }
            });

        }

        ImageView clearEntries = (ImageView) findViewById(R.id.clear);

        clearEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner_familyTest.setSelection(0);
                spinner_apex.setSelection(0);
                spinner_arrangement.setSelection(0);
                spinner_attachment.setSelection(0);
                spinner_base.setSelection(0);
                spinner_color.setSelection(0);
                spinner_corolla.setSelection(0);
                spinner_flowerAttachment.setSelection(0);
                spinner_flowerPosition.setSelection(0);
                spinner_genus.setSelection(0);
                spinner_growthHabit.setSelection(0);
                spinner_inflorescence.setSelection(0);
                spinner_leafPosition.setSelection(0);
                spinner_leafType.setSelection(0);
                spinner_lifeHabit.setSelection(0);
                spinner_margin.setSelection(0);
                spinner_shape.setSelection(0);
                spinner_surface.setSelection(0);
                spinner_symmetry.setSelection(0);
                spinner_venation.setSelection(0);

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


    public void leafAttachment(View view) {
        Intent i = new Intent(getApplicationContext(), LeafAttachment.class);
        startActivity(i);
    }

    public void corollaPics(View view) {
        Intent i = new Intent(getApplicationContext(), CorollaType.class);
        startActivity(i);
    }


    public void growthHabit(View view) {
        Intent i = new Intent(getApplicationContext(), GrowthHabit.class);
        startActivity(i);
    }

    public void leafType(View view) {
        Intent i = new Intent(getApplicationContext(), LeafType.class);
        startActivity(i);
    }

    public void leafShapeClick(View view) {
        Intent i = new Intent(getApplicationContext(), LeafShape.class);
        startActivity(i);
    }

    public void leafArrangementClick(View view) {
        Intent i = new Intent(getApplicationContext(), LeafArrangement.class);
        startActivity(i);
    }

    public void inflorescence_click(View view) {
        Intent i = new Intent(getApplicationContext(), InflorescenceType.class);
        startActivity(i);
    }

    public void leafPositionCLick(View view) {
        Intent i = new Intent(MainActivity.this, LeafPosition.class);
        startActivity(i);
    }

    public void leafMarginClick(View view) {
        Intent i = new Intent(MainActivity.this, LeafMargin.class);
        startActivity(i);
    }

    public void leafBaseClick(View view) {
        Intent i = new Intent(MainActivity.this, LeafBase.class);
        startActivity(i);
    }

    public void leafApexClick(View view) {
        Intent i = new Intent(MainActivity.this, LeafApex.class);
        startActivity(i);
    }

    public void flowerSymmetry(View view) {
        Intent i = new Intent(MainActivity.this, FlowerSymmetry.class);
        startActivity(i);
    }

    public void leafVenationClick(View view) {
        Intent i = new Intent(MainActivity.this, LeafVenation.class);
        startActivity(i);
    }


}
