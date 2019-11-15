package com.cpinedae.movilidad.modelo;

import java.util.ArrayList;
import java.util.List;

public class Guia {
    private String noGuia;
    private String fecha;
    private String nomRem;
    private String nomDes;
    private String dirRem;
    private String dirDes;
    private String telRem;
    private String teldes;
    private String entregado;
    private String ruta;
    private String transmitido;
    private List<ImagenGuia> listImgGui = new ArrayList<>();

    public Guia() {

    }

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNomRem() {
        return nomRem;
    }

    public void setNomRem(String nomRem) {
        this.nomRem = nomRem;
    }

    public String getDirRem() {
        return dirRem;
    }

    public void setDirRem(String dirRem) {
        this.dirRem = dirRem;
    }

    public String getTelRem() {
        return telRem;
    }

    public void setTelRem(String telRem) {
        this.telRem = telRem;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTransmitido() {
        return transmitido;
    }

    public void setTransmitido(String transmitido) {
        this.transmitido = transmitido;
    }

    public List<ImagenGuia> getListImgGui() {
        return listImgGui;
    }

    public void setListImgGui(List<ImagenGuia> listImgGui) {
        this.listImgGui = listImgGui;
    }
}
