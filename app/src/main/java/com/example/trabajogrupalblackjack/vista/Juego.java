package com.example.trabajogrupalblackjack.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.modelo.Player;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {

    public ArrayList<String> valores; //ESTA INICIACION ES TEMPORAL AQUI FALTA CONECTARLO CON EL STRING ARRAY DE VALUES .split(";");

    private Button pedircartaplayer1;
    private Button pedircartaplayer2;
    private Button plantarseplayer1;
    private Button plantarseplayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        recogerControles();
    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA BORRAR VALORES DEL ARRAY DE VALORES QUE YA SE HAN USADO
    public void actualizarpool(int numero){

        String num = String.valueOf(numero);
        for(int q = 0;q<valores.size();q++){
            if(valores.get(q).equals(num)){

                valores.remove(q);
                break;
            } }

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
            {return 1;}

    return 0;
    }


    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA VER SI SE HA ACABADO LA PARTIDA, CADA VEZ QUE SE PIDA CARTA HAY QUE LLAMAR A ESTE METODO
    public boolean calcularfin(Player jugador1, Player jugador2){

    if(jugador1.getPuntos()>=21||jugador2.getPuntos()>=21)
    {return true;}
    else
    {return false;}

    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA SACAR UN NUMERO ALEATORIO DE EL ARRAY DE VALORES
    private int sacarnumero(){

        int aleatorio = (int) Math.random()*10+1; //ESTA FORMULA HAY Q RETOCARLA PARA Q VAYA DEL 1 A 13

        int numero = Integer.parseInt(valores.get(aleatorio));

        return numero;
    }


    private void recogerControles(){
        pedircartaplayer1 = findViewById(R.id.j1pedircarta);
        pedircartaplayer2 = findViewById(R.id.j2pedircarta);
        plantarseplayer1 = findViewById(R.id.j1plantarse);
        plantarseplayer2 = findViewById(R.id.j2plantarse);
    }



}