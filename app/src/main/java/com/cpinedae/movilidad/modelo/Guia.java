package com.cpinedae.movilidad.modelo;

public class Guia {
    private String noGuia;
    private String nomDes;
    private String dirDes;
    private String teldes;

//    public Guia() {
//
//    }

    public Guia(String noGuia, String nomDes, String dirDes, String teldes) {
        this.noGuia = noGuia;
        this.nomDes = nomDes;
        this.dirDes = dirDes;
        this.teldes = teldes;
    }

    public String getNoGuia() {
        return noGuia;
    }

    public void setNoGuia(String noGuia) {
        this.noGuia = noGuia;
    }

    public String getNomDes() {
        return nomDes;
    }

    public void setNomDes(String nomDes) {
        this.nomDes = nomDes;
    }

    public String getDirDes() {
        return dirDes;
    }

    public void setDirDes(String dirDes) {
        this.dirDes = dirDes;
    }

    public String getTeldes() {
        return teldes;
    }

    public void setTeldes(String teldes) {
        this.teldes = teldes;
    }
}
