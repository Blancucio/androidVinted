package com.example.vinted.entities.usuario;

import com.google.gson.annotations.SerializedName;

    public class Usuario {
        @SerializedName("ID_USUARIO")
        private int id_usuario;
        @SerializedName("NOMBRE")
        private String nomrbe;
        @SerializedName("NUM_VENTAS")
        private int num_ventas;

        public Usuario() {
        }

        public Usuario(int id_usuario, String nomrbe, int num_ventas) {
            this.id_usuario = id_usuario;
            this.nomrbe = nomrbe;
            this.num_ventas = num_ventas;
        }

        public int getId_usuario() {
            return id_usuario;
        }

        public void setId_usuario(int id_usuario) {
            this.id_usuario = id_usuario;
        }

        public String getNomrbe() {
            return nomrbe;
        }

        public void setNomrbe(String nomrbe) {
            this.nomrbe = nomrbe;
        }

        public int getNum_ventas() {
            return num_ventas;
        }

        public void setNum_ventas(int num_ventas) {
            this.num_ventas = num_ventas;
        }
    }

