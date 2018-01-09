package com.example.mani.scanner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String WELCOME_KIT = "welcomeKit";
    private static final String ENTER_HALL1 = "hall1Entry";
    private static final String ENTER_HALL2 = "hall2Entry";
    private static final String ENTER_HALL3 = "hall3Entry";
    private static final String ENTER_HALL4 = "hall4Entry";
    private static final String ENTER_HALL5 = "hall5Entry";
    private static final String EXIT_HALL1 = "hall1Exit";
    private static final String EXIT_HALL2 = "hall2Exit";
    private static final String EXIT_HALL3 = "hall3Exit";
    private static final String EXIT_HALL4 = "hall4Exit";
    private static final String EXIT_HALL5 = "hall5Exit";
    private static final String BULK_HALL1 = "hall1";
    private static final String BULK_HALL2 = "hall2";
    private static final String BULK_HALL3 = "hall3";
    private static final String BULK_HALL4 = "hall4";
    private static final String BULK_HALL5 = "hall5";

    private static final String LUNCH_DAY1 = "lunch1";
    private static final String LUNCH_DAY2 = "lunch2";
    private static final String LUNCH_DAY3 = "lunch3";


    private Button mWelcomeButton, mEnteryHall1, mEnteryHall2, mEnteryHall3, mEnteryHall4, mEnteryHall5;
    private Button mExitHall1, mExitHall2, mExitHall3, mExitHall4, mExitHall5;
    private Button mBulk1, mBulk2, mBulk3, mBulk4, mBulk5;
    private Button mLunchDay1, mLunchDay2, mLunchDay3;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Welocome kit button
        mWelcomeButton = (Button) findViewById(R.id.btn_welcome_kit);

        //Entry buttons
        mEnteryHall1 = (Button) findViewById(R.id.btn_enter_hall1);
        mEnteryHall2 = (Button) findViewById(R.id.btn_enter_hall2);
        mEnteryHall3 = (Button) findViewById(R.id.btn_enter_hall3);
        mEnteryHall4 = (Button) findViewById(R.id.btn_enter_hall4);
        mEnteryHall5 = (Button) findViewById(R.id.btn_enter_hall5);

        //Exit buttons
        mExitHall1 = (Button) findViewById(R.id.btn_exit_hall1);
        mExitHall2 = (Button) findViewById(R.id.btn_exit_hall2);
        mExitHall3 = (Button) findViewById(R.id.btn_exit_hall3);
        mExitHall4 = (Button) findViewById(R.id.btn_exit_hall4);
        mExitHall5 = (Button) findViewById(R.id.btn_exit_hall5);

        //Bulk exit Buttons
        mBulk1 = (Button) findViewById(R.id.btn_bulkexit_hall1);
        mBulk2 = (Button) findViewById(R.id.btn_bulkexit_hall2);
        mBulk3 = (Button) findViewById(R.id.btn_bulkexit_hall3);
        mBulk4 = (Button) findViewById(R.id.btn_bulkexit_hall4);
        mBulk5 = (Button) findViewById(R.id.btn_bulkexit_hall5);

        //Lunch Buttons
        mLunchDay1 = (Button) findViewById(R.id.btn_lunch_day1);
        mLunchDay2 = (Button) findViewById(R.id.btn_lunch_day2);
        mLunchDay3 = (Button) findViewById(R.id.btn_lunch_day3);


        mWelcomeButton.setOnClickListener(this);

        mEnteryHall1.setOnClickListener(this);
        mEnteryHall2.setOnClickListener(this);
        mEnteryHall3.setOnClickListener(this);
        mEnteryHall4.setOnClickListener(this);
        mEnteryHall5.setOnClickListener(this);

        mExitHall1.setOnClickListener(this);
        mExitHall2.setOnClickListener(this);
        mExitHall3.setOnClickListener(this);
        mExitHall4.setOnClickListener(this);
        mExitHall5.setOnClickListener(this);

        mBulk1.setOnClickListener(this);
        mBulk2.setOnClickListener(this);
        mBulk3.setOnClickListener(this);
        mBulk4.setOnClickListener(this);
        mBulk5.setOnClickListener(this);

        mLunchDay1.setOnClickListener(this);
        mLunchDay2.setOnClickListener(this);
        mLunchDay3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_welcome_kit:
                Intent intent = new Intent(mContext, VolleyRequestActivity.class);
                intent.putExtra("scanType", WELCOME_KIT);
                startActivity(intent);
            case R.id.btn_enter_hall1:
                Intent intentEnter1 = new Intent(mContext, VolleyRequestActivity.class);
                intentEnter1.putExtra("scanType", ENTER_HALL1);
                startActivity(intentEnter1);
            case R.id.btn_enter_hall2:
                Intent intentEnter2 = new Intent(mContext, VolleyRequestActivity.class);
                intentEnter2.putExtra("scanType", ENTER_HALL2);
                startActivity(intentEnter2);
            case R.id.btn_enter_hall3:
                Intent intentEnter3 = new Intent(mContext, VolleyRequestActivity.class);
                intentEnter3.putExtra("scanType", ENTER_HALL3);
                startActivity(intentEnter3);
            case R.id.btn_enter_hall4:
                Intent intentEnter4 = new Intent(mContext, VolleyRequestActivity.class);
                intentEnter4.putExtra("scanType", ENTER_HALL4);
                startActivity(intentEnter4);
            case R.id.btn_enter_hall5:
                Intent intentEnter5 = new Intent(mContext, VolleyRequestActivity.class);
                intentEnter5.putExtra("scanType", ENTER_HALL5);
                startActivity(intentEnter5);
            case R.id.btn_exit_hall1:
                Intent intentExit1 = new Intent(mContext, VolleyRequestActivity.class);
                intentExit1.putExtra("scanType", EXIT_HALL1);
                startActivity(intentExit1);
            case R.id.btn_exit_hall2:
                Intent intentExit2 = new Intent(mContext, VolleyRequestActivity.class);
                intentExit2.putExtra("scanType", EXIT_HALL2);
                startActivity(intentExit2);
            case R.id.btn_exit_hall3:
                Intent intentExit3 = new Intent(mContext, VolleyRequestActivity.class);
                intentExit3.putExtra("scanType", EXIT_HALL3);
                startActivity(intentExit3);
            case R.id.btn_exit_hall4:
                Intent intentExit4 = new Intent(mContext, VolleyRequestActivity.class);
                intentExit4.putExtra("scanType", EXIT_HALL4);
                startActivity(intentExit4);
            case R.id.btn_exit_hall5:
                Intent intentExit5 = new Intent(mContext, VolleyRequestActivity.class);
                intentExit5.putExtra("scanType", EXIT_HALL5);
                startActivity(intentExit5);
            case R.id.btn_bulkexit_hall1:
                Intent intentBulk1 = new Intent(mContext, VolleyRequestActivity.class);
                intentBulk1.putExtra("scanType", BULK_HALL1);
                startActivity(intentBulk1);
            case R.id.btn_bulkexit_hall2:
                Intent intentBulk2 = new Intent(mContext, VolleyRequestActivity.class);
                intentBulk2.putExtra("scanType", BULK_HALL2);
                startActivity(intentBulk2);
            case R.id.btn_bulkexit_hall3:
                Intent intentBulk3 = new Intent(mContext, VolleyRequestActivity.class);
                intentBulk3.putExtra("scanType", BULK_HALL3);
                startActivity(intentBulk3);
            case R.id.btn_bulkexit_hall4:
                Intent intentBulk4 = new Intent(mContext, VolleyRequestActivity.class);
                intentBulk4.putExtra("scanType", BULK_HALL4);
                startActivity(intentBulk4);
            case R.id.btn_bulkexit_hall5:
                Intent intentBulk5 = new Intent(mContext, VolleyRequestActivity.class);
                intentBulk5.putExtra("scanType", BULK_HALL5);
                startActivity(intentBulk5);
            case R.id.btn_lunch_day1:
                Intent intentLunch1 = new Intent(mContext, VolleyRequestActivity.class);
                intentLunch1.putExtra("scanType", LUNCH_DAY1);
                startActivity(intentLunch1);
            case R.id.btn_lunch_day2:
                Intent intentLunch2 = new Intent(mContext, VolleyRequestActivity.class);
                intentLunch2.putExtra("scanType", LUNCH_DAY2);
                startActivity(intentLunch2);
            case R.id.btn_lunch_day3:
                Intent intentLunch3 = new Intent(mContext, VolleyRequestActivity.class);
                intentLunch3.putExtra("scanType", LUNCH_DAY3);
                startActivity(intentLunch3);


        }
    }

}
