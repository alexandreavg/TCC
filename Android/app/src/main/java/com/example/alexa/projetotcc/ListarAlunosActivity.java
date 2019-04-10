package com.example.alexa.projetotcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alexa.projetotcc.DAO.Aluno;
import com.example.alexa.projetotcc.DAO.AlunoDAO;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ListarAlunosActivity extends AppCompatActivity {

    ListView listView;
    private AlunoDAO dao;
    private List<Aluno> alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_alunos);
        listView = findViewById(R.id.listaAlunosView);
        dao = new AlunoDAO(this);
        alunos = dao.listar();
        alunosFiltrados.addAll(alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunosFiltrados);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }


    @Override
    public void onResume(){
        super.onResume();
        alunos = dao.listar();
        alunosFiltrados.clear();
        alunosFiltrados.addAll(alunos);
        listView.invalidateViews();
    }

    public void procurarAluno(String nome){
        alunosFiltrados.clear();
        for(Aluno a: alunos){
            if(a.getNome().toLowerCase().contains(nome.toLowerCase())){
                alunosFiltrados.add(a);
            }
        }
        listView.invalidateViews();
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Aluno alunoExcluir = alunosFiltrados.get(menuInfo.position);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente Deseja Excluir o Aluno?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alunosFiltrados.remove(alunoExcluir);
                        alunos.remove(alunoExcluir);
                        dao.excluir(alunoExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        alertDialog.show();

    }

    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Aluno atualizarAluno = alunosFiltrados.get(menuInfo.position);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("aluno", atualizarAluno);
        startActivity(intent);
    }

}
