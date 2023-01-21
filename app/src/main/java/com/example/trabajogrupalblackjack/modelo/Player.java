package com.example.trabajogrupalblackjack.modelo;

public class Player {

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
