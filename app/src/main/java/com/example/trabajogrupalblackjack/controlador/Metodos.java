package com.example.trabajogrupalblackjack.controlador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajogrupalblackjack.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;


public class Metodos {

    public static MediaPlayer sonido;

    public static void creacionFicheroEstadisticas(Context context, String obj){
        try(FileOutputStream fos = context.openFileOutput("estadisticas.csv", Context.MODE_APPEND);
            PrintWriter pw = new PrintWriter(fos)){
            pw.println(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lineaInicialFichero(Context context){
        if(Arrays.asList(context.fileList()).contains("estadisticas.csv")){
            return;
        }
        creacionFicheroEstadisticas(context, "ganador;puntos obtenidos;fecha");
    }


    public static boolean compruebaVacio(EditText campoTexto,Context context){
        if (campoTexto.getText().length() ==0){
            Toast.makeText(context, "Debe introducir datos en los dos campos", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public static boolean nombresDistintos(Context context, EditText nombre1, EditText nombre2){
        if(nombre1.getText().toString().equals(nombre2.getText().toString())){
            Toast.makeText(context, "Debe introducir nombres distintos", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public static String conseguirFechaActual() {
        Date fecha = Date.from(Instant.now());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return sdf.format(fecha);
    }



    public static void sonidoplay(){
        sonido.start();
    }
    public static void loopingsonido(){
        sonido.start();
        sonido.setLooping(true);
    }

    public static void crearsonido(Context context, String name){

        switch (name) {
            case "sonido1":
                sonido = MediaPlayer.create(context, R.raw.plantarseeditcinco);
                sonidoplay();
                break;

            case "sonido2":
                sonido = MediaPlayer.create(context, R.raw.barajandodialog);
                sonidoplay();
                break;

            case "sonido3":
                sonido = MediaPlayer.create(context, R.raw.sonidowintres);
                sonidoplay();
                break;
            case "sonido4":
                sonido = MediaPlayer.create(context, R.raw.sonidoperderdos);
                sonidoplay();
                break;
        }
    }
    public static void sonidoparar() {
        sonido.stop();
    }

}
