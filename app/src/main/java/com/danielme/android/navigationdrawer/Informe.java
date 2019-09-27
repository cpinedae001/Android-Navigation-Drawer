package com.danielme.android.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Informe extends Fragment {

    private static final String TEXT = "text";

    public Informe() {
        // Required empty public constructor
    }

    public static Informe newInstance(String text) {
        Informe frag = new Informe();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().setTitle("Informe");
        View view = inflater.inflate(R.layout.fragment_informe, container, false);
        return view;
    }

}
