package com.example.alexa.projetotcc.domain;

import java.util.Date;

public class Avaliacao extends GenericDomain{

    private Usuario usuario;
    private String comentario;
    private double nota;
    private Grupo grupoAvaliado;
    private Date dataAv;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Grupo getGrupoAvaliado() {
        return grupoAvaliado;
    }

    public void setGrupoAvaliado(Grupo grupoAvaliado) {
        this.grupoAvaliado = grupoAvaliado;
    }

    public Date getDataAv() {
        return dataAv;
    }

    public void setDataAv(Date dataAv) {
        this.dataAv = dataAv;
    }
}
