package com.example.vinted.lst_categoria.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.view.LstProductosAdapter;
import com.example.vinted.lst_categoria.LstProductoCategoriaContract;
import com.example.vinted.lst_categoria.presenter.LstProductosCategoriaPresenter;

import java.util.ArrayList;

public class LstProductosCategoriaActivity extends AppCompatActivity implements LstProductoCategoriaContract.View{
    private LstProductosCategoriaPresenter lstProductosCategoriaPresenter;
    private RecyclerView recyclerView;
    private Spinner spinner;
    private TextView plainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_productoscategoria);
        initComponents();
        initPresenter();
        //initData();
    }
    public void initComponents(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{"Todos","Ropa", "Accesorios"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        plainText = (TextView) findViewById(R.id.plainTextNombre);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                initData(parent.getItemAtPosition(position).toString(), plainText.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se ha seleccionado ninguna opción
            }
        });




        //ArrayAdapter<CharSequence> adapter = createFromResource(this);
        //spinner.setAdapter(adapter);
    }
    public void initPresenter(){
        lstProductosCategoriaPresenter = new LstProductosCategoriaPresenter(this);
    }
    public void initData(String categoria, String nombre){
        Producto product = new Producto();
        product.setCategoria(categoria);
        product.setNombre(nombre);
        lstProductosCategoriaPresenter.lstProducto(product); }

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
