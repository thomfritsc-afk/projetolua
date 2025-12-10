package br.edu.lunar.model;

public class NaveTripulada extends Nave {

    private boolean suporteVida;

    public NaveTripulada(String nome, int capacidadeTripulantes, boolean suporteVida) {
        super(nome, capacidadeTripulantes);
        this.suporteVida = suporteVida;
    }

    public boolean isSuporteVida() { return suporteVida; }

    @Override
    public String toString() {
        return super.toString() + " | Suporte de vida: " + (suporteVida ? "Sim" : "Não");
    }
}
