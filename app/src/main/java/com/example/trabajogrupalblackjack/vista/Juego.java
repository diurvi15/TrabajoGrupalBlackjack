package com.example.trabajogrupalblackjack.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.trabajogrupalblackjack.R;

public class Juego extends AppCompatActivity {

    private Button pedircarta;
    private Button plantarseplayer1;
    private Button plantarseplayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        recogerControles();
    }

    private void recogerControles(){
        /*pedircarta = findViewById(R.id.);
        plantarseplayer1 = findViewById(R.id.);
        plantarseplayer2 = findViewById(R.id.);*/
    }
}