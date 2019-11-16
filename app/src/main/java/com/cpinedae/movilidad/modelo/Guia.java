package com.cpinedae.movilidad.modelo;

import java.util.ArrayList;
import java.util.List;

public class Guia {
    private String noGuia;
    private String fecha;
    private String nomrem;
    private String nomdes;
    private String dirrem;
    private String dirdes;
    private String telrem;
    private String teldes;
    private String entregado;
    private String idImagenGuia;
    private String ruta;
    private String transmitido;
    private List<ImagenGuia> listImgGui = new ArrayList<>();

    public Guia() {

    }

    public Guia(String noGuia, String nomDes, String dirDes, String teldes) {
        this.noGuia = noGuia;
        this.nomdes = nomDes;
        this.dirdes = dirDes;
        this.teldes = teldes;
    }

    public String getNoGuia() {
        return noGuia;
    }

    public void setNoGuia(String noGuia) {
        this.noGuia = noGuia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNomrem() {
        return nomrem;
    }

    public void setNomrem(String nomrem) {
        this.nomrem = nomrem;
    }

    public String getNomdes() {
        return nomdes;
    }

    public void setNomdes(String nomdes) {
        this.nomdes = nomdes;
    }

    public String getDirrem() {
        return dirrem;
    }

    public void setDirrem(String dirrem) {
        this.dirrem = dirrem;
    }

    public String getDirdes() {
        return dirdes;
    }

    public void setDirdes(String dirdes) {
        this.dirdes = dirdes;
    }

    public String getTelrem() {
        return telrem;
    }

    public void setTelrem(String telrem) {
        this.telrem = telrem;
    }

    public String getTeldes() {
        return teldes;
    }

    public void setTeldes(String teldes) {
        this.teldes = teldes;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getIdImagenGuia() {
        return idImagenGuia;
    }

    public void setIdImagenGuia(String idImagenGuia) {
        this.idImagenGuia = idImagenGuia;
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
