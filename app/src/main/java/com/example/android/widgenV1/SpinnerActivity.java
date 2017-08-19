package com.example.android.widgenV1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        String[] growthHabitString = new String[]{"Erect", "Shrub", "Ascending", "Cespitose", "Vine",
                "Stoloniferous", "Repent", "Procumbent", "Decumbent", "Floating"};

        Integer[] growthHabitImageArray = new Integer[]{R.mipmap.ic_launcher, R.drawable.zgh_shrub, R.drawable.zgh_ascending,
                R.drawable.zgh_cespitose, R.drawable.zgh_vine, R.drawable.zgh_stoloniferous, R.drawable.zgh_repent,
                R.drawable.zgh_procumbent, R.drawable.zgh_decumbent, R.mipmap.ic_launcher};

        TextView text = (TextView) findViewById(R.id.spinnerTextView);
        ImageView imageView =(ImageView)findViewById(R.id.spinnerImages);
        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);

        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_growthhabit_layout, growthHabitString, growthHabitImageArray);
        spinner.setAdapter(adapter);
    }
}
