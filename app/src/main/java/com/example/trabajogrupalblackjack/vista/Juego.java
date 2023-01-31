package com.example.trabajogrupalblackjack.vista;

import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador1;
import static com.example.trabajogrupalblackjack.vista.MenuInicial.jugador2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    public static  ArrayList<Cartas> baraja = new ArrayList<>(51);

    public static ImageView pedircartaplayer1;
    public static ImageView pedircartaplayer2;

    public static ImageView plantarseplayer1;
    public static ImageView plantarseplayer2;

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

        cancelarPlantarse(MenuInicial.jugador1, jugador2, plantarseplayer1, plantarseplayer2);
        if(calcularfin()){
            ganador = comprobarganador(MenuInicial.jugador1, jugador2, this);
            guardardatosganador(ganador);
        }

        pedircartaplayer1.setOnClickListener(v->{

            Metodos.crearsonido(getApplicationContext(), "sonido5");
            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(),MenuInicial.jugador1);
            mano1.add(puntos);
            mostrarnuevacarta(carta,1);
            sumarpuntos(MenuInicial.jugador1,puntos,mano1);
            lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1, jugador2, this);
                guardardatosganador(ganador);
            } if(jugador2.getPlantado()){
                seguirturno(1);
            }
            else{
                finturno(1);
            }
        });

        pedircartaplayer2.setOnClickListener(v->{

            Metodos.crearsonido(getApplicationContext(), "sonido5");
            Cartas carta = darcarta();
            int puntos = valordelacarta(carta.getValor(), jugador2);
            mano2.add(puntos);
            mostrarnuevacarta(carta,2);
            sumarpuntos(jugador2,puntos,mano2);
            lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

            if(calcularfin()){
                ganador = comprobarganador(MenuInicial.jugador1, jugador2, this);
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

            MenuInicial.jugador1.setPlantado(true);
            if(MenuInicial.jugador1.getPlantado() && jugador2.getPlantado()){
                alertasfinal(" HABEIS EMPATADO", new Player("", false, 0), this);
            } else {

                if (!jugador2.getPlantado()) {
                    //   MenuInicial.jugador1.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(MenuInicial.jugador1, jugador2, this);
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
            if(MenuInicial.jugador1.getPlantado() && jugador2.getPlantado()){
                alertasfinal("HABEIS EMPATADO", new Player("", false, 0), this);
            } else {
                if (!MenuInicial.jugador1.getPlantado()) {
                    //  MenuInicial.jugador2.setPlantado(true);
                    if (calcularfin()) {
                        ganador = comprobarganador(MenuInicial.jugador1, jugador2, this);
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
        mano1.clear();
        mano2.clear();
        ArrayList<String> valores = new ArrayList<>(52);
        String linea = getString(R.string.valorcartas);
        cargarbaraja(linea,valores);

    }

    public void cancelarPlantarse(Player player1, Player player2, ImageView btnplantarse1, ImageView btnplantarse2){
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

    private void cargarbaraja(String linea,ArrayList<String> valores) {


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
        puntos = valordelacarta(carta.getValor(), jugador2);
        mano2.add(puntos);
        val = dibujocarta(carta.getValor());
        val7.setText(val);
        pintarcarta(carta,carta7);
        sumarpuntos(jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

        carta = darcarta();
        puntos = valordelacarta(carta.getValor(),MenuInicial.jugador1);
        mano1.add(puntos);
        val = dibujocarta(carta.getValor());
        val2.setText(val);
        pintarcarta(carta,carta2);
        sumarpuntos(MenuInicial.jugador1,puntos,mano1);
        lblpuntos1.setText(String.valueOf(MenuInicial.jugador1.getPuntos()));

        carta = darcarta();
        puntos = valordelacarta(carta.getValor(), jugador2);
        mano2.add(puntos);
        val = dibujocarta(carta.getValor());
        val8.setText(val);
        pintarcarta(carta,carta8);
        sumarpuntos(jugador2,puntos,mano2);
        lblpuntos2.setText(String.valueOf(jugador2.getPuntos()));

    }

    private Cartas darcarta(){
        Cartas carta= baraja.get(0);

        baraja.remove(0);
        return carta;
    }

    private void mostrarnuevacarta(Cartas carta,int jugador) {

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

    private void seguirturno(int jugador){
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

    private boolean calcularfin(){
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

    private Player comprobarganador(Player jugador1, Player jugador2, Context context) {
        if (jugador1.getPuntos() > jugador2.getPuntos()) {

            if (jugador1.getPuntos() == 21) {
                Metodos.crearsonido(context, "sonido3");
                alertasfinal(" ENHORABUENA HAS CONSEGUIDO 21 PUNTOS", jugador1, context);
                return jugador1;

            } else if (jugador1.getPuntos() < 21) {
                Metodos.crearsonido(context, "sonido3");
                alertasfinal(" HAS GANADO", jugador1, context);
                return jugador1;
            } else if (jugador1.getPuntos() > 21) {
                Metodos.crearsonido(context, "sonido4");
                alertasfinal(" TE HAS PASADO DE PUNTOS", jugador1, context);
                return jugador2;

            }
        } else if (jugador1.getPuntos() < jugador2.getPuntos()) {

            if (jugador2.getPuntos() == 21) {
                Metodos.crearsonido(context, "sonido3");
                alertasfinal(" ENHORABUENA HAS CONSEGUIDO 21 PUNTOS", jugador2, context);
                return jugador2;

            } else if (jugador2.getPuntos() < 21) {
                Metodos.crearsonido(context, "sonido3");
                alertasfinal(" HAS GANADO", jugador2, context);
                return jugador2;
            } else if (jugador2.getPuntos() > 21) {
                Metodos.crearsonido(context, "sonido4");
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

    private void finturno(int jugador){
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

    private String dibujocarta(int valor){

        String val="";

        if(valor == 11){ val="J";}
        else if(valor == 12){val="Q";}
        else if(valor == 13){val = "K";}
        else {val = String.valueOf(valor);}
        return val;

    }

    private  void pintarcarta(Cartas carta, ImageView fondo){

        if(carta.getPalo().equals("brujula")){ fondo.setImageResource(R.drawable.cartabrujula);}
        if(carta.getPalo().equals("huesos")){ fondo.setImageResource(R.drawable.cartahuesos);}
        if(carta.getPalo().equals("barco")){ fondo.setImageResource(R.drawable.cartabarco);}
        if(carta.getPalo().equals("fruta")){ fondo.setImageResource(R.drawable.cartafruta);}


    }

    private  int valordelacarta(int numero, Player jugador){
        int valorcarta;
        if(numero == 1){

            valorcarta = unoonce(jugador);

        }
        else if(numero == 11){valorcarta = 10;}
        else if(numero == 12){valorcarta = 10;}
        else if(numero == 13){valorcarta = 10;}
        else {valorcarta = numero;}
        return valorcarta;
    }

    private  int unoonce(Player jugador){
        if(jugador.getPuntos()+ 11 <=21 ){

            return 11;

        }
        else
        {
            return 1;
        }

    }

    private  void sumarpuntos(Player jugador, int puntos,ArrayList<Integer> mano){

        if(jugador.getPuntos()+puntos>21) {
            for (int q = 0; q < mano.size(); q++) {
                if (mano.get(q) == 11){
                    mano.set(q,0) ;
                    jugador.setPuntos(jugador.getPuntos()-10);}
            }
        }

        jugador.setPuntos(jugador.getPuntos()+puntos) ;
    }

    private void alertasfinal(String msm,Player jugador, Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(jugador.getNombre() + msm);
        builder.setPositiveButton("VOLVER A JUGAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MenuInicial.jugador1.setPuntos(0);
                MenuInicial.jugador1.setPlantado(false);
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
                .setOnDismissListener(v->{finish();});
        builder.show();

    }

    private void guardardatosganador(Player win){
        if(win.equals(MenuInicial.jugador1))
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

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.boton1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("¿Cómo jugar?");


            builder.setPositiveButton("Volver", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

}
