package com.example.alexa.projetotcc.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HelloWorldService {

    @GET("hello")
    Call<String> testarRest();

}
