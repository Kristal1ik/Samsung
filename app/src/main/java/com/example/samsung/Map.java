package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.samsung.Services.MapService;
import com.google.android.gms.maps.SupportMapFragment;

public class Map extends FragmentActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(new MapService(this));
    }
    }
