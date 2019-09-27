package com.danielme.android.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvioPaquete extends Fragment {

    private static final String TEXT = "text";
    private Button btnGuadar;

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

        if (getArguments() != null) {
            ((TextView) view.findViewById(R.id.text)).setText(getArguments().getString(TEXT));
        }

        btnGuadar = view.findViewById(R.id.btnGuadar);
        btnGuadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "hola", Toast.LENGTH_LONG);
                toast.show();


            }
        });
        return view;
    }

}
