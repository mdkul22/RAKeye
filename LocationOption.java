package com.cisco.rakeye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class LocationOption extends AppCompatActivity implements OnItemSelectedListener{
    static final private String TAG = "LocationOption";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_option);
        // building options
        Spinner bspinner = findViewById(R.id.spinner2);
        bspinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.building_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bspinner.setAdapter(adapter1);
        // floor options
        Spinner fspinner = findViewById(R.id.spinner);
        fspinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.floor_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fspinner.setAdapter(adapter2);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spinner2) {
            String building = parent.getItemAtPosition(position).toString();
            ((MyApplication) getApplication()).setBuilding(building);
            Log.d(TAG, "building is " + ((((MyApplication) getApplication()).getBuilding())));
        }
        else if (spinner.getId() == R.id.spinner)
        {
            String floor = parent.getItemAtPosition(position).toString();
            ((MyApplication) getApplication()).setFloor(floor);
            Log.d(TAG, "floor is " + ((((MyApplication) getApplication()).getFloor())));
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void OnButton(View view){
        if ((((MyApplication) getApplication()).getBuilding().equals("-1")
                || ((MyApplication) getApplication()).getFloor().equals("-1")))
        {
            AlertDialogFragment typeAlert = new AlertDialogFragment();
            typeAlert.stringIs("Select from the drop down Menu Please!");
            typeAlert.show(getFragmentManager(), "type_dialog");
            return;
        }
        Intent intent = new Intent(this, PopPlan.class);
        startActivity(intent);
    }
}
