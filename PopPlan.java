package com.cisco.rakeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class PopPlan extends AppCompatActivity {
    private static final String TAG="PopPlan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_plan);
        String bld;
        bld = ((MyApplication) getApplication()).getBuilding();
        String floor = ((MyApplication) getApplication()).getFloor();
        if(bld.equals("BGL12")) {
            if(floor.equals("0")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl120));
                Log.d(TAG, "Entered bgl 12 ground");
            }
            else if(floor.equals("1")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl121));
            }

            else if(floor.equals("2")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl122));
            }

            else if(floor.equals("3")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl123));
            }

            else if(floor.equals("4")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl124));
            }
            }
        if(bld.equals("BGL11")) {
            if(floor.equals("0")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl110));
            }
            else if(floor.equals("1")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl111));
            }

            else if(floor.equals("2")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl112));
            }

            else if(floor.equals("3")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl113));
            }

            else if(floor.equals("4")) {
                SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl114));
            }
        }
    }
    public void OnClick(View view)
    {
        return;
    }
}

