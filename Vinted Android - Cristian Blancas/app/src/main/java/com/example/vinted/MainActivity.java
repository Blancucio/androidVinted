package com.example.vinted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.vinted.crearProducto.view.CrearProductoActivity;
import com.example.vinted.lstProductosUsuario.view.LstProductosUsuarioActivity;
import com.example.vinted.lst_MayorValoracion.view.LstProductosValActivity;
import com.example.vinted.lst_Productos.view.LstProductosActivity;
import com.example.vinted.lst_UsuariosVentas.view.LstUsuariosVentasActivity;
import com.example.vinted.lst_categoria.view.LstProductosCategoriaActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void evento(View view){
        Class crearIntent = null;
        switch (view.getId()){

            case R.id.vistalstMisProductos:
                crearIntent = LstProductosUsuarioActivity.class;
                break;

            case R.id.vistalstProductos:
               crearIntent = LstProductosActivity.class;
                break;

            case R.id.vistalstUsuarios:
                crearIntent = LstUsuariosVentasActivity.class;
                break;
            case R.id.vistalstProductosValoracion:
                crearIntent = LstProductosValActivity.class;
                break;
            case R.id.vistalstProductosCategoria:
                crearIntent = LstProductosCategoriaActivity.class;
                break;

            case R.id.vistaCrearProducto:
                crearIntent = CrearProductoActivity.class;
                break;
        }
        Intent intent = new Intent(getBaseContext(), crearIntent);
        startActivity(intent);
    }

}