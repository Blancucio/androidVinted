package com.example.vinted.ver_prenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.MainActivity;
import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.view.LstProductosAdapter;
import com.example.vinted.ver_prenda.PrendaContract;
import com.example.vinted.ver_prenda.presenter.LstPrendaPresenter;

import java.util.ArrayList;

public class prendaActivity extends AppCompatActivity implements PrendaContract.View {
    private LstPrendaPresenter lstPrendaPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prenda);

        String id = getIntent().getExtras().getString("id");

        initComponents();
        initPresenter();
        initData(id);

    }

    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    public void initPresenter(){
        lstPrendaPresenter = new LstPrendaPresenter(this);
    }
    public void initData(String id){
        Producto producto = new Producto();
        producto.setId_Producto(Integer.parseInt(id));
        lstPrendaPresenter.lstProducto(producto);
    }

    @Override
    public void onSuccessLstProducto(ArrayList<Producto> lstProducto) {
        LstProductosAdapter adapter = new LstProductosAdapter(getBaseContext(),lstProducto);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstProducto(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }

    public void confirmarCompra(View view) {
        Toast.makeText(this, "Has completado tu compra, muchas gracias!!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

}
