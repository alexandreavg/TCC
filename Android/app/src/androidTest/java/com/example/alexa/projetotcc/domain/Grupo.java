package com.example.alexa.projetotcc.domain;

public class Grupo extends GenericDomain {

    private String nomeGrupo;
    private String materia;
    private Integer numIntegrantes;
    private String status;
    private String fotoPerfil;

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getNumIntegrantes() {
        return numIntegrantes;
    }

    public void setNumIntegrantes(Integer numIntegrantes) {
        this.numIntegrantes = numIntegrantes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
