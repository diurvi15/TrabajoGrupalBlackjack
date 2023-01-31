package com.example.trabajogrupalblackjack.modelo;

import androidx.annotation.NonNull;

public class Estadisticas implements Comparable<Estadisticas>{

    String nombre;
    int puntos;
    String fecha;

    public Estadisticas(String nombre, int puntos, String fecha) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.fecha = fecha;
    }


    public int getPuntos() {
        return puntos;
    }


    public String getFecha() {
        return fecha;
    }

    @NonNull
    @Override
    public String toString() {
        return  nombre  +
                "; " + puntos +
                "; " + fecha + "\n";
    }

    @Override
    public int compareTo(Estadisticas estadisticas) {
        if (this.puntos > estadisticas.getPuntos()){
            return -1;
        }else if (this.puntos < estadisticas.getPuntos()){
            return 1;
        }else{
            return this.getFecha().compareTo(estadisticas.getFecha());
        }

    }
}
