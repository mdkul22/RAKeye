package com.cisco.rakeye;

import android.app.Application;

public class MyApplication extends Application {

    private String response = "-1";
    private String mac = "-1";
    private String building = "-1";
    private String floor = "-1";
    private String x = "-1";
    private String locx = "-1";
    private String locy = "-1";

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
}
