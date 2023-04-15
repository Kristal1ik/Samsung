package com.example.samsung.domain;

import com.google.android.gms.maps.model.LatLng;

public class Place {
    private final long id;
    private final String name;
    private final String adress;
    private final String informarion;
    private final LatLng latLng;


    public Place(long id, String name, String adress, String informarion, LatLng latLng) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.informarion = informarion;
        this.latLng = latLng;
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
}
