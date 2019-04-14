package com.example.alexa.projetotcc.DAO;

import java.io.Serializable;
import java.util.Date;

public class Avaliacao implements Serializable {

    private Integer codigo;
    private int idAluno;
    private String comentario;
    private double nota;
    private int idGrupoAvaliado;
    private String dataAv;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdGrupoAvaliado() {
        return idGrupoAvaliado;
    }

    public void setIdGrupoAvaliado(int idGrupoAvaliado) {
        this.idGrupoAvaliado = idGrupoAvaliado;
    }

    public String getDataAv() {
        return dataAv;
    }

    public void setDataAv(String dataAv) {
        this.dataAv = dataAv;
    }
}
