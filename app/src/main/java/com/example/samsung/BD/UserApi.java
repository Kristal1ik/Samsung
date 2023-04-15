package com.example.samsung.BD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface UserApi {

    @GET("user")
    Call<List<User>> getUsers();

    @PUT("user")
    void add(String name, String passsword, Object o);
}

