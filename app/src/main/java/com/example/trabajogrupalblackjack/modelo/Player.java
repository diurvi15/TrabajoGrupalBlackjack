package com.example.trabajogrupalblackjack.modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Player implements Serializable {

    String nombre;
    Boolean plantado;
    int puntos;


    public Player(String nombre, Boolean plantado, int puntos) {
        this.nombre = nombre;
        this.plantado = plantado;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Boolean getPlantado() {
        return plantado;
    }

    public void setPlantado(Boolean plantado) {
        this.plantado = plantado;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre + ";" +
                 puntos;
    }
}
