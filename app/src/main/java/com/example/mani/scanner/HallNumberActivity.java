package com.example.mani.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HallNumberActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mHall1, mHall2, mHall3, mHall4, mHall5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_number);

        mHall1 = (Button) findViewById(R.id.btn_hall1);
        mHall2 = (Button) findViewById(R.id.btn_hall2);
        mHall3 = (Button) findViewById(R.id.btn_hall3);
        mHall4 = (Button) findViewById(R.id.btn_hall4);
        mHall5 = (Button) findViewById(R.id.btn_hall5);

        mHall1.setOnClickListener(this);
        mHall2.setOnClickListener(this);
        mHall3.setOnClickListener(this);
        mHall4.setOnClickListener(this);
        mHall5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hall1:
                Intent hall1Intent = new Intent(this, EntryExitActivity.class);
                hall1Intent.putExtra("hallNumber", "hall1");
                startActivity(hall1Intent);
                break;
            case R.id.btn_hall2:
                Intent hall2Intent = new Intent(this, EntryExitActivity.class);
                hall2Intent.putExtra("hallNumber", "hall2");
                startActivity(hall2Intent);
                break;
            case R.id.btn_hall3:
                Intent hall3Intent = new Intent(this, EntryExitActivity.class);
                hall3Intent.putExtra("hallNumber", "hall3");
                startActivity(hall3Intent);
                break;
            case R.id.btn_hall4:
                Intent hall4Intent = new Intent(this, EntryExitActivity.class);
                hall4Intent.putExtra("hallNumber", "hall4");
                startActivity(hall4Intent);
                break;
            case R.id.btn_hall5:
                Intent hall5Intent = new Intent(this, EntryExitActivity.class);
                hall5Intent.putExtra("hallNumber", "hall5");
                startActivity(hall5Intent);
                break;
        }

    }
}
