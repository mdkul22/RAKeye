package com.cisco.rakeye;


import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


import com.davemorrissey.labs.subscaleview.ImageSource;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


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
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl120));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                Log.d(TAG, "Entered bgl 12 ground");
            }
            else if(floor.equals("1")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl121));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
        if(bld.equals("BGL11")) {
            if(floor.equals("0")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView);
                imageView.setImage(ImageSource.resource(R.drawable.bgl110));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
                            PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                            ((MyApplication)getApplication()).storePosX(Float.toString(e.getX()));
                            ((MyApplication)getApplication()).storePosY(Float.toString(e.getY()));
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
    public void OnClick(View view)
    {
        String server = ((MyApplication) getApplication()).getX();
        String clientId = MqttClient.generateClientId();
        MqttAndroidClient client =
                new MqttAndroidClient(this.getApplicationContext(), "tcp://"+server+":1883",
                        clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d(TAG, "MQTTonSuccess");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d(TAG, "MQTTonFailure");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
        String topic = "tqb/setup";
        String message = "{mac:" + ((MyApplication)getApplication()).getMac() + "," +
                "building:" + ((MyApplication)getApplication()).getBuilding() + "," +
                "floor:" + ((MyApplication)getApplication()).getFloor() + "," +
                "X:" + ((MyApplication)getApplication()).getPosX() + "," +
                "Y:" + ((MyApplication)getApplication()).getPosY() + "," +
                " }";
        Intent intent = new Intent(this, NotificationListener.class);
        startActivity(intent);
        return;
    }
}

