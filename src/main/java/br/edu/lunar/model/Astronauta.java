package br.edu.lunar.model;

import java.io.Serializable;

public class Astronauta implements Serializable {

    private String nome;
    private int idade;
    private String especialidade;
    private int horasDeVoo;

    public Astronauta(String nome, int idade, String especialidade, int horasDeVoo) {
        if (idade < 21)
            throw new IllegalArgumentException("Astronauta deve ter pelo menos 21 anos.");

        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.horasDeVoo = horasDeVoo;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEspecialidade() { return especialidade; }
    public int getHorasDeVoo() { return horasDeVoo; }

    @Override
    public String toString() {
        return nome + " (" + especialidade + ", " + idade + " anos, " + horasDeVoo + "h voo)";
    }
}
