package com.example.vinted.entities.compra;


import com.google.gson.annotations.SerializedName;

public class Compra {
        @SerializedName("ID_COMPRA")
        private int id_compra;
        @SerializedName("ID_USUARIO")
        private int id_usuario;
        @SerializedName("ID_PRODUCTO")
        private int id_producto;
        @SerializedName("EMAIL")
        private String email;
        @SerializedName("NOTIFICACION_COMPRA")
        private String notificacion_compra;

        public Compra() {
        }

        public Compra(int id_compra, int id_usuario, int id_producto, String email, String notificacion_compra) {
            this.id_compra = id_compra;
            this.id_usuario = id_usuario;
            this.id_producto = id_producto;
            this.email = email;
            this.notificacion_compra = notificacion_compra;
        }

        public int getId_compra() {
            return id_compra;
        }

        public void setId_compra(int id_compra) {
            this.id_compra = id_compra;
        }

        public int getId_usuario() {
            return id_usuario;
        }

        public void setId_usuario(int id_usuario) {
            this.id_usuario = id_usuario;
        }

        public int getId_producto() {
            return id_producto;
        }

        public void setId_producto(int id_producto) {
            this.id_producto = id_producto;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNotificacion_compra() {
            return notificacion_compra;
        }

        public void setNotificacion_compra(String notificacion_compra) {
            this.notificacion_compra = notificacion_compra;
        }
    }

