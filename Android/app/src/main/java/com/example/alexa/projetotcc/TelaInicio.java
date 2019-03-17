package com.example.alexa.projetotcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TelaInicio extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar toolbar;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_favorito:
                    mTextMessage.setText(R.string.title_favorito);
                    return true;
                case R.id.navigation_grupo:
                    Intent intent= new Intent(TelaInicio.this, TelaInicio.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_perfil:
                    Intent intent1 = new Intent(TelaInicio.this,TelaCadUsuarioActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //tollbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Study+");
        setSupportActionBar(toolbar);
    }
//metodo tooblar

    // metodo para chamar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_sair:

                new AlertDialog.Builder(this)
                        .setTitle("Sair")
                        .setMessage("Tem certeza que deseja sair?")
                        .setPositiveButton("sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                        .setNegativeButton("não", null)
                        .show();
                return true;

            //  colocar mais opções da toolbaar aqui no switch
            case R.id.item_criarGrupo:
                Intent intent = new Intent(TelaInicio.this, TelaCriaGrupo.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void deslogarUsuario(){
        // adicionar aqui o metodo para deslogar

        Intent intent = new Intent(TelaInicio.this,Login.class);
        startActivity(intent);
        finish();
    }


}
