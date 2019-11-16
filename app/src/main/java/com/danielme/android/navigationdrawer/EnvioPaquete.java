package com.danielme.android.navigationdrawer;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.cpinedae.movilidad.adaptador.ConexionSQLiteHelper;
import com.cpinedae.movilidad.modelo.Guia;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvioPaquete extends Fragment {

    private static final String TEXT = "text";
    private Button btnCamara, btnGuardarDatos;
    private EditText txtAreaDescrip;
   // private TextView tvNomRem, tvTelRem, tvNomDes, tvDirDes, tvTelDes, tvNoGuia;


    public EnvioPaquete() {
        // Required empty public constructor
    }

    public static EnvioPaquete newInstances(String string) {
        EnvioPaquete envioPaquete = new EnvioPaquete();
        Bundle bundle = new Bundle();
        bundle.putString(TEXT, string);
        envioPaquete.setArguments(bundle);
        return envioPaquete;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().setTitle("Envio");

        View view = inflater.inflate(R.layout.fragment_envio_paquete, container, false);
        btnCamara = view.findViewById(R.id.btnCamara);
        btnGuardarDatos = view.findViewById(R.id.btnGuardarDatos);


        if (getArguments() != null) {
            Guia guia = new Guia();
            guia = obtenerGuia(getArguments().getString(TEXT));
            if (guia != null) {

                ((TextView) view.findViewById(R.id.text)).setText(getArguments().getString(TEXT));
            }

        }


        return view;
    }

    public Guia obtenerGuia(String noGuia) {
        Guia guia = new Guia();
        try {
            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_Movilidad", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            Cursor fila = db.rawQuery("select no_guia, nomrem, nomdes, dirrem, dirdes, telrem, teldes from guia where no_guia ="+noGuia, null);
            if (fila.moveToFirst()) {
                guia.setNoGuia(fila.getString(0));
                guia.setNomdes(fila.getString(1));
                guia.setNomdes(fila.getString(2));
                guia.setDirrem(fila.getString(3));
                guia.setDirdes(fila.getString(4));
                guia.setTelrem(fila.getString(5));
                guia.setTeldes(fila.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error, no fue posible acceder a la base de datos");
            e.printStackTrace();
        }

        return guia;
    }

}
