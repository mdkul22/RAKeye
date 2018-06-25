package com.cisco.rakeye;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.davemorrissey.labs.subscaleview.ImageSource;

public class LocationDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);
        String bld;
        bld = ((MyApplication) getApplication()).getBuildingS();
        String floor = ((MyApplication) getApplication()).getFloor();
        if(bld.equals("12")) {
            if(floor.equals("0")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl120));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }
            else if(floor.equals("1")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl121));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("2")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl122));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("3")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl123));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("4")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl124));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }
        }
        if(bld.equals("11")) {
            if(floor.equals("0")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl110));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }
            else if(floor.equals("1")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl111));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("2")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl112));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("3")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl113));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }

            else if(floor.equals("4")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl114));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = imageView.viewToSourceCoord(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
                            // ...
                        }
                        return true;
                    }
                });
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
            }
        }
    }
}
