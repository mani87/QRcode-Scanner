package com.example.mani.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LunchDaysActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String LUNCH_DAY1 = "lunch1";
    private static final String LUNCH_DAY2 = "lunch2";
    private static final String LUNCH_DAY3 = "lunch3";

    private Button mDay1Lunch, mDay2Lunch, mDay3Lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_days);

        mDay1Lunch = (Button) findViewById(R.id.btn_lunch_day1);
        mDay2Lunch = (Button) findViewById(R.id.btn_lunch_day2);
        mDay3Lunch = (Button) findViewById(R.id.btn_lunch_day3);

        mDay1Lunch.setOnClickListener(this);
        mDay2Lunch.setOnClickListener(this);
        mDay3Lunch.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lunch_day1:
                Intent lunchDay1 = new Intent(this, VolleyRequestActivity.class);
                lunchDay1.putExtra("scanType",LUNCH_DAY1);
                startActivity(lunchDay1);
                break;
            case R.id.btn_lunch_day2:
                Intent lunchDay2 = new Intent(this, VolleyRequestActivity.class);
                lunchDay2.putExtra("scanType",LUNCH_DAY2);
                startActivity(lunchDay2);
                break;
            case R.id.btn_lunch_day3:
                Intent lunchDay3 = new Intent(this, VolleyRequestActivity.class);
                lunchDay3.putExtra("scanType",LUNCH_DAY3);
                startActivity(lunchDay3);
                break;
        }

    }
}
