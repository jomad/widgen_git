package com.example.android.widgenV1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FrontPage extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
//  Make the orientation locked to portrait
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void weed_id_activity(View view) {
        Intent i = new Intent(FrontPage.this, MainActivity2.class);
        startActivity(i);

    }

    public void browse_list(View view) {
        Intent i = new Intent(FrontPage.this, BrowsePlant.class);
        startActivity(i);
    }

    public void go_skills(View view) {
        Intent i = new Intent(FrontPage.this, ChallengeType.class);
        startActivity(i);
    }

    public void about_app(View view) {
        Intent i = new Intent(FrontPage.this, SpinnerActivity.class);
        startActivity(i);
    }
}
