package com.example.samsung.BD;

import com.example.samsung.domain.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceApi{

    @GET("place")
    Call<List<Place>> getPlaces();
}