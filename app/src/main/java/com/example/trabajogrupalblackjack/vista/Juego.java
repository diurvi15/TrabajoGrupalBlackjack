package com.example.trabajogrupalblackjack.vista;

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
import com.example.trabajogrupalblackjack.modelo.Cartas;
import com.example.trabajogrupalblackjack.modelo.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Juego extends AppCompatActivity {


    public  ArrayList<Integer> mano1 = new ArrayList<>();
    public  ArrayList<Integer> mano2= new ArrayList<>();
    public  ArrayList<Cartas> baraja = new ArrayList<>(51);

    private ImageView pedircartaplayer1;
    private ImageView pedircartaplayer2;

    private ImageView plantarseplayer1;
    private ImageView plantarseplayer2;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        prepararpartida();
        primerascartas();

        cancelarPlantarse(MenuInicial.jugador1, MenuInicial.jugador2, plantarseplayer1, plantarseplayer2);
        if(calcularfin()){
            ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2, this);
            guardardatosganador(ganador);
        }

        pedircartaplayer1.setOnClickListener(v->{

            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(),MenuInicial.jugador1);
            mano1.add(puntos);
            mostrarnuevacartaj1(carta);
            sumarpuntos(MenuInicial.jugador1,puntos,mano1);
            lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2, this);
                guardardatosganador(ganador);
            }
            if(!MenuInicial.jugador2.getPlantado()) {
            disabletraspedir1();
            }
        });

        pedircartaplayer2.setOnClickListener(v->{

            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(),MenuInicial.jugador2);
            mano2.add(puntos);
            mostrarnuevacartaj2(carta);
            sumarpuntos(MenuInicial.jugador2,puntos,mano2);
            lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1,MenuInicial.jugador2, this);
                guardardatosganador(ganador);
            }
            if(!MenuInicial.jugador1.getPlantado()) {
                disabletraspedir2();
            }
        });


        plantarseplayer1.setOnClickListener(v->{
            Metodos.crearsonido(this, "sonido1");

            MenuInicial.jugador1.setPlantado(true);
            if(MenuInicial.jugador1.getPlantado() && MenuInicial.jugador2.getPlantado()){
                alertasfinal(" HABEIS EMPATADO", new Player("", false, 0), this);
            } else {

                if (!MenuInicial.jugador2.getPlantado()) {
                    MenuInicial.jugador1.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(MenuInicial.jugador1, MenuInicial.jugador2, this);
                        guardardatosganador(ganador);
                    } else {
                        disabletraspedir1();
                    }
                }
            }
        });

        plantarseplayer2.setOnClickListener(v->{
            Metodos.crearsonido(this, "sonido1");

            MenuInicial.jugador2.setPlantado(true);
            if(MenuInicial.jugador1.getPlantado() && MenuInicial.jugador2.getPlantado()){
                alertasfinal("HABEIS EMPATADO", new Player("", false, 0), this);
            } else {
                if (!MenuInicial.jugador1.getPlantado()) {
                    MenuInicial.jugador2.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(MenuInicial.jugador1, MenuInicial.jugador2, this);
                        guardardatosganador(ganador);
                    } else {
                        disabletraspedir2();
                    }
                }
            }
        });
    }

    private void guardardatosganador(Player win){
        if(win.equals(MenuInicial.jugador1))
        {
            Metodos.lineaInicialFichero(this);
           Metodos.creacionFicheroEstadisticas(this,win.toString() + ";" + Metodos.conseguirFechaActual()); // METODO DEL CSV y MENSAJE EN ALERTDIALOG
             }else if(win.equals(MenuInicial.jugador2)){
            Metodos.lineaInicialFichero(this);
            Metodos.creacionFicheroEstadisticas(this,win.toString() + ";" + Metodos.conseguirFechaActual());//METODO CSV
        }else{
            alertasfinal("EMPATE",win, this);
        }
    }

    private Cartas darcarta(){
   Cartas carta= baraja.get(0);

    baraja.remove(0);
     return carta;
}

    private void pintarcarta(Cartas carta,ImageView fondo){

        if(carta.getPalo().equals("brujula")){ fondo.setImageResource(R.drawable.cartabrujula);}
        if(carta.getPalo().equals("huesos")){ fondo.setImageResource(R.drawable.cartahuesos);}
        if(carta.getPalo().equals("barco")){ fondo.setImageResource(R.drawable.cartabarco);}
        if(carta.getPalo().equals("fruta")){ fondo.setImageResource(R.drawable.cartafruta);}


}


    private void primerascartas() {

        Cartas carta = darcarta();
        int puntos = valordelacarta(carta.getValor(),MenuInicial.jugador1);
        mano1.add(puntos);
        String val = dibujocarta(carta.getValor());
        val1.setText(val);
        pintarcarta(carta,carta1);
        sumarpuntos(MenuInicial.jugador1,puntos,mano1);
        lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

         carta = darcarta();
         puntos = valordelacarta(carta.getValor(),MenuInicial.jugador2);
        mano2.add(puntos);
         val = dibujocarta(carta.getValor());
        val7.setText(val);
        pintarcarta(carta,carta7);
        sumarpuntos(MenuInicial.jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));

         carta = darcarta();
         puntos = valordelacarta(carta.getValor(),MenuInicial.jugador1);
        mano1.add(puntos);
         val = dibujocarta(carta.getValor());
        val2.setText(val);
        pintarcarta(carta,carta2);
        sumarpuntos(MenuInicial.jugador1,puntos,mano1);
        lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

         carta = darcarta();
         puntos = valordelacarta(carta.getValor(),MenuInicial.jugador2);
        mano2.add(puntos);
         val = dibujocarta(carta.getValor());
        val8.setText(val);
        pintarcarta(carta,carta8);
        sumarpuntos(MenuInicial.jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(MenuInicial.jugador2.getPuntos()));


    }

    private void mostrarnuevacartaj1(Cartas carta) {

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
        }

    }

    private void mostrarnuevacartaj2(Cartas carta) {

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

    }

    private void disabletraspedir2() {
        pedircartaplayer2.setEnabled(false);
        plantarseplayer2.setEnabled(false);
        pedircartaplayer1.setEnabled(true);

        if(MenuInicial.jugador1.getPuntos() < 17){
            plantarseplayer1.setVisibility(View.INVISIBLE);
            plantarseplayer1.setEnabled(false);
        } else if(MenuInicial.jugador1.getPuntos() < MenuInicial.jugador2.getPuntos()){
            plantarseplayer1.setVisibility(View.INVISIBLE);
            plantarseplayer1.setEnabled(false);
        } else if(MenuInicial.jugador1.getPuntos() == MenuInicial.jugador2.getPuntos()){
            plantarseplayer1.setVisibility(View.VISIBLE);
            plantarseplayer1.setEnabled(true);
        } else{
            plantarseplayer1.setVisibility(View.VISIBLE);
            plantarseplayer1.setEnabled(true);
        }
    }

    private void disabletraspedir1() {
        pedircartaplayer1.setEnabled(false);
        plantarseplayer1.setEnabled(false);
        pedircartaplayer2.setEnabled(true);

        if(MenuInicial.jugador2.getPuntos() < 17){
            plantarseplayer2.setVisibility(View.INVISIBLE);
            plantarseplayer2.setEnabled(false);
        } else if(MenuInicial.jugador2.getPuntos() < MenuInicial.jugador1.getPuntos()){
            plantarseplayer2.setVisibility(View.INVISIBLE);
            plantarseplayer2.setEnabled(false);
        } else if(MenuInicial.jugador2.getPuntos() == MenuInicial.jugador1.getPuntos()){
            plantarseplayer2.setVisibility(View.VISIBLE);
            plantarseplayer2.setEnabled(true);
        } else{
            plantarseplayer2.setVisibility(View.VISIBLE);
            plantarseplayer2.setEnabled(true);
        }
    }

    private void prepararpartida() {

        recogerControles();
        cargarbaraja();

    }

    private void cargarbaraja() {

       ArrayList<String> valores = new ArrayList<>(52);
        String linea = getString(R.string.valorcartas);
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

    private void sumarpuntos(Player jugador, int puntos,ArrayList<Integer> mano){

        if(jugador.getPuntos()+puntos>21) {
            for (int q = 0; q < mano.size(); q++) {
                if (mano.get(q) == 11){
                    mano.set(q,0) ;
                    jugador.setPuntos(jugador.getPuntos()-10);}
            }
        }

        jugador.setPuntos(jugador.getPuntos()+puntos) ;
    }

    private int valordelacarta(int numero,Player jugador){
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
    private String dibujocarta(int valor){

        String val="";

        if(valor == 11){ val="J";}
        else if(valor == 12){val="Q";}
        else if(valor == 13){val = "K";}
        else {val = String.valueOf(valor);}
        return val;

    }

    //ESTE METODO ES PARA ELGIR QUE VALOR TENDRA EL AS
    public int unoonce(Player jugador){
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

    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA VER SI SE HA ACABADO LA PARTIDA, CADA VEZ QUE SE PIDA CARTA HAY QUE LLAMAR A ESTE METODO
    public boolean calcularfin(){
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

    private void alertasfinal(String msm,Player jugador, Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(jugador.getNombre() + msm);
        builder.setPositiveButton("VOLVER A JUGAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MenuInicial.jugador1.setPuntos(0);
                MenuInicial.jugador1.setPlantado(false);
                MenuInicial.jugador2.setPuntos(0);
                MenuInicial.jugador2.setPlantado(false);

                lblpuntos1.setText(String.valueOf(0));
                lblpuntos2.setText(String.valueOf(0));

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

    private Player comprobarganador(Player jugador1, Player jugador2, Context context) {
        if (jugador1.getPuntos() > jugador2.getPuntos()) {

            if (jugador1.getPuntos() == 21) {

                alertasfinal(" ENHORABUENA HAS CONSEGUIDO 21 PUNTOS", jugador1, context);
                return jugador1;

            } else if (jugador1.getPuntos() < 21) {
                alertasfinal(" HAS GANADO", jugador1, context);
                return jugador1;
            } else if (jugador1.getPuntos() > 21) {
                alertasfinal(" TE HAS PASADO DE PUNTOS", jugador1, context);
                return jugador2;

            }
        } else if (jugador1.getPuntos() < jugador2.getPuntos()) {

            if (jugador2.getPuntos() == 21) {

                alertasfinal(" ENHORABUENA HAS CONSEGUIDO 21 PUNTOS", jugador2, context);
                return jugador2;

            } else if (jugador2.getPuntos() < 21) {
                alertasfinal(" HAS GANADO", jugador2, context);
                return jugador2;
            } else if (jugador2.getPuntos() > 21) {
                alertasfinal(" TE HAS PASADO DE PUNTOS", jugador2, context);
                return jugador1;
            }

        } else  {
            Player empate = new Player("Empate", true, 0);
            alertasfinal(" EMPATE", empate, context);
            return empate;
        }

        return null;

    }
    //ESTE METODO IRA DESPUES EN LA CARPETA CONTROLADOR
    //SIRVE PARA SACAR UN NUMERO ALEATORIO DE EL ARRAY DE VALORES


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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    //ALERT DIALOG INSTRUCCIONES

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.boton1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("¿Cómo jugar?");
            builder.setMessage(getString(R.string.info));

            builder.setPositiveButton("Volver", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }


    public void cancelarPlantarse(Player player1, Player player2, ImageView btnplantarse1, ImageView btnplantarse2){
    pedircartaplayer2.setEnabled(false);
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

}
