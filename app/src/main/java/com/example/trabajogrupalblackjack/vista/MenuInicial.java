package com.example.trabajogrupalblackjack.vista;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.controlador.Metodos;
import com.example.trabajogrupalblackjack.controlador.Metodos_Juego;
import com.example.trabajogrupalblackjack.modelo.Estadisticas;
import com.example.trabajogrupalblackjack.modelo.Player;

public class MenuInicial extends AppCompatActivity {

    private ImageView botonJugar2;
    private ImageView botonEstadisticas2;
    private ImageView btncreditos2;
    private EditText nombre1;
    private EditText nombre2;
    public static Player jugador1;
    public static Player jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        botonJugar2 = findViewById(R.id.btnJugar2);
        botonEstadisticas2 = findViewById(R.id.btnEstadisticas2);
        btncreditos2 = findViewById(R.id.btnCreditos2);

        botonJugar2.setOnClickListener(v-> DialogBotonJugar());

        Metodos_Juego.mostrarEstadisticas(this);
        botonEstadisticas2.setOnClickListener(v -> dialogStats());

        btncreditos2.setOnClickListener(v-> dialogCreds());
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


    private void DialogBotonJugar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EMPEZAR PARTIDA");

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.boton_jugar,null);

        builder.setNegativeButton("CERRAR",null);
        builder.setPositiveButton("JUGAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                nombre1 = view.findViewById(R.id.txtNombreJug1);
                nombre2 = view.findViewById(R.id.txtNombreJug2);

                if (Metodos.compruebaVacio(nombre1,getApplicationContext())){
                }else if (Metodos.compruebaVacio(nombre2,getApplicationContext())){
                }else if(Metodos.nombresDistintos(getApplicationContext(), nombre1, nombre2)){
                }else {
                    jugador1 = new Player(nombre1.getText().toString(),false, 0);
                    jugador2 = new Player(nombre2.getText().toString(),false, 0);

                    Intent intent = new Intent(getApplicationContext(), Juego.class);
                    startActivity(intent);

                    Metodos.crearsonido(getApplicationContext(), "sonido2");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }}
        });
        builder.setView(view);

        builder.show();


    }
    public void dialogStats() {

            StringBuilder builder = new StringBuilder();
            for (Estadisticas estadisticas: Metodos_Juego.mostrarEstadisticas(this)){
                builder.append(estadisticas.toString());
            }
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            dialogo.setTitle("Últimos diez mejores ganadores:");
            dialogo.setMessage(builder.toString());
            dialogo.setPositiveButton("Volver", null);
            View dialogoView = inflater.inflate(R.layout.dialog_estadisticas, null);
            dialogo.setView(dialogoView);
            dialogo.show();
    }

    public void dialogInstrucciones() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        dialogo.setPositiveButton("Volver", null);

        View dialogoView = inflater.inflate(R.layout.dialog_instrucciones, null);
        dialogo.setView(dialogoView);

        dialogo.show();

    }

    public void dialogCreds() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        dialogo.setPositiveButton("Volver", null);

        View dialogoView = inflater.inflate(R.layout.dialog_creditos, null);
        dialogo.setView(dialogoView);

        dialogo.show();

    }
}