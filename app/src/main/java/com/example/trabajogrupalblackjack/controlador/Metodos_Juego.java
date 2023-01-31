package com.example.trabajogrupalblackjack.controlador;

import static com.example.trabajogrupalblackjack.vista.Juego.baraja;
import static com.example.trabajogrupalblackjack.vista.Juego.pedircartaplayer1;
import static com.example.trabajogrupalblackjack.vista.Juego.pedircartaplayer2;
import static com.example.trabajogrupalblackjack.vista.Juego.plantarseplayer1;
import static com.example.trabajogrupalblackjack.vista.Juego.plantarseplayer2;
import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador1;
import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador2;

import android.view.View;
import android.widget.ImageView;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.modelo.Cartas;
import com.example.trabajogrupalblackjack.modelo.Player;
import com.example.trabajogrupalblackjack.vista.MenuInicial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Metodos_Juego {


    public static void cargarbaraja(String linea,ArrayList<String> valores) {


        String[] trozos =linea.split(";");
        valores.addAll(Arrays.asList(trozos));

        for(int q = 0;q<=51;q++){

            if(q<=12){baraja.add(new Cartas(Integer.parseInt(valores.get(q)),"brujula"));}
            else if(q<=25){baraja.add(new Cartas(Integer.parseInt(valores.get(q)),"huesos"));}
            else if(q<=38){baraja.add(new Cartas(Integer.parseInt(valores.get(q)),"barco"));}
            else if(q<=51){baraja.add(new Cartas(Integer.parseInt(valores.get(q)),"fruta"));}

        }

        Collections.shuffle(baraja);
    }

    public static void seguirturno(int jugador){
        if(jugador == 1) {

            if(jugador1.getPuntos()>=17 && jugador1.getPuntos()>=jugador2.getPuntos()&& jugador1.getPuntos()<=21){
                plantarseplayer1.setVisibility(View.VISIBLE);
                plantarseplayer1.setEnabled(true);}
        } else if(jugador==2){

            if(jugador2.getPuntos()>=17 && jugador2.getPuntos()>=jugador1.getPuntos()&& jugador2.getPuntos()<=21){
                plantarseplayer2.setVisibility(View.VISIBLE);
                plantarseplayer2.setEnabled(true);}
        }

    }
    public static void finturno(int jugador){
        if(jugador == 1) {
            pedircartaplayer1.setEnabled(false);
            pedircartaplayer1.setVisibility(View.INVISIBLE);
            plantarseplayer1.setEnabled(false);
            plantarseplayer1.setVisibility(View.INVISIBLE);

            pedircartaplayer2.setEnabled(true);
            pedircartaplayer2.setVisibility(View.VISIBLE);

            if(jugador2.getPuntos()>=17 && jugador2.getPuntos()>=jugador1.getPuntos() && jugador2.getPuntos()<=21){
                plantarseplayer2.setVisibility(View.VISIBLE);
                plantarseplayer2.setEnabled(true);}
        } else if(jugador==2){

            pedircartaplayer2.setEnabled(false);
            pedircartaplayer2.setVisibility(View.INVISIBLE);
            plantarseplayer2.setEnabled(false);
            plantarseplayer2.setVisibility(View.INVISIBLE);
            pedircartaplayer1.setEnabled(true);
            pedircartaplayer1.setVisibility(View.VISIBLE);

            if(jugador1.getPuntos()>=17 && jugador1.getPuntos()>=jugador2.getPuntos()&& jugador1.getPuntos()<=21){
                plantarseplayer1.setVisibility(View.VISIBLE);
                plantarseplayer1.setEnabled(true);}
        }
    }

    public static boolean calcularfin(){
        if(MenuInicial.jugador1.getPlantado() && MenuInicial.jugador2.getPuntos() > MenuInicial.jugador1.getPuntos()
                ||
                MenuInicial.jugador2.getPlantado() && MenuInicial.jugador1.getPuntos() > MenuInicial.jugador2.getPuntos())
        {
            return true;
        }
        else if(MenuInicial.jugador1.getPuntos()>=21||MenuInicial.jugador2.getPuntos()>=21) {

            return true;
        }

        else{return false;}

    }

    public static String dibujocarta(int valor){

        String val="";

        if(valor == 11){ val="J";}
        else if(valor == 12){val="Q";}
        else if(valor == 13){val = "K";}
        else {val = String.valueOf(valor);}
        return val;

    }

    public static void pintarcarta(Cartas carta, ImageView fondo){

        if(carta.getPalo().equals("brujula")){ fondo.setImageResource(R.drawable.cartabrujula);}
        if(carta.getPalo().equals("huesos")){ fondo.setImageResource(R.drawable.cartahuesos);}
        if(carta.getPalo().equals("barco")){ fondo.setImageResource(R.drawable.cartabarco);}
        if(carta.getPalo().equals("fruta")){ fondo.setImageResource(R.drawable.cartafruta);}


    }

    public static int valordelacarta(int numero, Player jugador){
        int valorcarta;
        if(numero == 1){
            //dialogElegirValorAs(numero, jugador);
            valorcarta = unoonce(jugador);

        }
        else if(numero == 11){valorcarta = 10;}
        else if(numero == 12){valorcarta = 10;}
        else if(numero == 13){valorcarta = 10;}
        else {valorcarta = numero;}
        return valorcarta;
    }

    public static int unoonce(Player jugador){
        if(jugador.getPuntos()+ 11 <21 ){

            return 11;

        }else if(jugador.getPuntos() + 11 == 21)
        {
            return 11;
        }
        else
        {
            return 1;
        }

    }

    public static void sumarpuntos(Player jugador, int puntos,ArrayList<Integer> mano){

        if(jugador.getPuntos()+puntos>21) {
            for (int q = 0; q < mano.size(); q++) {
                if (mano.get(q) == 11){
                    mano.set(q,0) ;
                    jugador.setPuntos(jugador.getPuntos()-10);}
            }
        }

        jugador.setPuntos(jugador.getPuntos()+puntos) ;
    }

}
