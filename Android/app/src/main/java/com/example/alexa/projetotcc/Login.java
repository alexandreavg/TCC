package com.example.alexa.projetotcc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button criar;
    Button entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //comando para esconder barra de titulo //getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        criar = (Button) findViewById(R.id.btnCadastrar);
        entrar = (Button) findViewById(R.id.btnEntrar);

        criar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(Login.this,TelaCadUsuarioActivity.class));
            }
        });

        entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(Login.this,TelaInicio.class));
            }
        });


    }

    public void recuperarSenha (View view){

        Intent intent = new Intent(Login.this,RecuperarSenhaActivity.class);
        startActivity(intent);
    }

}
