package com.example.samsung.BD;

public class RetrofitPlaceServ {
    private static PlaceApi placeApi;

    private static PlaceApi create(){
        return RetrofitSrv.getInstance().create(PlaceApi.class);
    }

    public static PlaceApi getInstance() {
        if (placeApi == null) placeApi = create();
        return placeApi;
    }
}
