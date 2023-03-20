package com.example.vinted.lst_Productos.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.lst_Productos.presenter.LstProductosPresenter;

import java.util.ArrayList;

public class LstProductosActivity extends AppCompatActivity implements LstProductoContract.View {
    private LstProductosPresenter lstProductosPresenter;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_productos);

        initComponents();
        initPresenter();
        initData();

    }

    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
    public void initPresenter(){
        lstProductosPresenter = new LstProductosPresenter(this);
    }
    public void initData(){lstProductosPresenter.lstProducto(null); }

    @Override
    public void onSuccessLstProducto(ArrayList<Producto> lstProducto) {
        LstProductosAdapter adapter = new LstProductosAdapter(getBaseContext(),lstProducto);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstProducto(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }

}
