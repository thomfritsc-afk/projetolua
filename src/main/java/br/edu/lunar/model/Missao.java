package br.edu.lunar.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Missao implements Serializable {

    private String codigo;
    private String nome;
    private LocalDate dataLancamento;
    private LocalDate dataRetorno;
    private String destino;
    private String objetivo;
    private String resultadoCientifico;

    private Nave nave;
    private List<Astronauta> astronautas = new ArrayList<>();

    public Missao(String codigo, String nome, LocalDate dataLancamento, LocalDate dataRetorno,
                  String destino, String objetivo, Nave nave) {

        if (dataRetorno.isBefore(dataLancamento))
            throw new IllegalArgumentException("Data de retorno inválida.");

        this.codigo = codigo;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.dataRetorno = dataRetorno;
        this.destino = destino;
        this.objetivo = objetivo;
        this.nave = nave;
    }

    public void adicionarAstronauta(Astronauta a) {
        if (astronautas.size() >= nave.getCapacidadeTripulantes())
            throw new IllegalStateException("Nave sem capacidade.");

        astronautas.add(a);
    }

    public long getDuracao() {
        return ChronoUnit.DAYS.between(dataLancamento, dataRetorno);
    }

    public void setResultadoCientifico(String r) { this.resultadoCientifico = r; }
    public String getCodigo() { return codigo; }

    @Override
    public String toString() {
        return "Missão " + nome + " [" + codigo + "]\n" +
                "Destino: " + destino + "\n" +
                "Objetivo: " + objetivo + "\n" +
                "Nave: " + nave + "\n" +
                "Lançamento: " + dataLancamento + "\n" +
                "Retorno: " + dataRetorno + "\n" +
                "Duração: " + getDuracao() + " dias\n" +
                "Astronautas: " + astronautas + "\n" +
                "Resultado: " + (resultadoCientifico == null ? "Não registrado" : resultadoCientifico);
    }
}
