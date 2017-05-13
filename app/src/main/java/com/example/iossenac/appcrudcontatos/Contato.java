package com.example.iossenac.appcrudcontatos;

import java.io.Serializable;

/**
 * Created by iossenac on 13/05/17.
 */

public class Contato implements Serializable{
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
