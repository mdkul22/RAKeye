package com.cisco.rakeye;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        // Do something in response to button
        String networkSSID = "rakbutton";
        String networkPass = "password";

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";
        conf.preSharedKey = "\"" + networkPass + "\"";
        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);
        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for( WifiConfiguration i : list ) {
            Log.d(TAG, i.SSID);
            if(i.SSID != null && i.SSID.equals("\"" + "rakbutton" + "\"")) {
                try {
                    Log.d(TAG, "try");
                    wifiManager.disconnect();
                    wifiManager.enableNetwork(i.networkId, true);
                    System.out.print("i.networkId " + i.networkId + "\n");
                    wifiManager.reconnect();
                    setContentView(R.layout.activity_main);
                    TextView tv1 = (TextView)findViewById(R.id.wifiWaiter);
                    tv1.setText("Connected to rakbutton!");
                    break;
                }
                catch (Exception e) {
                    Log.d(TAG, "exception");
                    e.printStackTrace();
                }
            }
        }

        Intent intent = new Intent(this, WebPageViewer.class);
        startActivity(intent);
    }
}
