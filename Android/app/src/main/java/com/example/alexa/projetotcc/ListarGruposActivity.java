package com.example.alexa.projetotcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.alexa.projetotcc.DAO.Grupo;
import com.example.alexa.projetotcc.DAO.GrupoDAO;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ListarGruposActivity extends AppCompatActivity {

    ListView listView;
    private GrupoDAO dao;
    private List<Grupo> grupos;
    private List<Grupo> gruposFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.listar_alunos);
        //listView = findViewById(R.id.listaAlunosView);
        dao = new GrupoDAO(this);
        grupos = dao.listar();
        gruposFiltrados.addAll(grupos);
        ArrayAdapter<Grupo> adapter = new ArrayAdapter<Grupo>(this, android.R.layout.simple_list_item_1, gruposFiltrados);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }


    @Override
    public void onResume(){
        super.onResume();
        grupos = dao.listar();
        gruposFiltrados.clear();
        gruposFiltrados.addAll(grupos);
        listView.invalidateViews();
    }

    public void procurarGrupo(String nome){
        gruposFiltrados.clear();
        for(Grupo grupo: grupos){
            if(grupo.getNomeGrupo().toLowerCase().contains(nome.toLowerCase())){
                gruposFiltrados.add(grupo);
            }
        }
        listView.invalidateViews();
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Grupo grupoExcluir = gruposFiltrados.get(menuInfo.position);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente Deseja Excluir o Aluno?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gruposFiltrados.remove(grupoExcluir);
                        grupos.remove(grupoExcluir);
                        dao.excluir(grupoExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        alertDialog.show();

    }

    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Grupo atualizarGrupo = gruposFiltrados.get(menuInfo.position);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("aluno", atualizarGrupo);
        startActivity(intent);
    }

}
