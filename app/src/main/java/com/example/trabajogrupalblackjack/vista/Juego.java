package com.example.trabajogrupalblackjack.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.modelo.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Juego extends AppCompatActivity {

    public  ArrayList<String> valores;
    private Button pedircartaplayer1;
    private Button pedircartaplayer2;
    private Button plantarseplayer1;
    private Button plantarseplayer2;
    public  Player ganador;
    private TextView lblpuntos1;
    private TextView lblpuntos2;

    private ImageView carta1;
    private ImageView carta2;
    private ImageView carta3;
    private ImageView carta4;
    private ImageView carta5;
    private ImageView carta6;
    private ImageView carta7;
    private ImageView carta8;
    private ImageView carta9;
    private ImageView carta10;
    private ImageView carta11;
    private ImageView carta12;
    private TextView val1;
    private TextView val2;
    private TextView val3;
    private TextView val4;
    private TextView val5;
    private TextView val6;
    private TextView val7;
    private TextView val8;
    private TextView val9;
    private TextView val10;
    private TextView val11;
    private TextView val12;


    //DESPUES DE LOS CALCULAR FIN UN MENSAJE DEL GANADOR Y GUARDAR SUS DATOS
    //PONER IMAGENES DE PALOS PARA LAS CARTAS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        prepararpartida();
        primerascartas();
        if(calcularfin()){
            ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
            guardardatosganador(ganador);
        }

        pedircartaplayer1.setOnClickListener(v->{

            int numero = sacarnumero();
            actualizarpool();
            int puntos = valordelacarta(numero, MenuInicial.jugador1);
            mostrarnuevacartaj1(puntos);
            sumarpuntos(MenuInicial.jugador1,puntos);
            lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
                guardardatosganador(ganador);
            }
            if(!MenuInicial.jugador2.getPlantado()) {
            disabletraspedir1();
            }
        });

        pedircartaplayer2.setOnClickListener(v->{

            int numero = sacarnumero();
            actualizarpool();
            int puntos = valordelacarta(numero,MenuInicial.jugador2);
            mostrarnuevacartaj2(puntos);
            sumarpuntos(MenuInicial.jugador2,puntos);
            lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));
            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
                guardardatosganador(ganador);
            }
            if(!MenuInicial.jugador1.getPlantado()) {
            disabletraspedir2();
            }
        });

        plantarseplayer1.setOnClickListener(v->{
            if(!MenuInicial.jugador2.getPlantado()) {
                MenuInicial.jugador1.setPlantado(true);
                if(calcularfin()){
                    ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
                    guardardatosganador(ganador);
                }
                disabletraspedir1();
            }
        });

        plantarseplayer2.setOnClickListener(v->{
            if(!MenuInicial.jugador1.getPlantado()) {
                MenuInicial.jugador2.setPlantado(true);
                if(calcularfin()){
                    ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
                    guardardatosganador(ganador);
                }
               disabletraspedir2();
            }
        });
    }

    private void guardardatosganador(Player win){
        if(win.equals(MenuInicial.jugador1))
        {
            // METODO DEL CSV y MENSAJE EN ALERTDIALOG
             }else if(win.equals(MenuInicial.jugador2)){
            //METODO CSV
        }else{
            //SOLO MENSAJE DE DIALOG
        }
    }



    private void primerascartas() {
        int numero = sacarnumero();
        val1.setText(String.valueOf(numero));
        actualizarpool();
        int puntos = valordelacarta(numero,MenuInicial.jugador1);
        sumarpuntos(MenuInicial.jugador1,puntos);
        lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

        numero = sacarnumero();
        val7.setText(String.valueOf(numero));
        actualizarpool();
         puntos = valordelacarta(numero,MenuInicial.jugador2);
        sumarpuntos(MenuInicial.jugador2,puntos);
        lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));

        numero = sacarnumero();
        val2.setText(String.valueOf(numero));
        actualizarpool();
        puntos = valordelacarta(numero,MenuInicial.jugador1);
        sumarpuntos(MenuInicial.jugador1,puntos);
        lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

        numero = sacarnumero();
        val8.setText(String.valueOf(numero));
        actualizarpool();
        puntos = valordelacarta(numero,MenuInicial.jugador2);
        sumarpuntos(MenuInicial.jugador2,puntos);
        lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));

    }



    private void mostrarnuevacartaj1(int puntos) {

        if(carta3.getVisibility()==View.INVISIBLE){
            carta3.setVisibility(View.VISIBLE);
            val3.setVisibility(View.VISIBLE);
            val3.setText(String.valueOf(puntos));
        } else  if(carta4.getVisibility()==View.INVISIBLE){
            carta4.setVisibility(View.VISIBLE);
            val4.setVisibility(View.VISIBLE);
            val4.setText(String.valueOf(puntos));
        }else  if(carta5.getVisibility()==View.INVISIBLE){
            carta5.setVisibility(View.VISIBLE);
            val5.setVisibility(View.VISIBLE);
            val5.setText(String.valueOf(puntos));
        }else  if(carta6.getVisibility()==View.INVISIBLE){
            carta6.setVisibility(View.VISIBLE);
            val6.setVisibility(View.VISIBLE);
            val6.setText(String.valueOf(puntos));
        }

    }

    private void mostrarnuevacartaj2(int puntos) {

        if(carta9.getVisibility()==View.INVISIBLE){
            carta9.setVisibility(View.VISIBLE);
            val9.setVisibility(View.VISIBLE);
            val9.setText(String.valueOf(puntos));
        } else  if(carta10.getVisibility()==View.INVISIBLE){
            carta10.setVisibility(View.VISIBLE);
            val10.setVisibility(View.VISIBLE);
            val10.setText(String.valueOf(puntos));
        }else  if(carta11.getVisibility()==View.INVISIBLE){
            carta11.setVisibility(View.VISIBLE);
            val11.setVisibility(View.VISIBLE);
            val11.setText(String.valueOf(puntos));
        }else  if(carta12.getVisibility()==View.INVISIBLE){
            carta12.setVisibility(View.VISIBLE);
            val12.setVisibility(View.VISIBLE);
            val12.setText(String.valueOf(puntos));
        }

    }

    private void disabletraspedir2() {
        pedircartaplayer2.setEnabled(false);
        plantarseplayer2.setEnabled(false);
        pedircartaplayer1.setEnabled(true);
        plantarseplayer1.setEnabled(true);
    }
    private void disabletraspedir1() {
        pedircartaplayer2.setEnabled(true);
        plantarseplayer2.setEnabled(true);
        pedircartaplayer1.setEnabled(false);
        plantarseplayer1.setEnabled(false);
    }

    private void prepararpartida() {

        recogerControles();
        cargarbaraja();

    }

    private void cargarbaraja() {
        valores = new ArrayList<>(52);
        String linea = getString(R.string.valorcartas);
        String[] trozos =linea.split(";");
        valores.addAll(Arrays.asList(trozos));

        Collections.shuffle(valores);
    }

    private void sumarpuntos(Player jugador, int puntos){
        jugador.setPuntos(jugador.getPuntos()+puntos) ;
    }

    private int valordelacarta(int numero,Player jugador){
        int valorcarta;
        if(numero == 1){valorcarta = unoonce(jugador);}
        else if(numero == 11){valorcarta = 10;}
        else if(numero == 12){valorcarta = 10;}
        else if(numero == 13){valorcarta = 10;}
        else {valorcarta = numero;}
        return valorcarta;
    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA BORRAR VALORES DEL ARRAY DE VALORES QUE YA SE HAN USADO
    public void actualizarpool(){
      /*  String num = String.valueOf(numero);
        for(int q = 0;q<valores.size();q++){
            if(valores.get(q).equals(num)){
                valores.remove(q);
                break;
            } }*/
        valores.remove(0);
    }

    //ESTE METODO ES PARA ELGIR QUE VALOR TENDRA EL AS
    public int unoonce(Player jugador){
        if(jugador.getPuntos()+ 11 <21 ){
            //AQUI VA UN ALERT DIALOG PARA ELEGIR 1 o 11
        }else if(jugador.getPuntos() + 11 == 21)
        {
            return 11;
        }
        else
        {
            return 1;
        }
        return 1;
    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA VER SI SE HA ACABADO LA PARTIDA, CADA VEZ QUE SE PIDA CARTA HAY QUE LLAMAR A ESTE METODO
    public boolean calcularfin(){
        if(MenuInicial.jugador1.getPlantado() && MenuInicial.jugador2.getPuntos() > MenuInicial.jugador1.getPuntos()
                ||
                MenuInicial.jugador2.getPlantado() && MenuInicial.jugador1.getPuntos() > MenuInicial.jugador2.getPuntos())
        {return true;}
        else if(MenuInicial.jugador1.getPuntos()>=21||MenuInicial.jugador2.getPuntos()>=21)
        {return true;}

        else{return false;}

    }

    private Player comprobarganador(Player jugador1, Player jugador2) {
        if(jugador1.getPuntos() > jugador2.getPuntos()){
            if(jugador1.getPuntos() - 21 <=0){return jugador1;}
            else if(jugador2.getPuntos() - 21 <=0){return jugador2;}
            else{return new Player("Empate",true,0);}
        }else if(jugador1.getPuntos()< jugador2.getPuntos()){
            if(jugador1.getPuntos() - 21 <=0){return jugador1;}
            else if(jugador2.getPuntos() - 21 <=0){return jugador2;}
            else{return new Player("Empate",true,0);}
        }else{return new Player("Empate",true,0);}
    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA SACAR UN NUMERO ALEATORIO DE EL ARRAY DE VALORES
    private int sacarnumero(){

        //int aleatorio = (int) Math.random()*13+1; //ESTA FORMULA HAY Q RETOCARLA PARA Q VAYA DEL 1 A 13

        return Integer.parseInt(valores.get(0));
    }

    private void recogerControles(){
        pedircartaplayer1 = findViewById(R.id.j1pedircarta);
        pedircartaplayer2 = findViewById(R.id.j2pedircarta);
        plantarseplayer1 = findViewById(R.id.j1plantarse);
        plantarseplayer2 = findViewById(R.id.j2plantarse);
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

}
