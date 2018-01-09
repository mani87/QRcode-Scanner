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

        mWelcomeButton = (Button) findViewById(R.id.btn_welcome_kit);

        mEnteryHall1 = (Button) findViewById(R.id.btn_enter_hall1);
        mEnteryHall2 = (Button) findViewById(R.id.btn_enter_hall2);
        mEnteryHall3 = (Button) findViewById(R.id.btn_enter_hall3);
        mEnteryHall4 = (Button) findViewById(R.id.btn_enter_hall4);
        mEnteryHall5 = (Button) findViewById(R.id.btn_enter_hall5);

        mExitHall1 = (Button) findViewById(R.id.btn_exit_hall1);
        mExitHall2 = (Button) findViewById(R.id.btn_exit_hall2);
        mExitHall3 = (Button) findViewById(R.id.btn_exit_hall3);
        mExitHall4 = (Button) findViewById(R.id.btn_exit_hall4);
        mExitHall5 = (Button) findViewById(R.id.btn_exit_hall5);


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

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_welcome_kit:
                Intent intent = new Intent(mContext, VolleyRequestActivity.class);
                intent.putExtra("scanType", WELCOME_KIT);
                startActivity(intent);
        }
    }

}
