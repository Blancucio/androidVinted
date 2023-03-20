package com.example.vinted.crearProducto.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.MainActivity;
import com.example.vinted.R;
import com.example.vinted.crearProducto.crearProductoContract;
import com.example.vinted.crearProducto.presenter.crearProductoPresenter;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lstProductosUsuario.view.LstProductosUsuarioActivity;
import com.example.vinted.lst_categoria.presenter.LstProductosCategoriaPresenter;

import java.util.ArrayList;

public class CrearProductoActivity extends AppCompatActivity implements crearProductoContract.View{
    private crearProductoPresenter lstCrearProductoPresenter;

    private TextView nombreEditText;
    private TextView categoriaEditText;
    private TextView descripcionEditText;
    private TextView precioEditText;
    private TextView puntuacionEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);
        initComponents();
        initPresenter();
        //initData();

    }

    public void initComponents(){
        nombreEditText = (TextView) findViewById(R.id.nombre);
        categoriaEditText = (TextView) findViewById(R.id.categoria);
        descripcionEditText = (TextView) findViewById(R.id.descripcion);
        precioEditText = (TextView) findViewById(R.id.precio);
        puntuacionEditText = (TextView) findViewById(R.id.puntuacion);
    }
    public void initPresenter(){
        lstCrearProductoPresenter = new crearProductoPresenter(this);
    }

    public void initData(){
        Producto product = new Producto();
        product.setNombre(nombreEditText.getText().toString());
        product.setCategoria(categoriaEditText.getText().toString());
        product.setDescripcion(descripcionEditText.getText().toString());
        product.setPrecio(Integer.parseInt(precioEditText.getText().toString()));
        product.setPuntuacion(Integer.parseInt(puntuacionEditText.getText().toString()));
        product.getUsuario().setId_usuario(1);
        lstCrearProductoPresenter.lstProducto(product);
    }


    public void insertar(View view){
        initData();
        Toast.makeText(this, "Producto insertado con éxito ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onSuccessLstProducto(ArrayList<Producto> lstProducto) {

    }

    @Override
    public void onFailureLstProducto(String err) {

    }
}
