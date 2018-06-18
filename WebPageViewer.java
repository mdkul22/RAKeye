package com.cisco.rakeye;

;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WebPageViewer extends AppCompatActivity {
    private static final String TAG="WebPageViewer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page_viewer);
    }

    public void OnButton(View view) {
        EditText in1 = findViewById(R.id.ssid);
        EditText in2 = findViewById(R.id.password);
        EditText in3 = findViewById(R.id.port);
        EditText in4 = findViewById(R.id.server);
        EditText in5 = findViewById(R.id.type);
        // retrieving values from input
        final String ssid = in1.getText().toString();
        Log.d(TAG, ssid);
        final String pass = in2.getText().toString();
        Log.d(TAG, pass);
        final String port = in3.getText().toString();
        Log.d(TAG, port);
        final String server = in4.getText().toString();
        ((MyApplication) getApplication()).storeX(server);
        Log.d(TAG, server);
        final String type = in5.getText().toString();

        if (ssid.isEmpty() || pass.isEmpty() || port.isEmpty() || server.isEmpty() || type.isEmpty()) {
            AlertDialogFragment dialog = new AlertDialogFragment();
            dialog.stringIs("Do not leave inputs empty!");
            dialog.show(getFragmentManager(), "error_dialog");
            return;
        }
        if (!(type.equals("1") || type.equals("0"))) {
            AlertDialogFragment typeAlert = new AlertDialogFragment();
            typeAlert.stringIs("Write either 0 (kitchen) or 1 (toilet) for type input");
            typeAlert.show(getFragmentManager(), "type_dialog");
            return;
        }
        // begin sending the request to device
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://192.168.1.1/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        ((MyApplication) getApplication()).setMyReponse(response);
                        Log.d(TAG, "response stored");
                        String res = "1";
                        res = ((MyApplication) getApplication()).getMyResponse();
                        if (res.equals("1")) {
                            AlertDialogFragment typeAlert = new AlertDialogFragment();
                            typeAlert.stringIs("Response not received! Try again.");
                            typeAlert.show(getFragmentManager(), "type_dialog");
                            return;
                        }
                        String mac = res.substring(res.indexOf("Mac:") + 4, res.indexOf('&', res.indexOf("Mac:") + 4));
                        Log.d(TAG, "mac is" + mac);
                        ((MyApplication) getApplication()).setMac(mac);
                        Log.d(TAG, "HTTP Send start");
                        // begin the HTTP send
                        String url1;
                        url1 = url + "a?ssid=" + ssid + "&pass=" + pass + "&serv=" + server + "&port=" + port + "&type=" + type;
                        Log.d(TAG, url1);
                        StringRequest sendRequest = new StringRequest(Request.Method.GET, url1,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        // Display the first 500 characters of the response string.
                                        ((MyApplication) getApplication()).setMyReponse(response);
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "error on response");
                                ((MyApplication) getApplication()).setMyReponse("no response");
                            }
                        });
                        queue.add(sendRequest);
                        Log.d(TAG, "Request send for setup");
                        return;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "error on response");
                ((MyApplication) getApplication()).setMyReponse("-1");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        Log.d(TAG, "response 1 added to queue");
        Intent intent = new Intent(this, LocationOption.class);
        startActivity(intent);
    }
}

