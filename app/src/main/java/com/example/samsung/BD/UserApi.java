package com.example.samsung.BD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("user")
    Call<List<User>> getUsers();
}

