package com.example.alexa.projetotcc.retrofit;

import com.example.alexa.projetotcc.services.HelloWorldService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInicializador {

    public static Retrofit retrofit = null;

    public RetrofitInicializador() {
    }

    private static Retrofit getClient(){
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();

            // LOCAL
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.109:8080/Servico/rest/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            
        }
        return retrofit;

    }

    public HelloWorldService getHelloWorldService() {
        return getClient().create(HelloWorldService.class);
    }

}
