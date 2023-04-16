package com.example.samsung.BD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlaceApi{

    @GET("place")
    Call<List<Place>> getPlaces();

    @POST("place")
    Call<Place> add(@Body Place place);
}