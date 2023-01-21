package com.example.trabajogrupalblackjack.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.trabajogrupalblackjack.R;

public class Juego extends AppCompatActivity {

    public String[] valores={"1","2"}; //ESTA INICIACION ES TEMPORAL AQUI FALTA CONECTARLO CON EL STRING ARRAY DE VALUES .split(";");

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
        for(int q = 0;q<valores.length;q++){
            if(valores[q].equals(num)){

                valores[q] = ""; //HAY QUE COMPROBAR SI ESTE METODO BORRA EL NUMERO DEL ARRAY
                break;
            } }

    }

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA SACAR UN NUMERO ALEATORIO DE EL ARRAY DE VALORES
    private int sacarnumero(){

        int aleatorio = (int) Math.random()*10; //ESTA FORMULA HAY Q RETOCARLA PARA Q VAYA DEL 1 A 13

        int numero = Integer.parseInt(valores[aleatorio]);

        return numero;
    }


    private void recogerControles(){
        pedircartaplayer1 = findViewById(R.id.j1pedircarta);
        pedircartaplayer2 = findViewById(R.id.j2pedircarta);
        plantarseplayer1 = findViewById(R.id.j1plantarse);
        plantarseplayer2 = findViewById(R.id.j2plantarse);
    }
}