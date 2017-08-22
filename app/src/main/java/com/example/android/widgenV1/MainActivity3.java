package com.example.android.widgenV1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.color.black;
import static com.example.android.widgenV1.GrowthHabit.MY_PREFS_NAME;

public class MainActivity3 extends RootActivity{

    private static final String TAG = "MainActivity";
    private EditText editTextFamilyName, editTextGrowthHabit, editTextLifeHabit, editTextGenus,
            editTextLeafType, editTextLeafArrangement, editTextLeafPosition, editTextLeafAttachment,
            editTextLeafMargin, editTextLeafVenation, editTextLeafSurface, editTextLeafShape,
            editTextLeafBase, editTextLeafApex, editTextCorolla, editTextSymmetry, editTextInflorescence,
            editTextColor, editTextFlowerPosition, editTextFlowerAttachment;
    private Toolbar toolbar;
    private String familyTest,  genusTest, lifeHabitTest,growthHabitTest,leafTypeTest,arrangementTest,leafPositionTest,
            leafAttachmentTest, marginTest, venationTest, surfaceTest, shapeTest, baseTest, apexTest, corollaTest,
            symmetryTest, inflorescenceTest, colorTest, flowerPositionTest, flowerAttachmentTest, nullTest;

    private String [] growthHabitString;
    private Integer [] growthHabitImageArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        growthHabitString = new String[]{"Erect", "Shrub", "Ascending", "Cespitose", "Vine",
                            "Stoloniferous", "Repent", "Procumbent", "Decumbent", "Floating"};

        growthHabitImageArray = new Integer[] {R.mipmap.ic_launcher, R.drawable.zgh_shrub, R.drawable.zgh_ascending,
                R.drawable.zgh_cespitose, R.drawable.zgh_vine, R.drawable.zgh_stoloniferous, R.drawable.zgh_repent,
                R.drawable.zgh_procumbent, R.drawable.zgh_decumbent, R.mipmap.ic_launcher};

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextGrowthHabit = (EditText) findViewById(R.id.textView_growthHabit);
        editTextGrowthHabit.setFocusable(false);
        editTextGrowthHabit.setClickable(true);

        final SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        editTextGrowthHabit.setText(myPref[0].getString("growthHabit", ""));

        editTextLifeHabit = (EditText) findViewById(R.id.editText_lifeHabit_ii);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLifeHabit.setText(myPref[0].getString("lifehabit", ""));

        editTextFamilyName = (EditText) findViewById(R.id.editText_family);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextFamilyName.setText(myPref[0].getString("familyName", ""));

        editTextGenus = (EditText) findViewById(R.id.textView_genus);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextGenus.setText(myPref[0].getString("genus", ""));

        editTextLeafType = (EditText) findViewById(R.id.textView_leafType);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafType.setText(myPref[0].getString("leafType", ""));

        editTextLeafArrangement = (EditText) findViewById(R.id.textView_arrangement);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafArrangement.setText(myPref[0].getString("leafArrangement", ""));

        editTextLeafPosition = (EditText) findViewById(R.id.textView_leafPosition);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafPosition.setText(myPref[0].getString("leafPosition", ""));

        editTextLeafAttachment = (EditText) findViewById(R.id.textView_attachment);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafAttachment.setText(myPref[0].getString("leafAttachment", ""));

        editTextLeafMargin = (EditText) findViewById(R.id.textView_margin);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafMargin.setText(myPref[0].getString("leafMargin", ""));

        editTextLeafVenation = (EditText) findViewById(R.id.textView_venation);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafVenation.setText(myPref[0].getString("leafVenation", ""));

        editTextLeafSurface = (EditText) findViewById(R.id.textView_surface);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafSurface.setText(myPref[0].getString("leafSurface", ""));

        editTextLeafShape = (EditText) findViewById(R.id.textView_shape);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafShape.setText(myPref[0].getString("leafShape", ""));

        editTextLeafBase = (EditText) findViewById(R.id.textView_base);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafBase.setText(myPref[0].getString("leafBase", ""));

        editTextLeafApex = (EditText) findViewById(R.id.textView_apex);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextLeafApex.setText(myPref[0].getString("leafApex", ""));

        editTextCorolla = (EditText) findViewById(R.id.textView_corolla);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextCorolla.setText(myPref[0].getString("corolla", ""));

        editTextSymmetry = (EditText) findViewById(R.id.textView_symmetry);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextSymmetry.setText(myPref[0].getString("symmetry", ""));

        editTextInflorescence = (EditText) findViewById(R.id.textView_inflorescence);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextInflorescence.setText(myPref[0].getString("inflorescence", ""));

        editTextColor = (EditText) findViewById(R.id.textView_color);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextColor.setText(myPref[0].getString("color", ""));

        editTextFlowerPosition = (EditText) findViewById(R.id.textView_position);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextFlowerPosition.setText(myPref[0].getString("flowerPosition", ""));

        editTextFlowerAttachment = (EditText) findViewById(R.id.textView_flowerAttachment);
        myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editTextFlowerAttachment.setText(myPref[0].getString("flowerAttachment", ""));

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

        ImageButton computeBtn = (ImageButton) findViewById(R.id.button);

        /*final EditText percentMatchText = (EditText) findViewById(R.id.editTextPercentMatch);
        percentMatchText.getBackground().setColorFilter(getResources().getColor(black), PorterDuff.Mode.SRC_IN);
        percentMatchText.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});
*/
//      Running the program
        if (computeBtn != null) {

            computeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                  Get the input values by the user
                    familyTest = editTextFamilyName.getText().toString();
                    genusTest = editTextGenus.getText().toString();
                    lifeHabitTest = editTextLifeHabit.getText().toString();
                    growthHabitTest = editTextGrowthHabit.getText().toString();
                    leafTypeTest = editTextLeafType.getText().toString();
                    arrangementTest = editTextLeafArrangement.getText().toString();
                    leafPositionTest = editTextLeafPosition.getText().toString();
                    leafAttachmentTest = editTextLeafAttachment.getText().toString();
                    marginTest = editTextLeafMargin.getText().toString();
                    venationTest = editTextLeafVenation.getText().toString();
                    surfaceTest = editTextLeafSurface.getText().toString();
                    shapeTest = editTextLeafShape.getText().toString();
                    baseTest = editTextLeafBase.getText().toString();
                    apexTest = editTextLeafApex.getText().toString();
                    corollaTest = editTextCorolla.getText().toString();
                    symmetryTest = editTextSymmetry.getText().toString();
                    inflorescenceTest = editTextInflorescence.getText().toString();
                    colorTest = editTextColor.getText().toString();
                    flowerPositionTest = editTextFlowerPosition.getText().toString();
                    flowerAttachmentTest = editTextFlowerAttachment.getText().toString();

//                    Create an array of input values
                    String[] testCharacters = new String[]{familyTest, genusTest, lifeHabitTest, growthHabitTest,
                            leafTypeTest, arrangementTest, leafPositionTest, leafAttachmentTest, marginTest, venationTest, surfaceTest,
                            shapeTest, baseTest, apexTest, corollaTest, symmetryTest, inflorescenceTest, colorTest,
                            flowerPositionTest, flowerAttachmentTest};

//                    Getting the number of criterion set by the user to be used for percent match computation
                    int numCriteria = 0;
                    int counter = 0;
                    nullTest = "";

                    while (counter < testCharacters.length)
                    {
                        if (!testCharacters[counter].equals(nullTest))
                        {
                            numCriteria = numCriteria + 1;
                        }
                        counter = counter + 1;
                    }

                    Log.i(TAG, "This is the number of test characters " + numCriteria);

//                    Reminds the user if there are no criteria/on set to be checked
                    switch (numCriteria) {
                        case 0:
                            Context context = getApplicationContext();
                            CharSequence text = "Please select at least 1 property for query.";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            break;
                        default:

//                            Increments the score of each weed species based that matched a certain character
                            int numTestCharacters = 0;
                            int characCounter = 0;
                            int speciesCounter = 0;

//                            Sets initial scores to 0 before increments
                            int numberOfSpecies = scientificName.length;
                            int [] initialScore = new int[numberOfSpecies];
                            int scoreCounter = 0;
                            while (scoreCounter < numberOfSpecies) {
                                initialScore [scoreCounter] = 0;
                                scoreCounter += 1;
                            }

                            System.out.println("Resets score " + Arrays.toString(initialScore));
//                            incrementing initial scores
                            while (numTestCharacters < testCharacters.length) {
                                while (speciesCounter < scientificName.length) {
                                    if (!testCharacters[characCounter].equals(nullTest) &&
                                            (charactersDataArray[characCounter][speciesCounter]).
                                                    toLowerCase().contains(testCharacters[characCounter].
                                                    toLowerCase())) {
                                        initialScore[speciesCounter] = initialScore[speciesCounter] + 1;
                                    }
                                    speciesCounter = speciesCounter + 1;
                                }
                                numTestCharacters = numTestCharacters + 1;
                                characCounter = characCounter + 1;
                                speciesCounter = 0;
                            }
                            System.out.println("This is array of initial scores after test " + Arrays.toString(initialScore));
//
//                            Convert int [] to Integer [] because int [] cant be processed since its primitive
                            Integer[] scoreIntArray = new Integer[initialScore.length];
                            int i = 0;
                            for (int value : initialScore) {
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
//                            System.out.println("This is sortedIndexes array " + Arrays.toString(sortedIndexes));
                            // arrays of scores of plants in descending order
                            int[] descScore = new int[scientificName.length];

                            int position = 0;

                            while (position < scientificName.length) {
                                descScore[position] = initialScore[sortedIndexes[position]];
                                position = position + 1;
                            }
                            // List of probable answers matching desired score computed as desiredScore = %Match vs numCriteria
                            int finalCounter = 0;
                            ArrayList<String> finalList = new ArrayList<String>();
//                            Make an int [] to store percent score
                            ArrayList<String> percentScore = new ArrayList<>();

//                            System.out.println("This is string " + string);
//                            String string = percentMatchText.getText().toString();

                            double desiredScore;
                            /*percentMatch is the user's desired match in percent to avoid listing
                            too much informaiton*/
                            double percentMatchInt;

//                            switch (string) {
//
//                                case (""):
                                    percentMatchInt = 1;
/*
                                    context = getApplicationContext();
                                    text = "Enter a value for PERCENT MATCH." + "\nDefault is 1";
                                    duration = Toast.LENGTH_LONG;

                                    toast = Toast.makeText(context, text, duration);
                                    ViewGroup group = (ViewGroup) toast.getView();
                                    TextView messageTextView = (TextView) group.getChildAt(0);
                                    messageTextView.setTextSize(16);
                                    messageTextView.setGravity(Gravity.CENTER);
                                    toast.show();
*/


//                                    break;
//
//                                default:
//
//                                    percentMatchInt = Double.parseDouble(percentMatchText.getText().toString());
//                                    break;
//
//                            }

                            double percentMatch = percentMatchInt / 100;
                            //        int roundedPercentMatch = (int) percentMatch;
                            desiredScore = (percentMatch * numCriteria);

                            System.out.println("This is step 1");
                            while (descScore[finalCounter] >= desiredScore) {
                                finalList.add(scientificName[sortedIndexes[finalCounter]]);
                                percentScore.add(String.valueOf((int)(Math.round((descScore[finalCounter]/
                                        (numCriteria+0.0))*100)))+ "%");
                                finalCounter = finalCounter + 1;

                                System.out.println("String descScore/numCriteria - " +String.valueOf((int)(Math.round((descScore[finalCounter]/(numCriteria+0.0))*100))));
                            }
//                            double [] percentScoreArray = new double [finalList.size()];
//                            percentScoreArray = percentScore.toArray(percentScoreArray);

                            System.out.println("Final score array - " + percentScore.toString());



                            int [] indexForPicture = new int[finalList.size()];
                            for (i = 0; i<finalList.size(); i++) {
                                indexForPicture[i] = sortedIndexes[i];
                            }
                            System.out.println("This is the array for pictures " + Arrays.toString(indexForPicture));

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
//                                    Intent intent = new Intent(MainActivity2.this, PlantList.class);
                                    Intent intent = new Intent(MainActivity3.this, PlantListRecyclerView.class);
                                    intent.putStringArrayListExtra("list", finalList);
                                    intent.putExtra("arrayForPic", indexForPicture );
                                    intent.putStringArrayListExtra("percentScore", percentScore);
                                    startActivity(intent);
                                    break;
                            }
                    }
                }
            });
        }

        ImageButton clearEntries = (ImageButton) findViewById(R.id.clear);

        clearEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clear the editText forms but not the shared pref file
                clearForm((ViewGroup) findViewById(R.id.activity_main));

//                clears the shared pref files (not instant, reason why clear form is needed)
                myPref[0] = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = myPref[0].edit();
                editor.clear();
                editor.apply();
            }
        });

        TextView browseUrlImages = (TextView) findViewById(R.id.textView_gen_property);
        browseUrlImages.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity3.this, AllUrlImages.class);
                startActivity(intent);
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
                Toast.makeText(this, "You are in Weed Identification section", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_homepage:
                actionIntent = new Intent(this, FrontPage.class);
                startActivity(actionIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void growthHabit(View view) {
        Intent i = new Intent(getApplicationContext(), GrowthHabit.class);
        startActivity(i);
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText("");
            }

            if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
                clearForm((ViewGroup) view);
        }
    }

    public void leafAttachmentClick(View view) {
        Intent i = new Intent(getApplicationContext(), LeafAttachment.class);
        startActivity(i);
    }

    public void corollaPics(View view) {
        Intent i = new Intent(getApplicationContext(), CorollaType.class);
        startActivity(i);
    }

    public void leafType(View view) {
        Intent i = new Intent(getApplicationContext(), LeafType.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
        Intent i = new Intent(MainActivity3.this, LeafPosition.class);
        startActivity(i);
    }

    public void leafMarginClick(View view) {
        Intent i = new Intent(MainActivity3.this, LeafMargin.class);
        startActivity(i);
    }

    public void leafBaseClick(View view) {
        Intent i = new Intent(MainActivity3.this, LeafBase.class);
        startActivity(i);
    }

    public void leafApexClick(View view) {
        Intent i = new Intent(MainActivity3.this, LeafApex.class);
        startActivity(i);
    }

    public void flowerSymmetry(View view) {
        Intent i = new Intent(MainActivity3.this, FlowerSymmetry.class);
        startActivity(i);
    }

    public void leafVenationClick(View view) {
        Intent i = new Intent(MainActivity3.this, LeafVenation.class);
        startActivity(i);
    }

    public void flowerPositionClick(View view) {
        Intent i = new Intent(MainActivity3.this, FlowerPosition.class);
        startActivity(i);
    }

    public void flowerAttachmentClick(View view) {
        Intent i = new Intent(MainActivity3.this, FlowerAttachment.class);
        startActivity(i);
    }

    public void flowerColorClick(View view) {
        Intent i = new Intent(MainActivity3.this, FlowerColor.class);
        startActivity(i);
    }

    public void lifeHabitClick(View view) {
        Intent i = new Intent(MainActivity3.this, LifeHabit.class);
        startActivity(i);
    }

    public void famly_list_click(View view) {
        Intent i = new Intent(MainActivity3.this, FamilyNameSelector.class);
        startActivity(i);
    }

    public void genus_selector(View view) {
        Intent i = new Intent(MainActivity3.this, GenusSelector.class);
        startActivity(i);
    }

    public void del_family(View view) {
        editTextFamilyName.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("familyName");
        editor.apply();
    }

    public void del_genus(View view) {
        editTextGenus.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("genus");
        editor.apply();
    }

    public void del_lifeHabit(View view) {
        editTextLifeHabit.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("lifehabit");
        editor.apply();

    }

    public void del_growthHabit(View view) {
        editTextGrowthHabit.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("growthHabit");
        editor.apply();

    }

    public void del_leafType(View view) {
        editTextLeafType.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafType");
        editor.apply();
    }

    public void del_leafArrangement(View view) {
        editTextLeafArrangement.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafArrangement");
        editor.apply();
    }

    public void del_leafPosition(View view) {
        editTextLeafPosition.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafPosition");
        editor.apply();
    }

    public void del_leafAttachment(View view) {
        editTextLeafAttachment.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafAttachment");
        editor.apply();
    }

    public void del_leafMargin(View view) {
        editTextLeafMargin.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafMargin");
        editor.apply();
    }

    public void del_leafVenation(View view) {
        editTextLeafVenation.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafVenation");
        editor.apply();
    }

    public void del_leafSurface(View view) {
        editTextLeafSurface.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafSurface");
        editor.apply();
    }

    public void del_leafShape(View view) {
        editTextLeafVenation.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafShape");
        editor.apply();
    }

    public void del_leafBase(View view) {
        editTextLeafBase.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafBase");
        editor.apply();
    }

    public void del_leafApex(View view) {
        editTextLeafApex.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("leafApex");
        editor.apply();
    }

    public void del_corolla(View view) {
        editTextCorolla.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("corolla");
        editor.apply();
    }

    public void del_symmetry(View view) {
        editTextSymmetry.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("symmetry");
        editor.apply();
    }

    public void del_inflorescence(View view) {
        editTextInflorescence.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("inflorescence");
        editor.apply();
    }

    public void del_color(View view) {
        editTextColor.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("color");
        editor.apply();
    }

    public void del_flowerPosition(View view) {
        editTextFlowerPosition.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("flowerPosition");
        editor.apply();
    }

    public void del_flowerAttachment(View view) {
        editTextFlowerAttachment.setText("");
        SharedPreferences[] myPref = {getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)};
        SharedPreferences.Editor editor = myPref[0].edit();
        editor.remove("flowerAttachment");
        editor.apply();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }



}
