package com.danielme.android.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Configuracion extends Fragment {

    private static final String TEXT = "text";

    private static final String usuarioAdmi = "admin";
    private static final String contraseña = "01";
    boolean activo = false;
    private Button btnIngresar, btnTest, btnGuardar;
    private TextView txUsuario;
    private TextView txContraseña;
    private TextView txdireccionIP;
    private TextView txtDireccionActual;

    public Configuracion() {
        // Required empty public constructor
    }

    public static Configuracion newInstance(String text) {
        Configuracion frag = new Configuracion();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().setTitle("Configuración");
        View view = inflater.inflate(R.layout.fragment_configuracion, container, false);
        btnIngresar = view.findViewById(R.id.btnIngresar);
        //btnGuardar = view.findViewById(R.id.btnGuadar);
        btnTest = view.findViewById(R.id.btnTest);
        txUsuario = view.findViewById(R.id.txUsuario);
        txContraseña = view.findViewById(R.id.txContraseña);
        txdireccionIP = view.findViewById(R.id.txdireccionIP);
        txtDireccionActual = view.findViewById(R.id.txtDireccionActual);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txUsuario.getText().toString().trim().equals(usuarioAdmi) &&
                        txContraseña.getText().toString().trim().equals(contraseña)) {
                    activo = true;
                    Toast toast = Toast.makeText(getContext(), "Configuracion exitosa", Toast.LENGTH_LONG);
                    toast.show();
                    txUsuario.setText("");
                    txContraseña.setText("");
                    txdireccionIP.requestFocus();
                } else {
                    activo = false;
                    Toast toast = Toast.makeText(getContext(), "Usuario y contraseña no validos", Toast.LENGTH_LONG);
                    toast.show();
                    System.out.println(txUsuario.getText().toString().trim());
                    System.out.println(txContraseña.getText().toString().trim());
                    txUsuario.setText("");
                    txContraseña.setText("");
                    txUsuario.requestFocus();
                }

            }
        });
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activo) {
                    if (!txdireccionIP.getText().toString().trim().equals("")) {
                        Toast toast = Toast.makeText(getContext(), "Text", Toast.LENGTH_LONG);
                        toast.show();
                        txtDireccionActual.requestFocus();
                    } else {
                        Toast toast = Toast.makeText(getContext(), "Debe ingresar la dirección del servidor.", Toast.LENGTH_LONG);
                        toast.show();
                        txdireccionIP.requestFocus();
                    }
                }else{
                    Toast toast = Toast.makeText(getContext(), "Usuario no valido.", Toast.LENGTH_LONG);
                    toast.show();
                    txdireccionIP.setText("");
                }

            }
        });
        return view;
    }


}
