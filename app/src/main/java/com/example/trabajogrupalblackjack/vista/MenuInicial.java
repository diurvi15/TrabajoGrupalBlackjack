package com.example.trabajogrupalblackjack.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajogrupalblackjack.R;
import com.example.trabajogrupalblackjack.controlador.Metodos;
import com.example.trabajogrupalblackjack.modelo.Player;

public class MenuInicial extends AppCompatActivity {

    private Button creditosBtn;
    private Button instruccionesBtn;
    private Button botonJugar;
    private EditText nombre1;
    private EditText nombre2;
    public static Player jugador1;
    public static Player jugador2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        botonJugar = findViewById(R.id.btnJugar);

        botonJugar.setOnClickListener(v->{
            DialogBotonJugar();
        });



        instruccionesBtn = (Button) findViewById(R.id.btnInstrucciones);
        instruccionesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder instrucciones = new AlertDialog.Builder(MenuInicial.this);
                instrucciones.setMessage("");
            }
        });

        creditosBtn = (Button) findViewById(R.id.btnCreditos);
        creditosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder creditos = new AlertDialog.Builder(MenuInicial.this);
                creditos.setMessage("Diego Urmente\n\n" +
                                    "Guillermo Fabián\n\n" +
                                    "Daniel Gimenez\n\n" +
                                    "Jose Miguel Marco\n\n" +
                                    "Sergio Alejaldre")
                        .setPositiveButton("Volver", null);

                AlertDialog titulo = creditos.create();
                titulo.setTitle("Aplicación realizada por:\n");
                titulo.show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.boton1){
            Intent intent = new Intent(getApplicationContext(), Juego.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    private View.OnClickListener DialogBotonJugar(){
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
                }}
        });
        builder.setView(view);

        builder.show();

        return null;
    }
}