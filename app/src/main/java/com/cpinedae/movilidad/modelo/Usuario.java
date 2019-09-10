package com.cpinedae.movilidad.modelo;

public class Usuario {
    private String nomRuta;
    private String usuario;
    private String contraseña;

    public Usuario() {
    }

    public String getNomRuta() {
        return nomRuta;
    }

    public void setNomRuta(String nomRuta) {
        this.nomRuta = nomRuta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
