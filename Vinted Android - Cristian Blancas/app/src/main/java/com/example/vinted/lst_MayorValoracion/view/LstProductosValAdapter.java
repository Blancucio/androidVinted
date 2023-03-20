package com.example.vinted.lst_MayorValoracion.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.producto.Producto;
import com.example.vinted.lst_Productos.view.LstProductosAdapter;

import java.util.ArrayList;

public class LstProductosValAdapter extends RecyclerView.Adapter<LstProductosValAdapter.ViewHolder> {
    private ArrayList<Producto> lstProducto;
    private Context mContext;

    public LstProductosValAdapter(Context mContext, ArrayList<Producto> lstProducto){
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
        holder.Imagen.setText(r.getImagen());
        holder.Precio.setText(String.valueOf(r.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Id_producto;
        private TextView Nombre;
        private TextView Imagen;
        private TextView Precio;

        public ViewHolder(View itemView) {
            super(itemView);

            Id_producto = itemView.findViewById(R.id.ID_PRODCUTO);
            Nombre = itemView.findViewById(R.id.TITULO);
            Imagen = itemView.findViewById(R.id.IMAGEN);
            Precio = itemView.findViewById(R.id.PRECIO);

        }
    }
}
