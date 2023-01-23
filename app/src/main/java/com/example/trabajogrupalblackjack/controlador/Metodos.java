package com.example.trabajogrupalblackjack.controlador;

import android.content.Context;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Metodos {

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


    public static boolean compruebaVacio(EditText campoTexto){
        if (campoTexto.getText().length() ==0){
            campoTexto.setError("El campo " +campoTexto.getHint() + " se encuentra vacio. ");
            return true;
        }
        return false;
    }

}
