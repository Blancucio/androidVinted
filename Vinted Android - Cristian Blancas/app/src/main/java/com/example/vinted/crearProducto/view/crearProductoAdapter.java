package com.example.vinted.crearProducto.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_categoria.view.LstProductosCategoriaAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class crearProductoAdapter extends RecyclerView.Adapter<crearProductoAdapter.ViewHolder>{
    private ArrayList<Producto> lstProducto;
    private Context mContext;

    @Override
    public crearProductoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_crear_producto,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto r = lstProducto.get(position);
        holder.Id_producto.setText(String.valueOf(r.getId_Producto()));
        holder.nombreEditText.setText(r.getNombre());
        Picasso.get().load(r.getImagen()).into(holder.Imagen);
        holder.Precio.setText(String.valueOf(r.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Id_producto;
        private TextView nombreEditText;
        private ImageView Imagen;
        private TextView Categoria;
        private TextView Descripcion;
        private TextView Puntuacion;
        private TextView Precio;

        public ViewHolder(View itemView) {
            super(itemView);

            nombreEditText = itemView.findViewById(R.id.nombre);
            Categoria = itemView.findViewById(R.id.categoria);
            Descripcion = itemView.findViewById(R.id.descripcion);
            Precio = itemView.findViewById(R.id.precio);
            Puntuacion = itemView.findViewById(R.id.puntuacion);

        }
    }
}
