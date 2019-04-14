package com.example.alexa.projetotcc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MensagemDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public MensagemDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirMsg(Mensagem msm){
        ContentValues values= new ContentValues();
        values.put("mensagem", msm.getDataMens());
        values.put("mensagem", msm.getIdAluno());
        values.put("mensagem", msm.getTextoMens());
        values.put("mensagem", msm.getIdGrupo());
        return banco.insert("mensagem", null, values);
    }

    public List<Mensagem> listar(){
        List<Mensagem> lista = new ArrayList<>();
        Cursor cursor = banco.query("mensagem", new String[]{"codigo", "DataMens", "idAluno",
                        "TextoMens", "IdGrupo"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Mensagem mensagem = new Mensagem();
            mensagem.setCodigo(cursor.getInt(0));
            mensagem.setDataMens(cursor.getString(1));
            mensagem.setIdAluno(cursor.getInt(2));
            mensagem.setTextoMens(cursor.getString(3));
            mensagem.setIdGrupo(cursor.getInt(4));
            lista.add(mensagem);
        }
        return lista;
    }

    public void atualizar(Mensagem mensagem){
        ContentValues values= new ContentValues();
        values.put("mensagem", mensagem.getDataMens());
        values.put("mensagem", mensagem.getIdAluno());
        values.put("mensagem", mensagem.getTextoMens());
        values.put("mensagem", mensagem.getIdGrupo());

        banco.update("mensagem", values, "codigo = ?", new String[]{mensagem.getCodigo().toString()});
    }

    public void excluir(Mensagem mensagem){
        banco.delete("mensagem", "codigo = ?", new String[]{mensagem.getCodigo().toString()});
    }

}
