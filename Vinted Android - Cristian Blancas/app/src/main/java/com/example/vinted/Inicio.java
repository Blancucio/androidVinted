package com.example.vinted;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Intent intent = new Intent(getBaseContext(),LstProductosActivity.class);
        //Intent intent = new Intent(getBaseContext(), LstUsuariosVentasActivity.class);
        //startActivity(intent);
    }


    public void iniciar(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
