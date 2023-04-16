package com.example.samsung.Services;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.samsung.BD.Place;
import com.example.samsung.BD.RetrofitPlaceServ;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.badge.BadgeUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapService implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    private final Context context;
    private EditText time;
    private Button applay;
    private ArrayList<Place> places = new ArrayList<>();

    public MapService(Context context) {
        this.context = context;
        getPlaces();
    }


    public void onMapClick(@NonNull LatLng latLng) {
        System.out.println(places);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        System.out.println(places);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMapLongClickListener(this);

    }

    public void applayPlace(Place place){
        RetrofitPlaceServ.getInstance().add(new Place(0, place.getName(), place.getAdress(), place.getInformarion(), place.getLatLng().latitude, place.getLatLng().longitude, place.getTime(), place.getUserId()));
    }

    public void getPlaces(){
        RetrofitPlaceServ.getInstance().getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(@NonNull Call<List<Place>> call, @NonNull Response<List<Place>> response) {
                places.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {

            }
        });
    }
}
