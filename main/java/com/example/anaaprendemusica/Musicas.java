package com.example.anaaprendemusica;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Musicas {

    private String id;
    private String nome;

    public Musicas(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Musicas() {

    }

    @Override
    public String toString() {
        return "Musicas{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
