package com.example.mani.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EntryExitActivity extends AppCompatActivity implements View.OnClickListener{

    private String Data;
    private Button mEnter, mExit, mBulkExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_exit);

        mEnter = (Button)findViewById(R.id.btn_enter);
        mExit = (Button)findViewById(R.id.btn_exit);
        mBulkExit = (Button)findViewById(R.id.btn_bulkExit);

        mEnter.setOnClickListener(this);
        mExit.setOnClickListener(this);
        mBulkExit.setOnClickListener(this);

        Data = getIntent().getExtras().getString("hallNumber");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter:
                Intent entryIntent = new Intent(this, VolleyRequestActivity.class);
                entryIntent.putExtra("scanType",Data+"Entry");
                startActivity(entryIntent);
                break;
            case R.id.btn_exit:
                Intent exitIntent = new Intent(this, VolleyRequestActivity.class);
                exitIntent.putExtra("scanType", Data+"exit");
                startActivity(exitIntent);
                break;
            case R.id.btn_bulkExit:
                Intent bulkExitIntent = new Intent(this, VolleyRequestActivity.class);
                bulkExitIntent.putExtra("scanType",Data);
                startActivity(bulkExitIntent);
                break;
        }
    }
}
