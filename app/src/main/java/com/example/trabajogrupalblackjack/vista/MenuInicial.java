package com.example.trabajogrupalblackjack.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trabajogrupalblackjack.R;

public class MenuInicial extends AppCompatActivity {

    private Button creditosBtn;
    private Button instruccionesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

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
                                    "Sergio Alejandre")
                        .setPositiveButton("Volver", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
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
}