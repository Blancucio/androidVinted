package com.example.vinted.lstProductosUsuario.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.entities.usuario.Usuario;
import com.example.vinted.lstProductosUsuario.LstProductoUsuarioContract;
import com.example.vinted.lstProductosUsuario.presenter.LstProductosUsuarioPresenter;
import com.example.vinted.lst_Productos.view.LstProductosAdapter;

import java.util.ArrayList;

public class LstProductosUsuarioActivity extends AppCompatActivity implements LstProductoUsuarioContract.View{
    private LstProductosUsuarioPresenter lstProductosUsuarioPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_producto_usuario);
        initComponents();
        initPresenter();
        initData();

    }

    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
    public void initPresenter(){
        lstProductosUsuarioPresenter = new LstProductosUsuarioPresenter(this);
    }
    public void initData(){
        Producto product = new Producto();
        product.getUsuario().setId_usuario(1);
        lstProductosUsuarioPresenter.lstProducto(product);
    }

    @Override
    public void onSuccessLstProductoUsuario(ArrayList<Producto> lstProducto) {
        LstProductosAdapter adapter = new LstProductosAdapter(getBaseContext(),lstProducto);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstProductoUsuario(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }

}
