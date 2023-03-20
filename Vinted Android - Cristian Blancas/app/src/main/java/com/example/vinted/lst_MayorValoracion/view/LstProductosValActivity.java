package com.example.vinted.lst_MayorValoracion.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_MayorValoracion.LstProductoValContract;
import com.example.vinted.lst_MayorValoracion.presenter.LstProductosValPresenter;
import com.example.vinted.lst_Productos.LstProductoContract;
import com.example.vinted.lst_Productos.view.LstProductosAdapter;

import java.util.ArrayList;

public class LstProductosValActivity extends AppCompatActivity implements LstProductoValContract.View {
    private LstProductosValPresenter lstProductosValPresenter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_mayorvaloracion);
        initComponents();
        initPresenter();
        initData();

    }
    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    };
    public void initPresenter(){ lstProductosValPresenter = new LstProductosValPresenter(this) ; }
    public void initData(){lstProductosValPresenter.lstProductoVal(null); }

    @Override
    public void onSuccessLstProductoVal(ArrayList<Producto> lstProductoVal) {
        LstProductosAdapter adapter = new LstProductosAdapter(getBaseContext(),lstProductoVal);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureLstProductoVal(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}
