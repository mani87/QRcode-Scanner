package com.example.mani.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import java.util.HashMap;

public class VolleyRequestActivity extends AppCompatActivity {
    private static final String ENDPOINT = "http://perioconference.com/qrCodeScan/";
    RequestQueue queue;
    private IntentIntegrator mQrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_request);

        mQrScan = new IntentIntegrator(this);
        mQrScan.initiateScan();

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String qrCode = bundle.getString("qrCode");
                String scanType = bundle.getString("scanType");
                if (qrCode != null && scanType != null)
                    sumitQrCodeToServer(qrCode, scanType);

            }
        }
    }

    private void sumitQrCodeToServer(String qrCode, String scanType) {

        HashMap<String, String> qrDetails = new HashMap<>();
        qrDetails.put("qrCode", qrCode);
        qrDetails.put("scanType", scanType);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ENDPOINT, new JSONObject(qrDetails), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(VolleyRequestActivity.this, "Successful!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyRequestActivity.this, "Failed! Try again.", Toast.LENGTH_SHORT).show();
            }
        });
        if (request != null)
            queue.add(request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();
            } else {
                String qrCode = result.getContents();
                Toast.makeText(this, qrCode, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
