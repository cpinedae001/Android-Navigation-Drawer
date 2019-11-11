package com.danielme.android.navigationdrawer;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.cpinedae.movilidad.adaptador.ConexionSQLiteHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sincronizar extends Fragment {

    private static final String TEXT = "text";
    private Button btnBajarDatos, btnSubirDatos;

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

        final ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_Movilidad", null, 1);
        btnBajarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db = conn.getWritableDatabase();

                    Cursor fila = db.rawQuery("select ruta from usuario ", null);
                    if (fila.moveToFirst()
                    ) {
                        Toast.makeText(getContext(), "Ruta "+fila.getString(0),Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        return view;
    }


}
