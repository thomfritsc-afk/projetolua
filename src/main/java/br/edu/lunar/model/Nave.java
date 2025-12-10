package br.edu.lunar.model;

import java.io.Serializable;

public abstract class Nave implements Serializable {

    protected String nome;
    protected int capacidadeTripulantes;

    public Nave(String nome, int capacidadeTripulantes) {
        this.nome = nome;
        this.capacidadeTripulantes = capacidadeTripulantes;
    }

    public String getNome() { return nome; }
    public int getCapacidadeTripulantes() { return capacidadeTripulantes; }

    @Override
    public String toString() {
        return nome + " (capacidade: " + capacidadeTripulantes + ")";
    }
}
