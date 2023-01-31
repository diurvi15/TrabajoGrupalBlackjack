package com.example.trabajogrupalblackjack.modelo;

public class Cartas {
    int valor;
    String palo;

    public Cartas(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }


    public String getPalo() {
        return palo;
    }

}
