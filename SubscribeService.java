package com.cisco.rakeye;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class SubscribeService extends IntentService implements MqttCallback {
    private String TAG = "SubscribeService";
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
        final MqttAndroidClient client =
                new MqttAndroidClient(this.getApplicationContext(), "tcp://"+server+":1883",
                        clientId);
        String topic = "tqb/mobile";
        try {
            IMqttToken subToken = client.subscribe(topic, 0);
            subToken.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // The message was published
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken,
                                      Throwable exception) {
                    // The subscription could not be performed, maybe the user was not
                    // authorized to subscribe on the specified topic e.g. using wildcards

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        byte obj[] = message.getPayload();
        String msg=  new String(obj);
        JSONObject reader = new JSONObject(msg);
        String building = reader.getString("building");
        String floor = reader.getString("floor");
        String posX = reader.getString("posX");
        String posY = reader.getString("posY");
        String alert = reader.getString("alert");
        ((MyApplication) getApplication()).setBuilding(building);
        ((MyApplication) getApplication()).setFloor(floor);
        ((MyApplication) getApplication()).storePosX(posX);
        ((MyApplication) getApplication()).storePosX(posY);
        ((MyApplication) getApplication()).storeX(alert);
        Log.d(TAG, "json received is: " + msg);
        Intent intent = new Intent(this, LocationDetails.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        String CHANNEL_ID = "mqtt subscriber";
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        int notificationId = -1;
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationId, mBuilder.build());

        /*
         * To test ,publish  "open"/"close" at topic you subscibed app to in above .
         * */

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    Log.d("mqtt", "Delivery complete");
    }
    @Override
    public void connectionLost(Throwable cause) {
        Log.d("mqtt", "Connection Lost :(");

    }
}
