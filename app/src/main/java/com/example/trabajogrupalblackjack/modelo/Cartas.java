package com.example.trabajogrupalblackjack.modelo;

import java.util.List;

public class Cartas {
    List<Integer> valorCartas;
    List<String> palos;

    public Cartas(List<Integer> valorCartas, List<String> palos) {
        this.valorCartas = valorCartas;
        this.palos = palos;
    }

    public List<Integer> getValorCartas() {
        return valorCartas;
    }

    public void setValorCartas(List<Integer> valorCartas) {
        this.valorCartas = valorCartas;
    }

    public List<String> getPalos() {
        return palos;
    }

    public void setPalos(List<String> palos) {
        this.palos = palos;
    }

}
