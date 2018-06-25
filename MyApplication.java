package com.cisco.rakeye;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {

    private String response = "-1";
    private String mac = "-1";
    private String building = "-1";
    private String floor = "-1";
    private String x = "-1";
    private String locx = "-1";
    private String locy = "-1";
    private String notify = "-1";

    public void storeX(String a){
        this.x = a;
    }

    public String getPosX(){
        return this.locx;
    }

    public void storePosX(String x)
    {
        this.locx = x;
    }

    public String getPosY(){
        return this.locy;
    }
    public void setNotify(String not){
        this.notify = not;
    }
    public String getNotify()
    {
        return this.notify;
    }

    public void storePosY(String y)
    {
        this.locy = y;
    }

    public String getX(){
        return this.x;
    }

    public String getMyResponse() {
        return this.response;
    }

    public void setMac(String s)
    {
        this.mac = s;
    }

    public String getMac(){
        return this.mac;
    }

    public void setMyReponse(String someVariable) {
        this.response = someVariable;
    }

    public void setBuilding(String var)
    {
        this.building = var;
    }

    public String getBuilding(){
        return this.building;
    }

    public void setFloor(String var)
    {
        this.floor = var;
    }

    public String getFloor(){
        return this.floor;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.notify);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            String CHANNEL_ID = "notifier";
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }
}
