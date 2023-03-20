package com.example.vinted.lst_Productos.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.ver_prenda.view.prendaActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LstProductosAdapter  extends RecyclerView.Adapter<LstProductosAdapter.ViewHolder> {
    private ArrayList<Producto> lstProducto;
    private Context mContext;
    private LstProductosActivity listaProductos;


    public void onAttach(LstProductosActivity activity){
        this.listaProductos = activity;
    }

    public LstProductosAdapter(Context mContext, ArrayList<Producto> lstProducto){

        this.lstProducto = lstProducto;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_producto,parent,false);
        return new ViewHolder(view);
    }

    //RECOGER DATOS DEL FRONT
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto r = lstProducto.get(position);
        holder.Id_producto.setText(String.valueOf(r.getId_Producto()));
        holder.Nombre.setText(r.getNombre());
        Picasso.get().load(r.getImagen()).into(holder.Imagen);
        holder.Precio.setText(String.valueOf(r.getPrecio()));
        holder.BotonVerPrenda.setOnClickListener(new View.OnClickListener() {

        String id = String.valueOf(holder.Id_producto.getText());
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), prendaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.putExtra("id", 6);
                intent.putExtra("id", id);

                view.getContext().startActivity(intent);

            }
        });

    };


    @Override
    public int getItemCount() {
        return lstProducto.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Id_producto;
        private TextView Nombre;
        private ImageView Imagen;
        private TextView Precio;
        Button BotonVerPrenda;

        public ViewHolder(View itemView) {
            super(itemView);

            Id_producto = itemView.findViewById(R.id.ID_PRODCUTO);
            Nombre = itemView.findViewById(R.id.TITULO);
            Imagen=(ImageView)itemView.findViewById(R.id.IMAGEN);
            Precio = itemView.findViewById(R.id.PRECIO);
            BotonVerPrenda = (Button) itemView.findViewById(R.id.BotonVerPrenda);

    }
    }
}
