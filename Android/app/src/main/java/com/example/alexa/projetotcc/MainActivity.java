package com.example.alexa.projetotcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Study+");
        setSupportActionBar(toolbar);
    }

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
                deslogarUsuario();
                return true;

                //  colocar mais opções da toolbaar aqui no switch
            case R.id.item_setting:
                return true;

             default:
                 return super.onOptionsItemSelected(item);

        }

    }

    public void deslogarUsuario(){
        // adicionar aqui o metodo para deslogar

        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);
        finish();
    }
}
