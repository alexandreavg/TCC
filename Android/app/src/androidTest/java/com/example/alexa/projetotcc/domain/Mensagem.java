package com.example.alexa.projetotcc.domain;

import java.util.Date;

public class Mensagem extends GenericDomain {

    private Date dataMens;
    private Usuario usuario;
    private String textoMens;
    private Grupo grupoMens;

    public Date getDataMens() {
        return dataMens;
    }

    public void setDataMens(Date dataMens) {
        this.dataMens = dataMens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTextoMens() {
        return textoMens;
    }

    public void setTextoMens(String textoMens) {
        this.textoMens = textoMens;
    }

    public Grupo getGrupoMens() {
        return grupoMens;
    }

    public void setGrupoMens(Grupo grupoMens) {
        this.grupoMens = grupoMens;
    }
}
