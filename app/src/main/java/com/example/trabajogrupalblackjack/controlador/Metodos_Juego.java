package com.example.trabajogrupalblackjack.controlador;

import static com.example.trabajogrupalblackjack.vista.Juego.baraja;
import static com.example.trabajogrupalblackjack.vista.Juego.carta1;
import static com.example.trabajogrupalblackjack.vista.Juego.carta10;
import static com.example.trabajogrupalblackjack.vista.Juego.carta11;
import static com.example.trabajogrupalblackjack.vista.Juego.carta12;
import static com.example.trabajogrupalblackjack.vista.Juego.carta2;
import static com.example.trabajogrupalblackjack.vista.Juego.carta3;
import static com.example.trabajogrupalblackjack.vista.Juego.carta4;
import static com.example.trabajogrupalblackjack.vista.Juego.carta5;
import static com.example.trabajogrupalblackjack.vista.Juego.carta6;
import static com.example.trabajogrupalblackjack.vista.Juego.carta7;
import static com.example.trabajogrupalblackjack.vista.Juego.carta8;
import static com.example.trabajogrupalblackjack.vista.Juego.carta9;
import static com.example.trabajogrupalblackjack.vista.Juego.lblpuntos1;
import static com.example.trabajogrupalblackjack.vista.Juego.lblpuntos2;
import static com.example.trabajogrupalblackjack.vista.Juego.mano1;
import static com.example.trabajogrupalblackjack.vista.Juego.mano2;
import static com.example.trabajogrupalblackjack.vista.Juego.pedircartaplayer1;
import static com.example.trabajogrupalblackjack.vista.Juego.pedircartaplayer2;
import static com.example.trabajogrupalblackjack.vista.Juego.plantarseplayer1;
import static com.example.trabajogrupalblackjack.vista.Juego.plantarseplayer2;
import static com.example.trabajogrupalblackjack.vista.Juego.val1;
import static com.example.trabajogrupalblackjack.vista.Juego.val10;
import static com.example.trabajogrupalblackjack.vista.Juego.val11;
import static com.example.trabajogrupalblackjack.vista.Juego.val12;
import static com.example.trabajogrupalblackjack.vista.Juego.val2;
import static com.example.trabajogrupalblackjack.vista.Juego.val3;
import static com.example.trabajogrupalblackjack.vista.Juego.val4;
import static com.example.trabajogrupalblackjack.vista.Juego.val5;
import static com.example.trabajogrupalblackjack.vista.Juego.val6;
import static com.example.trabajogrupalblackjack.vista.Juego.val7;
import static com.example.trabajogrupalblackjack.vista.Juego.val8;
import static com.example.trabajogrupalblackjack.vista.Juego.val9;
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


    public static void iniciarplantado(Player player1, Player player2, ImageView btnplantarse1, ImageView btnplantarse2){
        pedircartaplayer2.setVisibility(View.INVISIBLE);
        if(player1.getPuntos() < 17){
            btnplantarse1.setVisibility(View.INVISIBLE);
            btnplantarse1.setEnabled(false);
        } else if(player1.getPuntos() < player2.getPuntos()){
            btnplantarse1.setVisibility(View.INVISIBLE);
            btnplantarse1.setEnabled(false);
        } else if(player2.getPuntos() < 17){
            btnplantarse2.setVisibility(View.INVISIBLE);
            btnplantarse2.setEnabled(false);
        } else if(player2.getPuntos() < player1.getPuntos()){
            btnplantarse2.setVisibility(View.INVISIBLE);
            btnplantarse2.setEnabled(false);
        }
    }

    public static void primerascartas() {

        Cartas carta = darcarta();
        int puntos = valordelacarta(carta.getValor(), jugador1);
        mano1.add(puntos);
        String val = dibujocarta(carta.getValor());
        val1.setText(val);
        pintarcarta(carta,carta1);
        sumarpuntos(jugador1,puntos,mano1);
        lblpuntos1.setText(String.valueOf(jugador1.getPuntos()));

        carta = darcarta();
        puntos = valordelacarta(carta.getValor(), jugador2);
        mano2.add(puntos);
        val = dibujocarta(carta.getValor());
        val7.setText(val);
        pintarcarta(carta,carta7);
        sumarpuntos(jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

        carta = darcarta();
        puntos = valordelacarta(carta.getValor(), jugador1);
        mano1.add(puntos);
        val = dibujocarta(carta.getValor());
        val2.setText(val);
        pintarcarta(carta,carta2);
        sumarpuntos(jugador1,puntos,mano1);
        lblpuntos1.setText(String.valueOf(jugador1.getPuntos()));

        carta = darcarta();
        puntos = valordelacarta(carta.getValor(), jugador2);
        mano2.add(puntos);
        val = dibujocarta(carta.getValor());
        val8.setText(val);
        pintarcarta(carta,carta8);
        sumarpuntos(jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

    }

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

    public static void mostrarnuevacarta(Cartas carta,int jugador) {

        if(jugador==2){
            String val = dibujocarta(carta.getValor());
            if(carta9.getVisibility()==View.INVISIBLE){
                carta9.setVisibility(View.VISIBLE);
                val9.setVisibility(View.VISIBLE);
                val9.setText(val);
                pintarcarta(carta,carta9);
            } else  if(carta10.getVisibility()==View.INVISIBLE){
                carta10.setVisibility(View.VISIBLE);
                val10.setVisibility(View.VISIBLE);
                val10.setText(val);
                pintarcarta(carta,carta10);
            }else  if(carta11.getVisibility()==View.INVISIBLE){
                carta11.setVisibility(View.VISIBLE);
                val11.setVisibility(View.VISIBLE);
                val11.setText(val);
                pintarcarta(carta,carta11);
            }else  if(carta12.getVisibility()==View.INVISIBLE){
                carta12.setVisibility(View.VISIBLE);
                val12.setVisibility(View.VISIBLE);
                val12.setText(val);
                pintarcarta(carta,carta12);
            }
        }else if (jugador ==1){
            String val = dibujocarta(carta.getValor());
            if(carta3.getVisibility()==View.INVISIBLE){
                carta3.setVisibility(View.VISIBLE);
                val3.setVisibility(View.VISIBLE);
                val3.setText(val);
                pintarcarta(carta,carta3);
            } else  if(carta4.getVisibility()==View.INVISIBLE){
                carta4.setVisibility(View.VISIBLE);
                val4.setVisibility(View.VISIBLE);
                val4.setText(val);
                pintarcarta(carta,carta4);
            }else  if(carta5.getVisibility()==View.INVISIBLE){
                carta5.setVisibility(View.VISIBLE);
                val5.setVisibility(View.VISIBLE);
                val5.setText(val);
                pintarcarta(carta,carta5);
            }else  if(carta6.getVisibility()==View.INVISIBLE){
                carta6.setVisibility(View.VISIBLE);
                val6.setVisibility(View.VISIBLE);
                val6.setText(val);
                pintarcarta(carta,carta6);
            }}

    }

    public static Cartas darcarta(){
        Cartas carta= baraja.get(0);

        baraja.remove(0);
        return carta;
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
