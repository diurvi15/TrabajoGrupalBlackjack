package com.example.trabajogrupalblackjack.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        prepararpartida();

        pedircartaplayer1.setOnClickListener(v->{

            int numero = sacarnumero();
            actualizarpool();
            int puntos = valordelacarta(numero, MenuInicial.jugador1);
            sumarpuntos(MenuInicial.jugador1,puntos);

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
            }
            if(!MenuInicial.jugador2.getPlantado()) {
            disabletraspedir1();
            }
        });

        pedircartaplayer2.setOnClickListener(v->{

            int numero = sacarnumero();
            actualizarpool();
            int puntos = valordelacarta(numero,MenuInicial.jugador2);
            sumarpuntos(MenuInicial.jugador2,puntos);
            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
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
                }
                disabletraspedir1();
            }
        });

        plantarseplayer2.setOnClickListener(v->{
            if(!MenuInicial.jugador1.getPlantado()) {
                MenuInicial.jugador2.setPlantado(true);
                if(calcularfin()){
                    ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2);
                }
               disabletraspedir2();
            }
        });
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
    }

}
