package com.cpinedae.movilidad.modelo;

public class Configuracion {
    private String DIRECCIONIP = "";


    public Configuracion(String DIRECCIONIP) {
        this.DIRECCIONIP = DIRECCIONIP;
    }

    public Configuracion() {

    }

    public String getDIRECCIONIP() {
        return DIRECCIONIP;
    }

    public void setDIRECCIONIP(String DIRECCIONIP) {
        this.DIRECCIONIP = DIRECCIONIP;
    }
}
