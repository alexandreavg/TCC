package com.example.alexa.projetotcc;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alexa.projetotcc.sinc.HelloWorldSinc;

public class Login extends AppCompatActivity {

    private Button criar;
    Button entrar;
    private Button btnTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //comando para esconder barra de titulo //getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        criar = (Button) findViewById(R.id.btnCadastrar);
        entrar = (Button) findViewById(R.id.btnEntrar);
        btnTeste = (Button) findViewById(R.id.btnTeste);

        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, TelaCadUsuarioActivity.class));
            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, TelaInicio.class));
            }
        });

        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarRest();
            }
        });


    }

    public void recuperarSenha(View view) {

        Intent intent = new Intent(Login.this, RecuperarSenhaActivity.class);
        startActivity(intent);
    }

    public void testarRest(){

        HelloWorldSinc helloWorldSinc = new HelloWorldSinc(getApplicationContext());

        helloWorldSinc.testaRest();

    }

}
