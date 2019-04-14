package com.example.alexa.projetotcc.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE aluno(codigo integer primary key autoincrement, " +
                "nome varchar(50)," +
                "sobrenome varchar(50)," +
                "email varchar(30)," +
                "senha varchar(20)," +
                "curso varchar(25)," +
                "semestre varchar(15)) ";
        db.execSQL(sql);

        sql = "CREATE TABLE grupo(codigo integer primary key autoincrement, " +
                "nomeGrupo varchar(20)," +
                "materia varchar(20)," +
                "numIntegrantes integer," +
                "status varchar(20))";
        db.execSQL(sql);

        sql = "CREATE TABLE mensagem(codigo integer primary key autoincrement, " +
                "dataMens varchar(20), " +
                "idAluno integer," +
                "textoMens varchar(250)," +
                "idGrupo integer)";
        db.execSQL(sql);

        sql = "CREATE TABLE avaliacao(codigo integer primary key autoincrement, " +
                "dataMens varchar(20), " +
                "idAluno integer," +
                "textoMens varchar(250)," +
                "idGrupo integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
