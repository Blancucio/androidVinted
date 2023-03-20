package com.example.vinted.lst_UsuariosVentas.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.usuario.Usuario;
import com.example.vinted.lst_UsuariosVentas.LstUsuarioVentasContract;
import com.example.vinted.lst_UsuariosVentas.presenter.LstUsuariosVentasPresenter;

import java.util.ArrayList;

public class LstUsuariosVentasActivity extends AppCompatActivity implements LstUsuarioVentasContract.View {

    private LstUsuariosVentasAdapter lstUsuariosVentasAdapter;
    private LstUsuariosVentasPresenter lstUsuariosVentasPresenter;
    private RecyclerView recyclerView;


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
    };
    public void initPresenter(){
        lstUsuariosVentasPresenter = new LstUsuariosVentasPresenter(this);
    }
    public void initData(){ lstUsuariosVentasPresenter.LstUsuarioVentas(null);} //SELECT * FROM SIMPSON

    @Override
    public void onSuccessLstUsuarioVentas(ArrayList<Usuario> lstUsuario) {
        LstUsuariosVentasAdapter adapter = new LstUsuariosVentasAdapter(getBaseContext(),lstUsuario);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailureLstUsuarioVentas(String err) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show();
    }
}
