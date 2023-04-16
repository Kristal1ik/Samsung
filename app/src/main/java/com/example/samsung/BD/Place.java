package com.example.samsung.BD;

import com.google.android.gms.maps.model.LatLng;

public class Place {
    private final long id;
    private final String name;
    private final String adress;
    private final String informarion;
    private final double lantute;
    private final double longitute;
    private final long time;
    private LatLng latLng;
    private final long userId;

    public Place(long id, String name, String adress, String informarion, double lantute, double longitute, long time, long userId) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.informarion = informarion;
        this.lantute = lantute;
        this.longitute = longitute;
        this.time = time;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void lant(LatLng latLng){
        this.latLng = latLng;
    }
    public String getAdress() {
        return adress;
    }

    public String getInformarion() {
        return informarion;
    }

    public LatLng getLatLng() {
        return latLng;
    }


    public long getTime() {
        return time;
    }
    
    public long getUserId() {
        return userId;
    }

    public double getLantute() {
        return lantute;
    }

    public double getLongitute() {
        return longitute;
    }
}
