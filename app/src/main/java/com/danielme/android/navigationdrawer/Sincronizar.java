package com.danielme.android.navigationdrawer;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cpinedae.movilidad.Tareas.TareaConsultaUsuarioWS;
import com.cpinedae.movilidad.adaptador.ConexionSQLiteHelper;
import com.cpinedae.movilidad.modelo.Guia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sincronizar extends Fragment {

    private static final String TEXT = "text";
    private Button btnBajarDatos, btnSubirDatos;
    private String resulatado = "";
    private String codRuta;
    private TextView tvFechaBajo;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:sss", Locale.getDefault());

    public Sincronizar() {
        // Required empty public constructor
    }

    public static Sincronizar newInstance(String text) {
        Sincronizar frag = new Sincronizar();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().setTitle("Sincronizar");

        final View view = inflater.inflate(R.layout.fragment_sincronizar, container, false);

        btnBajarDatos = view.findViewById(R.id.btnBajarDatos);
        btnSubirDatos = view.findViewById(R.id.btnSubirDatos);
        tvFechaBajo = view.findViewById(R.id.tvFechaBajo);
        final ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_Movilidad", null, 1);
        btnBajarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = conn.getWritableDatabase();

                    Cursor fila = db.rawQuery("select ruta from usuario ", null);
                    if (fila.moveToFirst()
                    ) {
                        codRuta = fila.getString(0);
                        AsyncCallWS task = new AsyncCallWS();
                        task.execute();
                        Toast.makeText(getContext(), "Ruta " + codRuta, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        return view;
    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            TareaConsultaUsuarioWS consultaUsuario = new TareaConsultaUsuarioWS();

            String respuesta = consultaUsuario.traerGuias(codRuta);
            Log.i("TAG", "Respuesta del WSMovil es [" + respuesta + "]");
            resulatado = respuesta.replace("<activo>", "").replace("</activo>", "");
            System.out.println("Respuesta del ws........" + resulatado);


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            insertarDAtos();

        }
    }

    public void insertarDAtos() {
        try {
            resulatado = resulatado.replace("<guias>", "");
            resulatado = resulatado.replace("</guias>", "");
            Gson gson = new Gson();
            Type tipoLisGuia = new TypeToken<List<Guia>>(){

            }.getType();
            List<Guia> listGui = gson.fromJson(resulatado, tipoLisGuia);
            Toast.makeText(getContext(), "Cantidad de guias descargadas: "+listGui.size(), Toast.LENGTH_SHORT).show();
            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_Movilidad", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            int borrar = db.delete("guia",null, null);
            for(Guia obj: listGui){

                ContentValues registro = new ContentValues();
                registro.put("no_guia", obj.getNoGuia());
                registro.put("fecha", obj.getFecha());
                registro.put("nomrem", obj.getNomrem());
                registro.put("nomdes", obj.getNomdes());
                registro.put("dirrem", obj.getDirrem());
                registro.put("dirdes", obj.getDirdes());
                registro.put("telrem", obj.getTelrem());
                registro.put("teldes", obj.getTeldes());
                registro.put("entregado", "");
                registro.put("ruta", obj.getRuta());
                registro.put("transmitido", "N");
                db.insert("guia", null, registro);

            }
            db.close();
            Date date = new Date();
            tvFechaBajo.setText(dateFormat.format(date));
            Toast.makeText(getContext(), "Guias insertadas", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String obtenerDatos() {
        String respuesta = "";
        return respuesta;
    }

}
