package com.example.samsung.domain;

import com.google.android.gms.maps.model.LatLng;

public class Place {
    private final long id;
    private final String name;
    private final String adress;
    private final String informarion;
    private final double corX;
    private final double corY;
    private final long time;
    private final LatLng latLng;
    private final long userId;

    public Place(long id, String name, String adress, String informarion, double corX, double corY, long time, LatLng latLng, long userId) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.informarion = informarion;
        this.corX = corX;
        this.corY = corY;
        this.time = time;
        this.latLng = latLng;
        this.userId = userId;
    }

    public String getName() {
        return name;
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

    public double getCorX() {
        return corX;
    }

    public double getCorY() {
        return corY;
    }

    public long getTime() {
        return time;
    }
    
    public long getUserId() {
        return userId;
    }
}
