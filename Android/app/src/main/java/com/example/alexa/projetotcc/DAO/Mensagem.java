package com.example.alexa.projetotcc.DAO;

import java.io.Serializable;
import java.util.Date;

import androidx.annotation.NonNull;

public class Mensagem  implements Serializable {

        private  Integer codigo;
        private String dataMens;
        private int idAluno;
        private String textoMens;
        private int idGrupo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDataMens() {
        return dataMens;
    }

    public void setDataMens(String dataMens) {
        this.dataMens = dataMens;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getTextoMens() {
        return textoMens;
    }

    public void setTextoMens(String textoMens) {
        this.textoMens = textoMens;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @NonNull
    @Override
    public String toString() {
        return textoMens;
    }
}
