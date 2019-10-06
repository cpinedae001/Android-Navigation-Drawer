package com.cpinedae.movilidad.Tareas;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TareaConsultaUsuarioWS  {
    final String NAMESPACE = "http://servicio.guatex.com/";
    final String URL = "http://192.168.0.36:8080/WSMovilidad/Servicio?WSDL";
    final String METHOD_NAME ="consultaUsuario";
    final String SOAP_ANTION ="http://servicio.guatex.com/";
    String activo = "";

public String invokeUsuario (String usuario, String password, Integer codRuta){
    SoapObject request= new SoapObject(NAMESPACE, "consultaUsuario");
    PropertyInfo sayHelloPI = new PropertyInfo();
    sayHelloPI.setName("usuario");
    String parametro = usuario;
    sayHelloPI.setValue(parametro);

    PropertyInfo sayHelloPI2= new PropertyInfo();
    sayHelloPI2.setName("contrasena");
    String parametro2 = password;
    sayHelloPI2.setValue(parametro2);

    PropertyInfo sayHelloPI23= new PropertyInfo();
    sayHelloPI23.setName("codRuta");
    int codruta = codRuta;
    sayHelloPI23.setValue(codruta);

    request.addProperty(sayHelloPI);
    request.addProperty(sayHelloPI2);
    request.addProperty(sayHelloPI23);

    // Create envelope
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    new MarshalBase64().register(envelope);
    // Set output SOAP object
    envelope.setOutputSoapObject(request);
    // Create HTTP call object
    //HttpsTransportSE androidHttpTransport = new KeepAliveHttpsTransportSE(URL,443,"",1800000);
    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL,1800000);
    try {
        Log.i("TAG", "Antes de enviar....");
        androidHttpTransport.call(SOAP_ANTION + "consultaUsuario", envelope);
        Log.i("TAG","DEVOLVIENDO 1....");
        SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
        activo = response.toString();

        Log.i("Tag", "resultado WS["+activo+"]");
    }catch (Exception e){
        e.printStackTrace();
        activo="Error al conectar" +e.getMessage();
    }
    return activo;
}



}
