package com.example.trabajogrupalblackjack.controlador;



import android.content.Context;



import com.example.trabajogrupalblackjack.modelo.Estadisticas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class Metodos_Juego {

    public static List<Estadisticas> listaPartidas = new ArrayList<>();

    public static List<Estadisticas> mostrarEstadisticas(Context context){

         listaPartidas = new ArrayList<>();

        try (InputStreamReader inputStream = new InputStreamReader(context.openFileInput("estadisticas.csv"));
             BufferedReader bf = new BufferedReader(inputStream)) {

            bf.readLine();
            String linea;
            while ((linea = bf.readLine()) != null){
                String[] ultimaspartidas = linea.split(";");

                listaPartidas.add(new Estadisticas(ultimaspartidas[0],Integer.parseInt(ultimaspartidas[1]),ultimaspartidas[2]));
            }
        } catch (IOException e) {

        }
        return listaPartidas.stream().sorted().limit(10).collect(Collectors.toList());
    }

}
