package com.example.mani.scanner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String WELCOME_KIT = "welcomeKit";
    private Button mWelcomeKit, mHallNumber, mLunch;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mWelcomeKit = (Button) findViewById(R.id.btn_welcome_kit);
        mHallNumber = (Button) findViewById(R.id.btn_hall_number);
        mLunch = (Button) findViewById(R.id.btn_lunch);

        mWelcomeKit.setOnClickListener(this);
        mHallNumber.setOnClickListener(this);
        mLunch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_welcome_kit:
                Intent intent = new Intent(mContext, VolleyRequestActivity.class);
                intent.putExtra("scanType", WELCOME_KIT);
                startActivity(intent);
                break;
            case R.id.btn_hall_number:
                Intent hallNumberIntent = new Intent(mContext, HallNumberActivity.class);
                startActivity(hallNumberIntent);
                break;
            case R.id.btn_lunch:
                Intent lunchDays = new Intent(mContext, LunchDaysActivity.class);
                startActivity(lunchDays);
                break;

        }

    }
}


