package com.cisco.rakeye;

import android.annotation.SuppressLint;
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
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class LocationDetails extends AppCompatActivity {
    private String TAG = "LocationDetails";
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);
        String bld;
        bld = ((MyApplication) getApplication()).getBuildingS();
        String floor = ((MyApplication) getApplication()).getFloor();
        if(bld.equals("12")) {
            if(floor.equals("0")) {
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl120));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            Log.d(TAG, "entering" + x);
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl121));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl122));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);                            // ...
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl123));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl124));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl110));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl111));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl112));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl113));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
                final PinView imageView = (PinView)findViewById(R.id.imageView2);
                imageView.setImage(ImageSource.resource(R.drawable.bgl114));
                final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        if (imageView.isReady()) {
                            String x = ((MyApplication)getApplication()).getPosX();
                            String y = ((MyApplication)getApplication()).getPosY();
                            PointF sCoord = new PointF(Float.valueOf(x), Float.valueOf(y));
                            imageView.setPin(sCoord);
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
    public void DoneService(View view)
    {
        // MQTT setup
        String server = ((MyApplication) getApplication()).getX();
        Log.d(TAG, server);
        String clientId = MqttClient.generateClientId();
        final MqttAndroidClient client =
                new MqttAndroidClient(this.getApplicationContext(), "tcp://"+server+":1883",
                        clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected

                    String topic = "tqb/topic";
                    String payload = "{ " +
                            "\"mac\":\"" + ((MyApplication)getApplication()).getMac() + "\"," +
                            "\"alert\":" + ((MyApplication)getApplication()).getAlert() + "\"," +
                            "\"alertVal\": \"0\"" +
                            " }";
                    byte[] encodedPayload;
                    // publish message to broker
                    try {
                        encodedPayload = payload.getBytes("UTF-8");
                        MqttMessage message = new MqttMessage(encodedPayload);
                        Log.d(TAG,"message is " + payload);
                        Log.d(TAG,"topic is " + topic);
                        if(client.isConnected()) {
                            client.publish(topic, message);
                        }
                        else{
                            Log.d(TAG, "UNABLE TO PRINT");
                        }
                    } catch (UnsupportedEncodingException | MqttException e) {
                        e.printStackTrace();
                    }
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
            Log.d(TAG, "mqtt exception lol");
        }

        this.finish();
    }
}
