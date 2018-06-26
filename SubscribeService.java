package com.cisco.rakeye;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.Date;


public class SubscribeService extends IntentService {
    private String TAG = "SubscribeService";
    MqttAndroidClient client;

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public SubscribeService() {
        super("HelloIntentService");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds
        String server = ((MyApplication) getApplication()).getX();
        Log.d(TAG, server);
        String clientId = MqttClient.generateClientId();
        Log.d(TAG,"clientid =" + clientId);
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://"+server+":1883", clientId);
        client.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String server) {
                if (reconnect) {
                    Log.d(TAG, "Reconnected to : " + server);
                    // Because Clean Session is true, we need to re-subscribe
                    Subscribe();
                } else {
                    Log.d(TAG, "Connected to: " + server);
                }
            }

            @Override
            public void connectionLost(Throwable cause) {
                Log.d(TAG, "The Connection was lost.");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                Log.d(TAG, "Incoming message: " + new String(message.getPayload()));
                byte obj[] = message.getPayload();
                String msg=  new String(obj);
                JSONObject reader = new JSONObject(msg);
                String mac = reader.getString("mac");
                String building = reader.getString("building");
                String floor = reader.getString("floor");
                String posX = reader.getString("posX");
                String posY = reader.getString("posY");
                String alert = reader.getString("alert");
                ((MyApplication) getApplication()).setMac(mac);
                ((MyApplication) getApplication()).setBuilding(building);
                ((MyApplication) getApplication()).setFloor(floor);
                ((MyApplication) getApplication()).storePosX(posX);
                ((MyApplication) getApplication()).storePosX(posY);
                ((MyApplication) getApplication()).storeAlert(alert);
                String bldS = ((MyApplication) getApplication()).getBuildingS();
                Log.d(TAG, "json received is: " + msg);
                if(bldS.equals(building)) {
                    Intent notifyIntent = new Intent(getApplicationContext(), LocationDetails.class);
                    // Set the Activity to start in a new, empty task
                    notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    // Create the PendingIntent
                    PendingIntent notifyPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
                    );
                    String CHANNEL_ID = "mqtt subscriber";
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                            .setSmallIcon(R.drawable.icon)
                            .setContentTitle("SERVICE REQUESTED")
                            .setContentText(alert + " at " + floor + "th floor!")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            // Set the intent that will fire when the user taps the notification
                            .setContentIntent(notifyPendingIntent)
                            .setAutoCancel(true);
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                    // notificationId is a unique int for each notification that you must define
                    notificationManager.notify((int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE), mBuilder.build());
                }
            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d(TAG, "onSuccess");
                    Subscribe();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d(TAG, "onFailure");
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    public void Subscribe(){
        try {
            String topic = "tqb/mobile";
            client.subscribe(topic, 0, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.d(TAG, "Subscribed!");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d(TAG, "Failed to subscribe");
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}