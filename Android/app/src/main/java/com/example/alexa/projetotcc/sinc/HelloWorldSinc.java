package com.example.alexa.projetotcc.sinc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.alexa.projetotcc.retrofit.RetrofitInicializador;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelloWorldSinc {

    private final Context context;
    private String resposta;

    public HelloWorldSinc(Context context){
        this.context = context;
    }

    public void testaRest() {
        Call<String> call = new RetrofitInicializador().getHelloWorldService().testarRest();

        call.enqueue(testaRestCallBack());
    }

    @NonNull
    private Callback<String> testaRestCallBack() {
        return new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    String resposta = response.body();

                    if (resposta.equals("true")) {
                        Toast.makeText(context, "Enxergou o rest!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "ERRO de rest", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        };
    }

}
