package com.example.android.widgenV1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class BrowsePlant extends AppCompatActivity {

    Toolbar toolbar;

    ImageView imageView;
    String[] imageUrl;
    int index;
    String[] drawableName;
    String namePlant;
    ArrayList<String> finalList;
    int resIDSearchActivity;
    int indexNamePlant;

    String[] eNameArray, scientificName;

    // Hold a reference to the current animator,
    // so that it can be canceled mid-way.
    private Animator mCurrentAnimator;

    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int mShortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_browse);

        //        add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();

        drawableName = res.getStringArray(R.array.drawable_resource);
        eNameArray = res.getStringArray(R.array.englishName_array);
        scientificName = res.getStringArray(R.array.scientificName_array);
        imageUrl = res.getStringArray(R.array.imageUrl);

        final String[] family = res.getStringArray(R.array.familyName_array);
        final String[] commonName = res.getStringArray(R.array.commonNameData);
        String[] genus = res.getStringArray(R.array.genusData_array);
        final String[] lifeHabit = res.getStringArray(R.array.lifeHabitData_array);
        final String[] growthHabit = res.getStringArray(R.array.growthHabitData_array);
        String[] leafType = res.getStringArray(R.array.leafTypeData_array);
        final String[] leafArrangement = res.getStringArray(R.array.leafArrangementData_array);
        String[] leafPosition = res.getStringArray(R.array.leafPositionData_array);
        String[] leafAttachment = res.getStringArray(R.array.leafAttachmentData_array);
        final String[] margin = res.getStringArray(R.array.marginData_array);
        final String[] venation = res.getStringArray(R.array.venationData_array);
        String[] surface = res.getStringArray(R.array.surfaceData_array);
        final String[] shape = res.getStringArray(R.array.shapeData_array);
        final String[] base = res.getStringArray(R.array.baseData_array);
        final String[] apex = res.getStringArray(R.array.apexData_array);
        final String[] corolla = res.getStringArray(R.array.corollaData_array);
        String[] symmetry = res.getStringArray(R.array.symmetryData_array);
        final String[] inflorescence = res.getStringArray(R.array.inflorescenceData_array);
        final String[] color = res.getStringArray(R.array.colorData_array);
        String[] flowerPosition = res.getStringArray(R.array.flowerPositionData_array);
        String[] flowerAttachment = res.getStringArray(R.array.flowerAttachmentData_array);


        final ArrayList<String> sNameListArray = new ArrayList<>(Arrays.asList(scientificName));

        final String[][] arrayOfArray = new String[][]{scientificName, commonName, eNameArray};
        ArrayList<String> searchList = new ArrayList<>();

        searchList.addAll(Arrays.asList(scientificName));
        searchList.addAll(Arrays.asList(commonName));
        searchList.addAll(Arrays.asList(eNameArray));


        final TextView plantName = (TextView) findViewById(R.id.plant_id);

        imageView = (ImageView) findViewById(R.id.plant_ImageView);

        final TextView familyX = (TextView) findViewById(R.id.editText_family);
        final TextView commonX = (TextView) findViewById(R.id.editText_common);
        final TextView lifeHabitX = (TextView) findViewById(R.id.editText_lifeHabit);
        final TextView growthHabitX = (TextView) findViewById(R.id.editText_growthHabit);
        final TextView leafArrangmentX = (TextView) findViewById(R.id.editText_leafArrangement);
        final TextView leafShapeX = (TextView) findViewById(R.id.editText_leafShape);
        final TextView leafMarginX = (TextView) findViewById(R.id.editText_leafMargin);
        final TextView leafBaseX = (TextView) findViewById(R.id.editText_leafBase);
        final TextView leafAPexX = (TextView) findViewById(R.id.editText_leafApex);
        final TextView venationX = (TextView) findViewById(R.id.editText_venation);
        final TextView inflorescenceX = (TextView) findViewById(R.id.editText_inflorescence);
        final TextView corollaX = (TextView) findViewById(R.id.editText_corolla);
        final TextView colorX = (TextView) findViewById(R.id.editText_color);



        System.out.println("This is the the index of plant " + namePlant + " " + index);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.search_layout,
                searchList);

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search_item);

        autoCompleteTextView.setAdapter(adapter);

        ImageView searchButton = (ImageView) findViewById(R.id.search_profile);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = autoCompleteTextView.getText().toString();
//                check the index of source in the 3 arrays in arrayOfArray, since -1 means object
//                is not present in an array, positive index will tell the position
                int index = -1;
                int arrayCounter = 0;
                while (index == -1 && arrayCounter < arrayOfArray.length) {
                    index = Arrays.asList(arrayOfArray[arrayCounter]).indexOf(source);
                    arrayCounter = arrayCounter + 1;
                }

                switch (index) {
                    case -1:
                        Toast.makeText(BrowsePlant.this, "Name not found", Toast.LENGTH_LONG).show();
                        break;

                    default:
                        namePlant = scientificName[index];

                        indexNamePlant = sNameListArray.indexOf(namePlant);
                        plantName.setText(namePlant);
//        System.out.println(Arrays.asList(scientificName).indexOf("Cyathula prostrata"));
                        System.out.println("This is the the index of plant " + namePlant + " " + index);

//        get resource ID of drawable name to be set on imageview
                        String mDrawableName = drawableName[indexNamePlant];
                        resIDSearchActivity = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());

//          0 resIDSearchActivity means it is not present in the list, so load image from url array
                        if (resIDSearchActivity == 0) {
                            loadImageFromUrl(imageUrl[indexNamePlant]);
                        } else {
                            imageView.setImageResource(resIDSearchActivity);
                        }


                        familyX.setText(family[indexNamePlant]);
                        commonX.setText(commonName[indexNamePlant]);
                        leafArrangmentX.setText(leafArrangement[indexNamePlant]);
                        lifeHabitX.setText(lifeHabit[indexNamePlant]);
                        growthHabitX.setText(growthHabit[indexNamePlant]);
                        leafShapeX.setText(shape[indexNamePlant]);
                        leafMarginX.setText(margin[indexNamePlant]);
                        leafBaseX.setText(base[indexNamePlant]);
                        leafAPexX.setText(apex[indexNamePlant]);
                        venationX.setText(venation[indexNamePlant]);
                        inflorescenceX.setText(inflorescence[indexNamePlant]);
                        corollaX.setText(corolla[indexNamePlant]);
                        colorX.setText(color[indexNamePlant]);

                }


            }

        });

        // Hook up clicks on the thumbnail views.

        final View thumb1View = findViewById(R.id.plant_ImageView);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                index = Arrays.asList(scientificName).indexOf(plantName.getText().toString());
                String mDrawableName = drawableName[index];
                resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                zoomImageFromThumb(thumb1View, resID);*/

                Intent i = new Intent(BrowsePlant.this, ZoomedSearchImage.class);
                i.putExtra("imageUrl", imageUrl[indexNamePlant]);
                i.putExtra("resID", resIDSearchActivity);
                i.putExtra("plantNameForDisplay", namePlant);
                startActivity(i);
                System.out.println("This is imageUrl and resID " + imageUrl[index] + " " + resIDSearchActivity);
                System.out.println("This is true imageUrl " + imageUrl[indexNamePlant]);
            }
        });

           }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.default_image)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);
        expandedImageView.setImageResource(imageResId);

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        // The start bounds are the global visible rectangle of the thumbnail,
        // and the final bounds are the global visible rectangle of the container
        // view. Also set the container view's offset as the origin for the
        // bounds, since that's the origin for the positioning animation
        // properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container)
                .getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        // Adjust the start bounds to be the same aspect ratio as the final
        // bounds using the "center crop" technique. This prevents undesirable
        // stretching during the animation. Also calculate the start scaling
        // factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation
        // begins, it will position the zoomed-in view in the place of the
        // thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
                View.SCALE_Y, startScale, 1f));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentAnimator != null) {
                    mCurrentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expandedImageView, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.Y, startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expandedImageView,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(mShortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expandedImageView.setVisibility(View.GONE);
                        mCurrentAnimator = null;
                    }
                });
                set.start();
                mCurrentAnimator = set;
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
                Toast.makeText(this, "You are in Search by Name section", Toast.LENGTH_SHORT).show();
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

    public void back_previous(View view) {
        finish();
    }
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
