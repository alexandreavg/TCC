package com.example.alexa.projetotcc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public GrupoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Grupo grupo){
        ContentValues values= new ContentValues();
        values.put("nomeGrupo", grupo.getNomeGrupo());
        values.put("materia", grupo.getMateria());
        values.put("numIntegrantes", grupo.getNumIntegrantes());
        values.put("status", grupo.getStatus());
        return banco.insert("grupo", null, values);
    }

    public List<Grupo> listar(){
        List<Grupo> lista = new ArrayList<>();
        Cursor cursor = banco.query("grupo", new String[]{"codigo", "nomeGrupo", "materia", "numIntegrantes"
                        ,"status"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Grupo grupo = new Grupo();
            grupo.setCodigo(cursor.getInt(0));
            grupo.setNomeGrupo(cursor.getString(1));
            grupo.setMateria(cursor.getString(2));
            grupo.setNumIntegrantes(cursor.getInt(3));
            grupo.setStatus(cursor.getString(4));
            lista.add(grupo);
        }
        return lista;
    }

    public void atualizar(Grupo grupo){
        ContentValues values= new ContentValues();
        values.put("nomeGrupo", grupo.getNomeGrupo());
        values.put("materia", grupo.getMateria());
        values.put("NumIntegrantes", grupo.getNumIntegrantes());
        values.put("status", grupo.getStatus());
        banco.update("grupo", values, "codigo = ?", new String[]{grupo.getCodigo().toString()});
    }

    public void excluir(Grupo grupo){
        banco.delete("Grupo", "codigo = ?", new String[]{grupo.getCodigo().toString()});
    }

}
