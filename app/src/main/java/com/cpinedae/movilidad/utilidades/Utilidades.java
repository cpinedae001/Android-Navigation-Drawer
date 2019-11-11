package com.cpinedae.movilidad.utilidades;

public class Utilidades {

    public static final String TABLA_CONFIG_CONEXION = "configuracionConexion";//"create table configuracion (direccionIP TEXT)";
    public static final String CAMPO_DIRECCION_IP= "direccion_ip";

    public static final String CREA_TABLA_CONFIG ="CREATE TABLE "+TABLA_CONFIG_CONEXION+" ("+CAMPO_DIRECCION_IP+" TEXT )";
    /*Seccion para crear los usuarios*/
    public static final String campoUsuario="user";
    public static final String campoRuta = "ruta";
    public static final String campoContraseña = "password";
    public static final String TABLA_USUARIO = "tblUsuario";
    public static final String CREA_TABLA_USUARIO = "create table " +" "+TABLA_USUARIO+ " ("+campoUsuario + " TEXT, "+campoRuta +" TEXT, " + campoContraseña +" TEXT)";
}
