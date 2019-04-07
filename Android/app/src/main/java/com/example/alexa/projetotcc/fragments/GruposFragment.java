package com.example.alexa.projetotcc.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexa.projetotcc.R;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class GruposFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> grupos;


    public static  GruposFragment newInstance(){
        return new GruposFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instanciar objetos
        grupos = new ArrayList<>();
        grupos.add("lalala");
        grupos.add("kakak");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grupos, container, false);

        listView = (ListView) view.findViewById(R.id.list_grupos);

        adapter = new ArrayAdapter(
                getActivity(),
                R.layout.lista_grupo,
                grupos
        );
        listView.setAdapter(adapter);

        //Recuperar os grupos criados do banco de dados


        return  view;


    }

}
