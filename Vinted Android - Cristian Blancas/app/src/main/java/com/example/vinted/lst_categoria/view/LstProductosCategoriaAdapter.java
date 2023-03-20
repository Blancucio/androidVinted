package com.example.vinted.lst_categoria.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LstProductosCategoriaAdapter extends RecyclerView.Adapter<LstProductosCategoriaAdapter.ViewHolder>{
    private ArrayList<Producto> lstProducto;
    private Context mContext;

    public LstProductosCategoriaAdapter(Context mContext, ArrayList<Producto> lstProductos){
        this.lstProducto = lstProductos;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_lst_productoscategoria,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto r = lstProducto.get(position);
        holder.Id_producto.setText(String.valueOf(r.getId_Producto()));
        holder.Nombre.setText(r.getNombre());
        Picasso.get().load(r.getImagen()).into(holder.Imagen);
        holder.Precio.setText(String.valueOf(r.getPrecio()));

    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Id_producto;
        private TextView Nombre;
        //private TextView Imagen;
        private ImageView Imagen;
        private TextView Precio;

        public ViewHolder(View itemView) {
            super(itemView);

            Id_producto = itemView.findViewById(R.id.ID_PRODCUTO);
            Nombre = itemView.findViewById(R.id.TITULO);
            Imagen=(ImageView)itemView.findViewById(R.id.IMAGEN);
            Precio = itemView.findViewById(R.id.PRECIO);
        }
    }

}
