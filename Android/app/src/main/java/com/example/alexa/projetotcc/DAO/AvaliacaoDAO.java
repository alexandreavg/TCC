package com.example.alexa.projetotcc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO  {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AvaliacaoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Avaliacao avaliacao){
        ContentValues values= new ContentValues();
        values.put("avaliacao", avaliacao.getIdAluno());
        values.put("avaliacao", avaliacao.getComentario());
        values.put("avaliacao", avaliacao.getNota());
        values.put("avaliacao", avaliacao.getIdGrupoAvaliado());
        values.put("avaliacao", avaliacao.getDataAv());

        return banco.insert("avaliacao", null, values);
    }

    public List<Avaliacao> listar(){
        List<Avaliacao> lista = new ArrayList<>();
        Cursor cursor = banco.query("avaliacao", new String[]{"codigo", "idAluno", "comentario", "nota"
                        ,"idGrupoAvaliado", "dataAv"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setCodigo(cursor.getInt(0));
            avaliacao.setIdAluno(cursor.getInt(1));
            avaliacao.setComentario(cursor.getString(2));
            avaliacao.setNota(cursor.getInt(3));
            avaliacao.setIdGrupoAvaliado(cursor.getInt(4));
            avaliacao.setDataAv(cursor.getString(5));
            lista.add(avaliacao);
        }
        return lista;
    }

    public void atualizar(Avaliacao avaliacao){
        ContentValues values= new ContentValues();
        values.put("avaliacao", avaliacao.getIdAluno());
        values.put("avaliacao", avaliacao.getComentario());
        values.put("avaliacao", avaliacao.getNota());
        values.put("avaliacao", avaliacao.getIdGrupoAvaliado());
        values.put("avaliacao", avaliacao.getDataAv());
        banco.update("avalicao", values, "codigo = ?", new String[]{avaliacao.getCodigo().toString()});
    }

    public void excluir(Avaliacao avaliacao){
        banco.delete("avaliacao", "codigo = ?", new String[]{avaliacao.getCodigo().toString()});
    }

}
