package com.cisco.rakeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    public void goSetup(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goNotification(View view)
    {
        Intent intent = new Intent(this, NotificationListener.class);
        startActivity(intent);
    }

}
