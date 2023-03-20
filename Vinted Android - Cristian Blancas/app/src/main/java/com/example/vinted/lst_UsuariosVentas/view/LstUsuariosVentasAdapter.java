package com.example.vinted.lst_UsuariosVentas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.entities.usuario.Usuario;

import java.util.ArrayList;

public class LstUsuariosVentasAdapter extends RecyclerView.Adapter<LstUsuariosVentasAdapter.ViewHolder> {
    private ArrayList<Usuario> dataset;
    private Context mContext;

    public LstUsuariosVentasAdapter(Context mContext, ArrayList<Usuario> lstUsuario){
        this.dataset = lstUsuario;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_usuario_bueno,parent,false);
        return new ViewHolder(view);
    }

    //RECOGER DATOS DEL FRONT
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Usuario r = dataset.get(position);

        holder.idUsuario.setText(String.valueOf(r.getId_usuario()));
        holder.Nombre.setText(r.getNomrbe());
        holder.NumVentas.setText(String.valueOf(r.getNum_ventas()));

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView idUsuario;
        private TextView Nombre;
        private TextView NumVentas;

        public ViewHolder(View itemView) {
            super(itemView);

            idUsuario = itemView.findViewById(R.id.ID_USUARIO2);
            Nombre = itemView.findViewById(R.id.NOMBRE2);
            NumVentas = itemView.findViewById(R.id.VENTAS2);
        }
    }
}
