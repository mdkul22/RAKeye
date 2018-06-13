package com.cisco.rakeye;

import android.app.Application;

public class MyApplication extends Application {

    private String response = "-1";
    private String mac = "-1";
    private String building = "-1";
    private String floor = "-1";

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
