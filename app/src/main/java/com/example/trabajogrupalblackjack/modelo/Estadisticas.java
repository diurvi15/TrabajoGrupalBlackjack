package com.example.trabajogrupalblackjack.modelo;

public class Estadisticas implements Comparable<Estadisticas>{

    String nombre;
    int puntos;
    String fecha;

    public Estadisticas(String nombre, int puntos, String fecha) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

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
