package com.example.trabajogrupalblackjack.modelo;

import java.util.List;

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

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }
}
