package com.example.trabajogrupalblackjack.vista;

import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.calcularfin;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.cargarbaraja;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.darcarta;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.dibujocarta;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.finturno;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.iniciarplantado;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.mostrarnuevacarta;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.pintarcarta;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.primerascartas;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.seguirturno;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.sumarpuntos;
import static com.example.trabajogrupalblackjack.controlador.Metodos_Juego.valordelacarta;

import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador1;
import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.controlador.Metodos;
import com.example.trabajogrupalblackjack.controlador.Metodos_Juego;
import com.example.trabajogrupalblackjack.modelo.Cartas;
import com.example.trabajogrupalblackjack.modelo.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Juego extends AppCompatActivity {

    public static ArrayList<Integer> mano1 = new ArrayList<>();
    public static ArrayList<Integer> mano2= new ArrayList<>();
    public static  ArrayList<Cartas> baraja = new ArrayList<>(51);

    public static ImageView pedircartaplayer1;
    public static ImageView pedircartaplayer2;

    public static ImageView plantarseplayer1;
    public static ImageView plantarseplayer2;

    public static   Player ganador;
    public static  TextView lblpuntos1;
    public static  TextView lblpuntos2;

    public static ImageView carta1;
    public static  ImageView carta2;
    public static  ImageView carta3;
    public static  ImageView carta4;
    public static  ImageView carta5;
    public static  ImageView carta6;
    public static  ImageView carta7;
    public static  ImageView carta8;
    public static  ImageView carta9;
    public static  ImageView carta10;
    public static  ImageView carta11;
    public static  ImageView carta12;
    public static  TextView val1;
    public static  TextView val2;
    public static  TextView val3;
    public static  TextView val4;
    public static  TextView val5;
    public static  TextView val6;
    public static  TextView val7;
    public static  TextView val8;
    public static  TextView val9;
    public static  TextView val10;
    public static  TextView val11;
    public static  TextView val12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        prepararpartida();
        primerascartas();


        iniciarplantado(jugador1, jugador2, plantarseplayer1, plantarseplayer2);
        if(calcularfin()){
            ganador = comprobarganador(jugador1, jugador2, this);
            guardardatosganador(ganador);
        }

        pedircartaplayer1.setOnClickListener(v->{

            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(), jugador1);
            mano1.add(puntos);
            mostrarnuevacarta(carta,1);
            sumarpuntos(jugador1,puntos,mano1);
            lblpuntos1.setText(String.valueOf(jugador1.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(jugador1, jugador2, this);
                guardardatosganador(ganador);
            } if(jugador2.getPlantado()){
                seguirturno(1);
           }
            else{
                finturno(1);
            }
        });

        pedircartaplayer2.setOnClickListener(v->{

            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(), jugador2);
            mano2.add(puntos);
            mostrarnuevacarta(carta,2);
            sumarpuntos(jugador2,puntos,mano2);
            lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(jugador1, jugador2, this);
                guardardatosganador(ganador);
            }
            if(!jugador1.getPlantado()){
            finturno(2);}
            else{
                seguirturno(2);
            }
        });

        plantarseplayer1.setOnClickListener(v->{
            Metodos.crearsonido(this, "sonido1");

            jugador1.setPlantado(true);
            if(jugador1.getPlantado() && jugador2.getPlantado()){
                alertasfinal(" HABEIS EMPATADO", new Player("", false, 0), this);
            } else {

                if (!jugador2.getPlantado()) {
                 //   MenuInicial.jugador1.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(jugador1, jugador2, this);
                        guardardatosganador(ganador);
                    } else {
                        finturno(1);
                    }
                }
            }
        });

        plantarseplayer2.setOnClickListener(v->{
            Metodos.crearsonido(this, "sonido1");

            jugador2.setPlantado(true);
            if(jugador1.getPlantado() && jugador2.getPlantado()){
                alertasfinal("HABEIS EMPATADO", new Player("", false, 0), this);
            } else {
                if (!jugador1.getPlantado()) {
                  //  MenuInicial.jugador2.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(jugador1, jugador2, this);
                        guardardatosganador(ganador);
                    } else {
                        finturno(2);
                    }
                }
            }
        });
    }

    private void recogerControles(){
        pedircartaplayer1 = findViewById(R.id.jugador1pedir);
        pedircartaplayer2 = findViewById(R.id.jugador2pedir);
        plantarseplayer1 = findViewById(R.id.plantarsej1);
        plantarseplayer2 = findViewById(R.id.plantarsej2);
        lblpuntos1 = findViewById(R.id.valorjugador1);
        lblpuntos2 = findViewById(R.id.valorjugador2);
        carta1 = findViewById(R.id.primeracartaj1);
        carta2 = findViewById(R.id.primeracartaj2);
        carta3 = findViewById(R.id.primeracartaj3);
        carta4 = findViewById(R.id.primeracartaj4);
        carta5 = findViewById(R.id.primeracartaj5);
        carta6 = findViewById(R.id.primeracartaj6);
        carta7 = findViewById(R.id.primeracartaj7);
        carta8 = findViewById(R.id.primeracartaj8);
        carta9 = findViewById(R.id.primeracartaj9);
        carta10 = findViewById(R.id.primeracartaj10);
        carta11 = findViewById(R.id.primeracartaj11);
        carta12 = findViewById(R.id.primeracartaj12);
        val1 = findViewById(R.id.valor1);
        val2 = findViewById(R.id.valor2);
        val3 = findViewById(R.id.valor3);
        val4 = findViewById(R.id.valor4);
        val5 = findViewById(R.id.valor5);
        val6 = findViewById(R.id.valor6);
        val7 = findViewById(R.id.valor7);
        val8 = findViewById(R.id.valor8);
        val9 = findViewById(R.id.valor9);
        val10 = findViewById(R.id.valor10);
        val11 = findViewById(R.id.valor11);
        val12 = findViewById(R.id.valor12);

    }

    private void prepararpartida() {

        recogerControles();
        ArrayList<String> valores = new ArrayList<>(52);
        String linea = getString(R.string.valorcartas);
        cargarbaraja(linea,valores);

    }



    private Player comprobarganador(Player jugador1, Player jugador2, Context context) {
        if (jugador1.getPuntos() > jugador2.getPuntos()) {

            if (jugador1.getPuntos() == 21) {
                Metodos.crearsonido(context,"sonido3");
                alertasfinal(" Enhorabuena has conseguido 21 puntos", jugador1, context);

                return jugador1;

            } else if (jugador1.getPuntos() < 21) {
                Metodos.crearsonido(context,"sonido3");
                alertasfinal(" Has ganado", jugador1, context);
                return jugador1;
            } else if (jugador1.getPuntos() > 21) {
                Metodos.crearsonido(context, "sonido4");
                alertasfinal(" Te has pasado de 21", jugador1, context);
                return jugador2;

            }
        } else if (jugador1.getPuntos() < jugador2.getPuntos()) {

            if (jugador2.getPuntos() == 21) {
                Metodos.crearsonido(context,"sonido3");
                alertasfinal(" Enhorabuena has conseguido 21 puntos", jugador2, context);
                return jugador2;

            } else if (jugador2.getPuntos() < 21) {
                Metodos.crearsonido(context,"sonido3");
                alertasfinal(" Has ganado", jugador2, context);
                return jugador2;
            } else if (jugador2.getPuntos() > 21) {
                Metodos.crearsonido(context, "sonido4");
                alertasfinal(" Te has pasado de 21", jugador2, context);
                return jugador1;
            }

        } else  {
            Player empate = new Player("Empate", true, 0);
            alertasfinal(" Quedais empate", empate, context);
            return empate;
        }

        return null;

    }

    private void alertasfinal(String msm,Player jugador, Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(jugador.getNombre() + msm);
        builder.setPositiveButton("VOLVER A JUGAR", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                jugador1.setPuntos(0);
                jugador1.setPlantado(false);
                jugador2.setPuntos(0);
                jugador2.setPlantado(false);

                lblpuntos1.setText(String.valueOf(0));
                lblpuntos2.setText(String.valueOf(0));

                try {
                    Metodos.crearsonido(context, "sonido2");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(context, Juego.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("VOLVER AL INICIO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), MenuInicial.class);
                        startActivity(intent);
                    }
                })
                .setOnCancelListener(v->{finish();});
        builder.show();

    }

    private void guardardatosganador(Player win){
        if(win.equals(jugador1))
        {
            Metodos.lineaInicialFichero(this);
            Metodos.creacionFicheroEstadisticas(this,win.toString() + ";" + Metodos.conseguirFechaActual()); // METODO DEL CSV y MENSAJE EN ALERTDIALOG
        }else if(win.equals(jugador2)){
            Metodos.lineaInicialFichero(this);
            Metodos.creacionFicheroEstadisticas(this,win.toString() + ";" + Metodos.conseguirFechaActual());//METODO CSV
        }else{
            alertasfinal("EMPATE",win, this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    //ALERT DIALOG INSTRUCCIONES

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.boton1){
            dialogInstrucciones();
        }

        return super.onOptionsItemSelected(item);
    }

    public void dialogInstrucciones() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        dialogo.setPositiveButton("Volver", null);

        View dialogoView = inflater.inflate(R.layout.dialog_instrucciones, null);
        dialogo.setView(dialogoView);

        dialogo.show();

    }




}
