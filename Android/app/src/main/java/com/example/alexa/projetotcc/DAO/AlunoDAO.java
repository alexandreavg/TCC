package com.example.alexa.projetotcc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values= new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("sobrenome", aluno.getSobreNome());
        values.put("email", aluno.getEmail());
        values.put("senha", aluno.getSenha());
        values.put("curso", aluno.getCurso());
        values.put("semestre", aluno.getSemestre());
        return banco.insert("aluno", null, values);
    }

    public List<Aluno> listar(){
        List<Aluno> lista = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"codigo", "nome", "sobrenome", "email"
                ,"senha", "curso", "semestre"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setCodigo(cursor.getInt(0));
            aluno.setNome(cursor.getString(1));
            aluno.setSobreNome(cursor.getString(2));
            aluno.setEmail(cursor.getString(3));
            aluno.setSenha(cursor.getString(4));
            aluno.setCurso(cursor.getString(5));
            aluno.setSemestre(cursor.getString(6));
            lista.add(aluno);
        }
        return lista;
    }

    public void atualizar(Aluno aluno){
        ContentValues values= new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("semestre", aluno.getSemestre());
        values.put("curso", aluno.getCurso());
        values.put("senha", aluno.getSenha());
        values.put("email", aluno.getEmail());
        values.put("sobrenome", aluno.getSobreNome());

        banco.update("aluno", values, "codigo = ?", new String[]{aluno.getCodigo().toString()});
    }

    public void excluir(Aluno aluno){
        banco.delete("aluno", "codigo = ?", new String[]{aluno.getCodigo().toString()});
    }

}
