package com.example.alexa.projetotcc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.alexa.projetotcc.fragments.GruposFragment;
import com.example.alexa.projetotcc.fragments.MeusGruposFragment;
import com.example.alexa.projetotcc.fragments.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {

    private BottomNavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView =(BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemReselectedListener(this);

    }


    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_favorito:
                getSupportActionBar().setTitle("Favoritos");
                Fragment favoritoFragment = MeusGruposFragment.newInstance();
                openFragment(favoritoFragment);
                break;

            case R.id.navigation_grupo:
                getSupportActionBar().setTitle("Grupos");
                Fragment gruposFragment = GruposFragment.newInstance();
                openFragment(gruposFragment);
                break;

            case R.id.navigation_perfil:
                getSupportActionBar().setTitle("Perfil");
                Fragment perfilFragment = PerfilFragment.newInstance();
                openFragment(perfilFragment);
                break;
        }

    }


    private void openFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);

        transaction.addToBackStack(null);
        transaction.commit();

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
                Intent intent = new Intent(MainActivity.this, TelaCriaGrupo.class);
                startActivity(intent);
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

    public void listarAlunos(){
        Intent intent = new Intent(this, ListarAlunosActivity.class);
        startActivity(intent);
    }
}
