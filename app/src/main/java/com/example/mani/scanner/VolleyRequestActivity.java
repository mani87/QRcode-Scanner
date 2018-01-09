package com.example.mani.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import java.util.HashMap;

public class VolleyRequestActivity extends AppCompatActivity {
    private static final String BULK_HALL1 = "hall1";
    private static final String BULK_HALL2 = "hall2";
    private static final String BULK_HALL3 = "hall3";
    private static final String BULK_HALL4 = "hall4";
    private static final String BULK_HALL5 = "hall5";
    private String ENDPOINT;
    private static final String TOKEN = "dlfdjgdjfklbjdlkfjbgdfklgjdfljdofijslzmxvnxcvneir";
    private final String LOG_TAG = this.getClass().getSimpleName();

    private RequestQueue requestQueue;
    private IntentIntegrator mQrScan;
    private String qrCode, scanType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_request);
        mQrScan = new IntentIntegrator(this);
        mQrScan.initiateScan();

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                scanType = bundle.getString("scanType");
            }
        }
    }

    private void sumitQrCodeToServer(String qrCode, String scanType) {
        if (BuildConfig.DEBUG) Log.d(LOG_TAG, "sumitQrCodeToServerCalled");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                ENDPOINT + "?qrCode=" + qrCode + "&scanType" + scanType + "&token=" + TOKEN,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (BuildConfig.DEBUG) Log.d(LOG_TAG, "testingResponse: " + response);
                        Toast.makeText(VolleyRequestActivity.this, response + "", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (BuildConfig.DEBUG) Log.d(LOG_TAG, "testingError: " + error);
                Toast.makeText(VolleyRequestActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(VolleyRequestActivity.this);
        requestQueue.add(request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();
            } else {
                qrCode = result.getContents();
                if (scanType == BULK_HALL1 || scanType == BULK_HALL2 || scanType == BULK_HALL3 || scanType == BULK_HALL4 || scanType == BULK_HALL5) {
                    ENDPOINT = "https://perioconference.com/qrCodeBulkExit/";
                    sumitQrCodeToServer(qrCode, scanType);
                } else {
                    ENDPOINT = "https://perioconference.com/qrCodeScan/";
                    sumitQrCodeToServer(qrCode, scanType);
                }
            }
        }
    }
}
