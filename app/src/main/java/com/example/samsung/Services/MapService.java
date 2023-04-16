package com.example.samsung.Services;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.samsung.R;


import androidx.annotation.NonNull;

import com.example.samsung.BD.Place;
import com.example.samsung.BD.RetrofitPlaceServ;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
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

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        System.out.println(places);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_fragment);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView tv_name = dialog.getWindow().findViewById(R.id.tv_name);
                TextView tv_address = dialog.getWindow().findViewById(R.id.tv_address);
                TextView tv_info = dialog.getWindow().findViewById(R.id.tv_description);
                applay = dialog.findViewById(R.id.tv_description);
                applay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        applayPlace(new Place(0, "Каз", "Как", "книга", latLng.latitude, latLng.longitude,Long.parseLong(time.getText().toString())));
                    }
                });
            }
        });
        googleMap.setOnMapLongClickListener(this);
//        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(@NonNull Marker marker) {
//                Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dialog_fragment);
//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);
//                dialog.getWindow().setGravity(Gravity.BOTTOM);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//                TextView tv_name = dialog.getWindow().findViewById(R.id.tv_name);
//                TextView tv_address = dialog.getWindow().findViewById(R.id.tv_address);
//                TextView tv_info = dialog.getWindow().findViewById(R.id.tv_description);
//                return false;
//            }
//        });
    }

    public void applayPlace(Place place){
        RetrofitPlaceServ.getInstance().add(new Place(0, place.getName(), place.getAdress(), place.getInformarion(), place.getLatLng().latitude, place.getLatLng().longitude, place.getTime()));
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

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    }
}
