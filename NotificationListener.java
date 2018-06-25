package com.cisco.rakeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NotificationListener extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String TAG = "Notification Listener";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_listener);
        Spinner bspinner = findViewById(R.id.spinner4);
        bspinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.building_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bspinner.setAdapter(adapter1);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spinner4) {
            String building = parent.getItemAtPosition(position).toString();
            ((MyApplication) getApplication()).setNotify(building);
            Log.d(TAG, "building is " + ((((MyApplication) getApplication()).getNotify())));
        }
        else
            return;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
