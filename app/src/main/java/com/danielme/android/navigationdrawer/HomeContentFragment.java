package com.danielme.android.navigationdrawer;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cpinedae.movilidad.adaptador.ConexionSQLiteHelper;
import com.cpinedae.movilidad.adaptador.Lista_adaptador;
import com.cpinedae.movilidad.modelo.Guia;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dani on 28/12/16.
 */
public class HomeContentFragment extends Fragment {


    private static final String TEXT = "text";
    private ListView lvListaPaquetes;

    ArrayList<Guia> listaGuias;

    public static HomeContentFragment newInstance(String text) {
        HomeContentFragment frag = new HomeContentFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        //getActivity().setTitle("Agenda");

        View layout = inflater.inflate(R.layout.home_fragment, container, false);
        lvListaPaquetes = layout.findViewById(R.id.lvLista);
        listaGuias = new ArrayList<>();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_Movilidad", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor fila = db.rawQuery("select no_guia, nomrem, nomdes, dirrem, dirdes, telrem, teldes from guia", null);
        while (fila.moveToNext()){
            Guia guia = new Guia();
            guia.setNoGuia(fila.getString(0));
            guia.setNomrem(fila.getString(1));
            guia.setNomdes(fila.getString(2));
            guia.setDirrem(fila.getString(3));
            guia.setDirdes(fila.getString(4));
            guia.setTelrem(fila.getString(5));
            guia.setTeldes(fila.getString(6));
            listaGuias.add(guia);
        }
        db.close();
        //listaGuias.add(new Guia("A0000000000", "Cristhian Pineda", "Guatemala", "54045612"));
        //listaGuias.add(new Guia("A0000000001", "Carol", "Guatemala", "42282440"));

        if (listaGuias !=null && !listaGuias.isEmpty()) {
            System.out.println("hay datos en la lista");
//            ((TextView) layout.findViewById(R.id.text)).setText(getArguments().getString(TEXT));


            lvListaPaquetes.setAdapter(new Lista_adaptador(getActivity(),R.layout.itemlist, listaGuias) {
                @Override
                public void onEntrada(Object entrada, View view) {
                   if(entrada!=null){
                       TextView textGuia = view.findViewById(R.id.noguia);
                       if(textGuia!= null){
                           textGuia.setText("   "+((Guia) entrada).getNoGuia());
                       }
                       TextView textNomdes = view.findViewById(R.id.detinatario);
                       if(textNomdes!=null){
                           textNomdes.setText("   Destinatario: "+((Guia) entrada).getNomdes());
                       }
                       TextView textDirdes = view.findViewById(R.id.direccion);
                       if(textDirdes!=null){
                           textDirdes.setText("   Dirección: "+((Guia) entrada).getDirdes());
                       }
                       TextView textTel = view.findViewById(R.id.telefono);
                       textTel.setText("   Teléfono: "+((Guia) entrada).getTeldes());
                   }else{
                       System.out.println("entrada es null");
                   }
                }
            });
        }
//        ArrayAdapter<Guia> arrayAdapter = new ArrayAdapter<Guia>(getActivity(), R.layout.itemlist, listaGuias);
//        lvListaPaquetes.setAdapter(arrayAdapter);


        lvListaPaquetes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Guia guia = (Guia) parent.getItemAtPosition(position);
                CharSequence texto = "Seleccionado: "+guia.getNoGuia();
                Toast.makeText(getActivity(), texto, Toast.LENGTH_LONG).show();
                //Fragment fragmentEnvio = EnvioPaquete.newInstances("Detalle del envio");
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.home_content, new EnvioPaquete());
//                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                transaction.addToBackStack(null);
//
//
//                transaction.commit();
                Bundle bundle = new Bundle();
                bundle.putString("key_guia", guia.getNoGuia());
                Fragment fragment = new EnvioPaquete();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_content, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return layout;
    }
}

