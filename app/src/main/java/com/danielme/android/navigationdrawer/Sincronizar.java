package com.danielme.android.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sincronizar extends Fragment {

    private static final String TEXT = "text";

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
        View view = inflater.inflate(R.layout.fragment_sincronizar, container, false);
        return view;
    }

}
